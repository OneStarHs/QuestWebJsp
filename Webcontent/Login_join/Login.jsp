<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
  <html lang="ko">
   <head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="script/login.js"></script>
    <link rel="shortcut icon" href="img/logo.png" type="image/x-icon"> 
    <title>퀘스트 로그인</title> 
    <link rel="stylesheet" href="css/Login.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/Login_header.css">
    <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon"> 
</head>

<body oncontextmenu="return false">  
  <header>
    <section id="logo">
    <a href="Main.jsp"><img id="logo" src="img/logo2.png"></a>
  </section>
   <nav id="top_menu">
    <span><a href="Main.jsp">HOME |</a></span>
    <span><a href="NoticeServlet?command=notice_list"> NOTICE </a></span>
</nav>
    </header>
<form action="login.do" method="post" name="frm" onsubmit="return loginCheck()">
<div id="loginmain">
  <div class="search-window">
  </div>
  <section id="location">
  <div id="loginP">
   <div class="joinP">
     <div class="info">
        <div id="main_all02">
  <!-- <img src="../img/로그인 배경화면.png" style="padding: 0; vertical-align: bottom;"> -->
  <video src="img/로그인 배경.mp4" width="1920px" height="880px" loop="" autoplay="" muted=""  style="vertical-align: bottom;"></video>
</div>
      <div id="login_box">
        <div class="boxin">
        <!-- <img id="login_title" src="img/ttl_login.png" alt="로그인"> -->
        <div id="input_button">
          <ul id="login_input">
            <li><input type="text" name="userid"  placeholder="아이디" value="" ></li>
            <li><input type="password" name="pwd" placeholder="비밀번호" value=""></li>
          </ul>
            <p>${message}</p>
         <input type="submit" id="login_btn" value="로그인">
        </div>
        </div>
        <div class="clear"></div>
        <div id="join_search">     
          <a href="find.do"> 아이디 찾기 |</a>
          <a href="findpw.do"> 비밀번호 찾기 |</a>
          <a href="join.do"> 회원가입</a>	
          </div>
          </div>
       </div>
     </div><!--info-->
     </div>    
     <footer>
    <ul id="address">
        <li>서울시 강남구 삼성동 1234 우 : 123-1234</li>
        <li>TEL : 031-123-1234 Email : Questshop@domain.com</li>
        <li>COPYRIGHT (C) 퀘스트 Quest</li>
    </ul>
  </footer><!--footer-->
        </section>
         </div>  
</form>
</body>
</html>

