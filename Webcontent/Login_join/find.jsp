<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
  <html lang="ko">
   <head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="img/logo.png" type="image/x-icon"> 
    <title>퀘스트 회원가입</title> 
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>    
    <script src="js/find.js"></script>
    <link rel="stylesheet" href="css/find.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon"> 
    <title>퀘스트샵</title>
</head>

<body>
<%@ include file="../header/header.jsp" %> 
   <div class="color1">
          <section id="top">
      <div class="Notice">
          <h1>아이디/비밀번호 찾기</h1>
      </div>
      <div class="search-window">
      </div>
         </section>
        </div>
       

<form action="find.do" name="idfindscreen" method="POST" accept-charset="UTF-8">

<div id="loginP">
    <div class="joinP">
      <div class="info">
        
       <div id="find_box">
         <div class="boxin">
         <!-- <img id="login_title" src="img/ttl_login.png" alt="로그인"> -->
         <div id="input_button">
           <ul id="find_input">
            <span>이름</span>
             <li><input type="text" name="name" class="btn-name" placeholder="등록한 이름"></li>
             <span>전화번호</span>
             <li><input type="text" onKeyup="addHypen(this);" name="phone" class="btn-phone" placeholder="휴대폰번호를 '-'없이 입력"></li>
           </ul>
             <p>${message}</p>
            <input type="submit" id="find_btn" name="enter" value="찾기" onClick="id_search()">
            <input type="button" id="find_btn2" name="cancel" value="취소" onClick="history.back()">
         </div>
         <div class="clear"></div>
        </div>
        </div>
      </div><!--info-->
      </div>    
  </div>


</form>
<%@ include file="../footer/footer.jsp" %> 
</body>
</html>
