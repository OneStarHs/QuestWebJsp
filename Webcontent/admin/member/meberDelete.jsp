<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div align="center">
		<h1>삭제하시겠습니까?</h1>
		<form action="NoticeServlet" name="frm" method="get">
			<input type="hidden" name="command" value="admin_notice_delete">
			<input type="hidden" name="userid" value="${param.userid}">
			<table style="width: 80%">
				<tr>
				<td><input type="submit" value=" Yes"></td>	
				<td><input type="submit" value=" No"onclick="window.close();"></td>					
				</tr>
			</table>
			<br> 
			
			<br>
		</form>
	</div>
</body>
</html>