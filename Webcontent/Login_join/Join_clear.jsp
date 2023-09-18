<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
  <html lang="ko">
   <head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="img/logo.png" type="image/x-icon"> 
    <title>퀘스트 회원가입</title> 
    <link rel="stylesheet" href="../css/singup clear.css">
    <link rel="stylesheet" type="text/css" href="../css/common.css">
    <link rel="stylesheet" type="text/css" href="../css/header.css">
    <link rel="stylesheet" type="text/css" href="../css/footer.css">
    <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon"> 
    <title>퀘스트샵</title>
   </head>


  <body style="overflow-x: hidden">
   <%@ include file="../header/header.jsp" %> 


   <div class="color1">
          <section id="top">
      <div class="Notice">
          <h1>회원가입</h1>
      </div>
         </section>
        </div>

 <form action="join_clear.do" method="get" name="frm">
        <div id="singmain" style="margin: auto;">
          <div class="join">
            <div class="info" style="clear:both;">
              <div>
              <img id="logo" src="img/회원가입.png" style="margin-left: -300px; margin-top: -190px;">
            </div>
            <div class="btn">
              <button type="button" class="skinbtn point1 j-cancel" id="btnCancel"><a href="Main_Out.jsp">페이지로돌아가기</a></button>
          </div>
           </div>
</div>
</div>
  </form>
 
  <%@ include file="../footer/footer.jsp" %>  
</body>
   </html>
