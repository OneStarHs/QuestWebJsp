<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nonage Admin</title>
<link rel="stylesheet" href="css/admin.css">

<script type="text/javascript">
	function worker_check() {
		if (document.frm.workId.value == "") {
			alert("아이디를 입력하세요.");
			return false;
		} else if (document.frm.workPw.value == "") {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		return true;
	}
</script>
</head>

<body>
<%@ include file="header.jsp" %> 
	<div id="wrap">

			<div id="loginform">
				<form name="frm" method="post"
					action="NoticeServlet?command=admin_login">
					<table>
						<tr>
							<td>아 이 디</td>
							<td><input type="text" name="workerId" size="10"
								value=""></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="workerPwd" size="10"
								value="admin"></td>
						</tr>
						<tr align="center">
							<td colspan="2"><input id="login_btn" type="submit"
								value="관리자 로그인" onclick="return worker_check()"><br>
							<br>
								<h4 style="color: red">${message}</h4></td>
						</tr>
					</table>
				</form>
			</div>

	</div>
</body>
</html>