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
          <div align="center"><h1>공지 등록</h1></div>
         
           <form name="frm" method="post" enctype="multipart/form-data">
         <!--  ut type="hidden" name="command" value="admin_notice_write">-->
            <table class="noticeinsert">
                <tr>
                    <th>제 목</th>
                    <td><input class="noticetitle" type="text" size="70" name="notice_Title"> * 필수</td>
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
                    <th>첨부파일</th>
                    <td><input type="file" name="notice_img"></td>
                </tr>
                <tr>

                </tr>
                <!--   <tr>
              <th>비밀번호</th>
              <td><input class="noticetitle" type="password" name="notice_Pw"> * 필수 (게시물 수정 삭제시 필요합니다.)</td>
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
	<div class="clear"></div>

</body>
</html>