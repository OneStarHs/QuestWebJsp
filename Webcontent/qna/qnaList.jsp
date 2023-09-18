<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 
    <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon"> 
<link rel="stylesheet" type="text/css"  href="css/munmun.css">

    <link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">

<script>
	function change(a) {
		//console.log(a);
		//console.log(a.value);
		location.href = "NoticeServlet?command=qna_list&pageNum=1&amount="+ a.value;
	}
	function go_view(qseq) {
		 var theForm = document.frm;
		 theForm.qseq.value = qseq;
		 theForm.action = "NonageServlet?command=qna_detail";
		 theForm.submit();
		 }
</script>
</head>
<body>
<%@ include file="../header/header.jsp" %> 

<div class="color1">
        <section id="top">
    <div class="Notice">
        <h2>문의내역</h2>
    </div>
    <div class="search-window">
        </div>
       </section>
   </div>   
   
   
	<div class="free">
	
	 <section id="left_main">        
    <aside id="left">
        <div id="title">
            <a href="mypage.do" style="color:white">마이 페이지</a>
        </div>      
        <ul class="secu">
            <li><a href="memberUpdate.do">개인정보 수정</a></li>            
            <li><a href="NoticeServlet?command=qna_list">문의 내역</a></li>          
            <li><a href="memberDelete.do">회원탈퇴</a></li>                                  
        </ul>
    </aside>
    </section>
	
	    <section id="right_main">
        <div id="right">
		<div id="board-listq">
			<div class="container">
			<form name="formm" method="post">
				<table class="board-tableq">
					<tr>
					<td style="border: 1px #ffff;">
					<div>
					<select onchange="change(this)">
					  <option value="10" ${pageVO.amount eq 10 ? 'selected' : '' }>10개씩 보기</option>
					  <option value="20" ${pageVO.amount eq 20 ? 'selected' : '' }>20개씩 보기</option>
					  <option value="50" ${pageVO.amount eq 50 ? 'selected' : '' }>50개씩 보기</option>
					  <option value="100"${pageVO.amount eq 100 ? 'selected' : '' }>100개씩 보기</option>
					</select>
					</div>
					</td>
					</tr>
					<tr>
					  <th class="th-num">답변 여부</th>
					  
					  <th class="th-title">제목</th>
					  <th class="th-date">등록일</th>
					</tr>
					<c:forEach items="${qnaList}" var="qnaVO">
					  <tr>
						<td>
						<c:choose>
								<c:when test="${qnaVO.qna_Rep==1}"> no </c:when>
								<c:when test="${qnaVO.qna_Rep==2}"> yes </c:when>
						</c:choose>
						</td>	
											
						<td><a
							href="NoticeServlet?command=qna_view&qna_Seq=${qnaVO.qna_Seq}">
								${qnaVO.qna_Title}</a></td>
						<td><fmt:formatDate value="${qnaVO.qna_Date}" type="date" /></td>
					  </tr>					
					</c:forEach>
				    <tr>
					  <td colspan="5" align="center">
			  			<ul class="pagination">     			
						<!-- 2. 이전버튼 활성화 여부 -->
						<c:if test="${pageVO.prev }">
			       		  <li><a href="NoticeServlet?command=qna_list&pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}">이전</a></li>
			            </c:if>                     		
			       		<!-- 1. 페이지번호 처리 -->
			       		<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
			        		<li  class="${pageVO.pageNum eq num ? 'active' : '' }">
			        		<a href="NoticeServlet?command=qna_list&pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
			       		</c:forEach>             		
			       		<!-- 3. 다음버튼 활성화 여부 -->
			       		<c:if test="${pageVO.next }">
			       			<li><a href="NoticeServlet?command=qna_list&pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
			       		</c:if>
			   			</ul>					
					  </td>
				    </tr>
				</table>
				<div class="clear"></div>
				<div id="buttonsq" style="float: right">
					<input type="button" value="1:1 질문하기" class="submit"
						onclick="location.href='NoticeServlet?command=qna_write_form'">
			</div>
			</form>
			
			</div>
		</div>
		</div>
		</section>
	</div>
<div class="clear" style="padding-bottom: 300px" ></div>

<%@ include file="../footer/footer.jsp" %> 
</body>
</html>