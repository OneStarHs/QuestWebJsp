<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="img/logo.png" type="image/x-icon"> 
    <title>비밀번호찾기</title> 
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>    
    <script type="text/javascript" src="script/find.js"></script>
    <link rel="stylesheet" href="css/PWCH.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon"> 
</head>
<body>
    <%@ include file="../header/header.jsp" %> 
    <div class="color1">
           <section id="top">
       <div class="Notice">
           <h1>비밀번호 찾기</h1>
       </div>
       <div class="search-window">
       </div>
          </section>
         </div>

    <form id="PWCHForm" action="PWCH.do" method="post" onsubmit="return FindPwCheck();">
         <div id="loginP">
            <div class="joinP">
              <div class="info">
                
               <div id="find_box">
                 <div class="boxin">
                 <!-- <img id="login_title" src="img/ttl_login.png" alt="로그인"> -->
                 <div id="input_button">
                   <ul id="find_input">
                    <span>비밀번호 재설정</span>
                     <li> <input type="password" class="form-control" id="pwd" name="pwd" oninput="validatepwd(this.value, 'pwd')" placeholder="새로운 비밀번호" ></li>
                     <li> <input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" placeholder="비밀번호 확인"></li>
                   </ul>
                     <p>${message}</p>
                     <button id="find_btn" class="btn btn-primary" type="submit">비밀번호 변경</button>
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
