<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Notice_Alert.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<script type="text/javascript" src="script/notice.js"></script>
</head>
<body>
 <%@ include file="../header/header.jsp" %> 
<div class="clear"></div>
<div class="free"> 

<div class="Notice_container">
		<h1>공지 등록</h1>
			<div class="Notice_content2">
		    <form name="frm" method="post" enctype="multipart/form-data" action="NoticeServlet">
			<input type="hidden" name="command" value="notice_write">
			<table>
				<tr>
					<th>제 목</th>
					<td><input type="text" size="70" name="notice_Title"> * 필수</td>
				</tr>
				<tr>
					<th>선택</th>
					<td>
					<input type="radio" name="notice_Type" value="1" checked="checked"> 주요공지
					<input type="radio" name="notice_Type" value="2"> 공지사항
					<input type="radio" name="notice_Type" value="3"> 이벤트
					</td>
					
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea cols="70" rows="15" name="notice_Content"></textarea></td>
				</tr>
				<tr>
					<th>사 진</th>
					<td><input type="file" name="notice_img"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="notice_Pw"> * 필수 (게시물 수정 삭제시 필요합니다.)</td>
				</tr>
			</table>
			
			<br>
			<br> 
			<div class="btn_box">
			  <input type="submit" value="등록" class="btn" onclick="return noticeCheck()"> 
			  <input type="reset" value="다시 작성" class="btn"> 
			  <input type="button" value="목록" class="btn" onclick="location.href='NoticeServlet?command=notice_list'">
		    </div>
		</form>
		</div>
		
	</div>
	</div>
	<div class="clear"></div>
<%@ include file="../footer/footer.jsp" %> 
</body>
</html>