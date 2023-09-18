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
<script type="text/javascript" src="script/notice.js"></script>
</head>
<body>
<%@ include file="../header.jsp" %> 
<%@ include file="/admin/sub_menu.jsp" %>
<div class="clear"></div>

<div class="free"> 

    <div class="Notice_container" >
      <div class="Notice_content23">
          <div align="center"><h1>공지 수정</h1></div>
		
		<form name="frm" method="post" action="NoticeServlet">
			<input type="hidden" name="command" value="admin_notice_update">
			<input type="hidden" name="notice_num" value="${notice.notice_num}">
			<table  class="noticeinsert">
				<tr>
					<th>제 목</th>
					<td><input  class="noticetitle" type="text" size="70" name="notice_Title"
						value="${notice.notice_Title}">* 필수</td>
				</tr>

				<tr>
					<th>선택</th>
					<td>
					<c:choose>
						<c:when test="${notice.notice_Type==1}">
							<input type="radio" name="notice_Type" value="1" checked="checked"> 주요공지
					        <input type="radio" name="notice_Type" value="2"> 공지사항
					        <input type="radio" name="notice_Type" value="3"> 이벤트
                        </c:when>
						<c:when test="${notice.notice_Type==2}">
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
			
				 <!--<tr>
					<th>비밀번호</th>
					<td><input type="password" name="notice_Pw"> * 필수 (게시물 수정 삭제시 필요합니다.)</td>
				</tr>-->
			</table>
			<br>
			<br> 
			 <div id="buttonss">
					  <span id="btn_qna2"><input type="submit" value="등록" class="btn1" onclick="return noticeCheck()"></span> 
            <span id="btn_qna2"><input type="button" value="목록" class="btn2" onclick="location.href='NoticeServlet?command=admin_notice_list'"></span> 
					 </div>
		</form>
	</div>
	</div>
	</div>

</body>
</html>