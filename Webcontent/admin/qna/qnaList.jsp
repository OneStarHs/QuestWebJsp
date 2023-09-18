<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Notice.css">
<script>
	function change(a) {
		//console.log(a);
		//console.log(a.value);
		location.href = "NoticeServlet?command=admin_qna_list&pageNum=1&amount=" + a.value;
	}
	function go_view(qna_Seq) {
		var theForm = document.frm;
		theForm.qna_Seq.value = qna_Seq;
		theForm.action = "NoticeServlet?command=admin_qna_detail";
		theForm.submit();
	}
</script>
</head>
<body style="overflow-x: hidden">
<%@ include file="../header.jsp" %> 
<%@ include file="/admin/sub_menu.jsp" %>
 <div class="free">
  <div id="board-list">
	<div class="container">
    	
		<form name="frm" method="post">
	    	<table class="board-table">
			
			<tr>
		   	 <td style="border: 1px #ffff;">
			<div>
				<select onchange="change(this)">
				<option value="10" ${pageVO.amount eq 10 ? 'selected' : '' }>10개씩 보기</option>
				<option value="20" ${pageVO.amount eq 20 ? 'selected' : '' }>20개씩 보기</option>
				<option value="50" ${pageVO.amount eq 50 ? 'selected' : '' }>50개씩 보기</option>
				<option value="100"	${pageVO.amount eq 100 ? 'selected' : '' }>100개씩 보기</option>
				</select>
			</div>
			</td>
			</tr>

			<tr>
			<th class="th-num">번호(답변여부)</th>
			<th class="th-title">제목</th>
			<th class="th-date">작성자</th>
			<th class="th-date">작성일</th>
			</tr>
		<c:forEach items="${qnaList}" var="qnaVO">
			<tr class="record">
			 <td>${qnaVO.qna_Seq}
			  <c:choose>
			  <c:when test='${qnaVO.qna_Rep=="1"}'>(미처리)</c:when>
			  <c:otherwise>(답변처리완료)</c:otherwise>
			  </c:choose>
			 </td>
			 <td><a href="NoticeServlet?command=admin_qna_detail&qna_Seq=${qnaVO.qna_Seq}">${qnaVO.qna_Title} </a></td>
			 <td>${qnaVO.user_Id}</td>
			 <td><fmt:formatDate value="${qnaVO.qna_Date}" /></td>
			</tr>
		</c:forEach>
		<tr>
		<td colspan="5" align="center" class="paging">
			<ul class="pagination">

				<!-- 2. 이전버튼 활성화 여부 -->
				<c:if test="${pageVO.prev }">
					<li><a
						href="NoticeServlet?command=admin_qna_list&pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}">이전</a></li>
				</c:if>

				<!-- 1. 페이지번호 처리 -->
				<c:forEach var="num" begin="${pageVO.startPage }"
					end="${pageVO.endPage }">
					<li class="${pageVO.pageNum eq num ? 'active' : '' }"><a
						href="NoticeServlet?command=admin_qna_list&pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
				</c:forEach>

				<!-- 3. 다음버튼 활성화 여부 -->
				<c:if test="${pageVO.next }">
					<li><a
						href="NoticeServlet?command=admin_qna_list&pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
				</c:if>
			</ul>
		   </td>
	     </tr>
		</table>
		</form>
		
			</div>
		</div>
	</div>
</body>
</html>