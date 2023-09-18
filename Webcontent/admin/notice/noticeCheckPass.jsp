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
<script type="text/javascript" src="script/notice.js"></script>
</head>
<body>
<div align="center">
		<h1>비밀번호 확인</h1>
		<form action="NoticeServlet" name="frm" method="get">
			<input type="hidden" name="command" value="admin_notice_check_pass">
			<input type="hidden" name="notice_num" value="${param.notice_num}">
			<table style="width: 80%">
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="notice_Pw" size="20"></td>
				</tr>
			</table>
			<br> <input type="submit" value=" 확 인 "
				onclick="return passCheck()"> <br>
			<br>${message}
		</form>	</div>
</body>
</html>