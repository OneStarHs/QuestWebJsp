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
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<script type="text/javascript" src="script/notice.js"></script>
</head>
<body>
<%@ include file="../header/header.jsp" %> 
<div id="wrap" align="center">
		<h1>공지 수정</h1>
		<form name="frm" method="post" action="NoticeServlet">
			<input type="hidden" name="command" value="notice_update">
			<input type="hidden" name="notice_num" value="${nVo.notice_num}">
			<table>
				<tr>
					<th>제 목</th>
					<td><input type="text" size="70" name="notice_Title"
						value="${nVo.notice_Title}">* 필수</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="user_Name" value="${nVo.user_Name}">* 필수</td>
				</tr>
				<tr>
					<th>선택</th>
					<td>
					<c:choose>
						<c:when test="${nVo.notice_Type==1}">
							<input type="radio" name="notice_Type" value="1" checked="checked"> 주요공지
					        <input type="radio" name="notice_Type" value="2"> 공지사항
					        <input type="radio" name="notice_Type" value="3"> 이벤트
                        </c:when>
						<c:when test="${nVo.notice_Type==2}">
							<input type="radio" name="notice_Type" value="1" > 주요공지
					        <input type="radio" name="notice_Type" value="2" checked="checked"> 공지사항
					        <input type="radio" name="notice_Type" value="3"> 이벤트
                        </c:when>
                        <c:otherwise>
							<input type="radio" name="notice_Type" value="1" > 주요공지
					        <input type="radio" name="notice_Type" value="2" > 공지사항
					        <input type="radio" name="notice_Type" value="3" checked="checked"> 이벤트
                        </c:otherwise>
					</c:choose>
					</td>
					
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea cols="70" rows="15" name="notice_Content">${notice.notice_Content }</textarea></td>
				</tr>
				<tr>
					<th>사 진</th>
					<td><c:choose>
					<c:when test="${empty notice.notice_img}">					   
                    <img src='abc.jpg' onerror="this.style.display='none'" alt='' />
					</c:when>
					<c:otherwise>
					<img src ="upload/${product.pictureUrl}">
					</c:otherwise>
					</c:choose>
					</td>
					<td><input type="file" value="파일 선택" name="notice_img">${notice.notice_img }</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="notice_Pw"> * 필수 (게시물 수정 삭제시 필요합니다.)</td>
				</tr>
			</table>
			<br>
			<br> 
			  <input type="submit" value="등록" onclick="return noticeCheck()"> 
			  <input type="reset" value="다시 작성"> 
			  <input type="button" value="목록"onclick="location.href='NoticeServlet?command=notice_list'">
		</form>
	</div>
	<%@ include file="../footer/footer.jsp" %> 
</body>
</html>