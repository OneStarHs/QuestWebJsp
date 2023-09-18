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
function confirmDelete(reg_Num) {
	  if (confirm("삭제하시겠습니까?")) {
	    // 삭제를 확인한 경우 처리할 로직을 작성합니다.
	    // 여기에서는 NoticeServlet을 호출하여 삭제를 수행하는 예시입니다.
	    window.location.href = "NoticeServlet?command=admin_order_delete&reg_Num=" + reg_Num;
	  }
	}
function updateTracking(reg_Num, tracking) {
	  if (confirm("배송상태를 변경하시겠습니까?")) {     
	        location.href = "NoticeServlet?command=admin_order_tracking_update&reg_Num=" + reg_Num + "&tracking=" + tracking;
	    } else {
	    	location.href = "NoticeServlet?command=admin_order_list";
	    }
}
function change(a) {
	//console.log(a);
	//console.log(a.value);
	location.href = "NoticeServlet?command=admin_order_list&pageNum=1&amount="
			+ a.value;
}
	
</script>
</head>
<body>
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
						<option value="10" ${pageVO.amount eq 10 ? 'selected' : '' }>10개씩
							보기</option>
						<option value="20" ${pageVO.amount eq 20 ? 'selected' : '' }>20개씩
							보기</option>
						<option value="50" ${pageVO.amount eq 50 ? 'selected' : '' }>50개씩
							보기</option>
						<option value="100" ${pageVO.amount eq 100 ? 'selected' : '' }>100개씩
							보기</option>
					</select>
				</div>
			</td>
		    </tr>
	    	
			<tr>
			<th class="th-num">번호</th>
			<th class="th-title">접수자 ID</th>
			<th class="th-date">보내는 곳</th>
			<th class="th-date">받는 곳</th>
			<th class="th-date">결제상황</th>
			<th class="th-date">배송상황</th>
			</tr>

	    
	    
		<c:forEach items="${acceptedList}" var="acceptedVO">
			<tr class="record">
			 <td>${acceptedVO.reg_Num}</td>
			 <td>${acceptedVO.user_ID}</td>
			 <td>${acceptedVO.dep_Add2}</td>
			 <td>${acceptedVO.arr_Add2}</td>
			 <td>
			<c:choose>
             <c:when test="${acceptedVO.user_PayS eq '카드결제'}">결제완료</c:when>
             <c:when test="${acceptedVO.user_PayS eq '계좌이체'}">결제완료</c:when>
             <c:when test="${acceptedVO.user_PayS eq '선불'}">선불</c:when>
             
             <c:otherwise>착불</c:otherwise>
			</c:choose>
			</td>
			
			<td>
			 <select onchange="updateTracking('${acceptedVO.reg_Num}', this.value)">
				<option value="1" ${acceptedVO.tracking eq 1 ? 'selected' : '' }>접수대기</option>
				<option value="2" ${acceptedVO.tracking eq 2 ? 'selected' : '' }>접수완료</option>
				<option value="3" ${acceptedVO.tracking eq 3 ? 'selected' : '' }>배송출발</option>
				<option value="4" ${acceptedVO.tracking eq 4 ? 'selected' : '' }>배송완료</option>
		     </select>
			</td>
			
			<td><a href="javascript:confirmDelete('${acceptedVO.reg_Num}')">접수 취소</a></td>
			</tr>
		</c:forEach>
		<tr>
		<td colspan="5" align="center" class="paging">
			<ul class="pagination">

				<!-- 2. 이전버튼 활성화 여부 -->
				<c:if test="${pageVO.prev }">
					<li><a
						href="NoticeServlet?command=admin_order_list&pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}">이전</a></li>
				</c:if>

				<!-- 1. 페이지번호 처리 -->
				<c:forEach var="num" begin="${pageVO.startPage }"
					end="${pageVO.endPage }">
					<li class="${pageVO.pageNum eq num ? 'active' : '' }"><a
						href="NoticeServlet?command=admin_order_list&pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
				</c:forEach>

				<!-- 3. 다음버튼 활성화 여부 -->
				<c:if test="${pageVO.next }">
					<li><a
						href="NoticeServlet?command=admin_order_list&pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
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