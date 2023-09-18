<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
<link rel="stylesheet" href="css/admin_member.css">
</head>
<body>
	<div id="miniwindow">
		<table class="Auserid">
			<c:forEach items="${memberList}" var="member">
				<tr>
					<td><h1>${member.userid}님</h1></td>
				</tr>
				<tr>
					<td><h4>회원 이름</h4></td>
					<td>${member.name}</td>
				</tr>
				<tr>
					<td><h4>회원 전화번호</h4></td>
					<td>${member.phone}</td>
				</tr>
			</c:forEach>
		</table>

		<br>
		<table class="userinfo">
			<tr>
				<td class="tbl_title" colspan="9"><h3>접수 내역</h3></td>
			</tr>
			<tr>
				<th>접수번호</th>
				<th>발송인</th>
				<th>발송지</th>
				<th>발송인 번호</th>
				<th>수신인</th>
				<th>수신인</th>
				<th>수신인 번호</th>
				<th>접수 날짜</th>
				<th>결제 수단</th>
			</tr>
			<tr>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</table>





	</div>
</body>
</html>