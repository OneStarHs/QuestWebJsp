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
<script type="text/javascript" src="script/member.js"></script>
<script>
	function change(a) {
		//console.log(a);
		//console.log(a.value);
		location.href = "NoticeServlet?command=admin_member_list&pageNum=1&amount="
				+ a.value;
	}
</script>
</head>
<body>
<%@ include file="../header.jsp" %> 
<%@ include file="/admin/sub_menu.jsp" %>
<div class="clear"></div>
<div class="free">  
    <div id="board-list">
        <div class="container">
        
            <table class="board-table">
             <tbody>
                
                <tr>
                 <td style="border: 1px #ffff;">
                  <div>
                   <select onchange="change(this)">
				    <option value="10" ${pageVO.amount eq 10 ? 'selected' : '' }>10개씩 보기</option>
				    <option value="20" ${pageVO.amount eq 20 ? 'selected' : '' }>20개씩 보기</option>
				    <option value="50" ${pageVO.amount eq 50 ? 'selected' : '' }>50개씩 보기</option>
				    <option value="100" ${pageVO.amount eq 100 ? 'selected' : '' }>100개씩 보기</option>
			       </select>
		          </div>
                 </td>
                </tr>
                <tr>
                    <th class="th-num">회원 아이디</th>
                    <th class="th-title">회원 이름</th>
                    <th class="th-date">접수횟수</th>
                     <th class="th-date"></th>
                </tr>
                <c:forEach var="member" items="${memberList }">
				<tr class="record">
				
					<td>${member.userid}</td>
					<td>${member.name}</td>
					<td>${member.acceptedCount}</td>
					<td><a href="javascript:confirmDelete('${member.userid}')">회원삭제</a></td>			
				</tr>
			    </c:forEach>			    
				<tbody>
				<tr>
					<td colspan="5" align="center">
	               			<ul class="pagination">
	               			
	               				<!-- 2. 이전버튼 활성화 여부 -->
	               				<c:if test="${pageVO.prev }">
                        			<li><a href="NoticeServlet?command=admin_member_list&pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}">이전</a></li>
								</c:if>
								                        		
                        		<!-- 1. 페이지번호 처리 -->
                        		<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
	                        		<li  class="${pageVO.pageNum eq num ? 'active' : '' }">
	                        		<a href="NoticeServlet?command=admin_member_list&pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
                        		</c:forEach>
                        		
                        		<!-- 3. 다음버튼 활성화 여부 -->
                        		<c:if test="${pageVO.next }">
                        			<li><a href="NoticeServlet?command=admin_member_list&pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
                        		</c:if>
                    			</ul>
				    <!--	<input type="button" value="공지등록" class="btn" onclick="location.href='noticeWrite.do'">-->
					
					</td>
				</tr>
			</tbody>
			  
			    
        </table>
<!--          <div class="search-wrap">
               <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
               <button type="submit" class="btn-dark">검색</button>
        </div>-->
        </div>
        </div>
        </div>
<div class="clear"></div>


</body>
</html>