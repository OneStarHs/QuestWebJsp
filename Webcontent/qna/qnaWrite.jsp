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
<link rel="stylesheet" type="text/css" href="css/qna.css">
<script type="text/javascript" src="script/qna.js"></script>
</head>
<body>
	<%@ include file="../header/header.jsp"%>
	<div class="clear"></div>
	<div class="color1">
		<section id="top">
			<div class="Notice">
				<h2>1:1 고객 게시판</h2>
			</div>
			<div class="search-window"></div>
		</section>
	</div>
	<div class="clear"></div>
	<div class="free">
		<div class="qnawrite" align=center>
			<form name="formm" method="post" action="NoticeServlet?command=qna_write">
	
			<table class="qnatbl">
				<thead>
					<tr>
						<th scope="row" colspan="2" class="pd0">
							<div class="common-table-top">
								<strong></strong>
							</div>
						</th>
					</tr>
				</thead>
				<tr class="qnatop">
					<th>
					<label>제목<span class="common-ico">
					<span class="hidden">필수 입력 항목입니다.</span>
					*</span>
					</label>
					</th>
					<td>
					<div class="qna_box">						 
					<input class=qnatitle type="text" name="qna_Title" size="77">
					</div>
					</td>
				</tr>
				<tr class="qnamiddle">
					<th><label>내용<span class="common-ico">
					<span class="hidden">필수 입력 항목입니다.</span>*</span></label></th>
					<td><div class="qna-box">
							<textarea rows="8" cols="69" name="qna_Content"></textarea>
						</div></td>
				</tr>
				
			</table>
		
		
		
			<div class="clear"></div>
			
				<div id="buttons">
				<span id="btn_qna"><input type="button" value="취소" class="cancel" onclick="goBack()" > </span>
				<span id="btn_qna"> <input type="submit" value="등록" class="submit" onclick="return qnaCheck()"></span>
				</div>			
			</form>
			</div>
	
	</div>


	<%@ include file="../footer/footer.jsp"%>
</body>
</html>