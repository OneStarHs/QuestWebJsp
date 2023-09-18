<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 결과</title>
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">  
</head>
<body>
<%@ include file="../header/header.jsp" %> 
  <%
    String userID = (String) request.getAttribute("userID");

    if (userID != null) {
  %>
  
  <div class="container">
    <div class="found-success">
        <h4>회원님의 아이디는 </h4>
        <div class="found-id"><%= userID %></div>
        <h4>입니다</h4>
    </div>
    <div class="found-login">
        <input type="button" id="btnLogin" value="로그인" onClick="login()" />
    </div>
  </div>
  
  <% 
    } else {
  %>
  
  <div class="container">
    <div class="found-fail">
        <h4>등록된 정보가 없습니다</h4>
    </div>
    <div class="found-login">
        <input type="button" id="btnback" value="다시 찾기" onClick="history.back()" />
        <input type="button" id="btnjoin" value="회원가입" onClick="joinin()" />
    </div>
  </div>
  
  <% 
    }
  %>

  <div class="adcontainer">
    <a href="#"><img src="../images/casead.png" /></a>
  </div>

<%@ include file="../footer/footer.jsp" %> 
<script>
  function login() {
    // 로그인 버튼을 클릭했을 때의 동작
    // 로그인 페이지로 이동하는 로직을 추가하세요.
  }

  function joinin() {
    // 회원가입 버튼을 클릭했을 때의 동작
    // 회원가입 페이지로 이동하는 로직을 추가하세요.
  }
</script>
</body>
</html>

