<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>퀘스트샵</title>
    <script type="text/javascript"  src="http://code.jquery.com/jquery-latest.min.js"></script>  
    <script src="script/sujung.js"></script> 
    <link rel="stylesheet" href="css/sujung.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">     
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">      
    <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon">     
</head>
<body>
<%@ include file="/header/header.jsp" %> 
<form action="memberUpdate.do" method="post" name="frm" onsubmit="return JoinCheck();">
    <div class="color1">
      <section id="top">
  <div class="Notice">
      <h2>개인정보수정</h2>
  </div>
  <div class="search-window">
      </div>
     </section>
 </div>

  <div class="free">

     <section id="left_main">
        <h3>왼쪽 내용</h3>
    <aside id="left">
        <div id="title">
             <a href="mypage.do" style="color:white">마이 페이지</a>
        </div>      
        <ul class="secu">
            <li><a href="memberUpdate.do">개인정보 수정</a></li>            
            <li><a href="NoticeServlet?command=qna_list">문의 내역</a></li>          
            <li><a href="memberDelete.do">회원탈퇴</a></li>                                  
        </ul>
    </aside>
    </section>
 
    <div id="T">
    <div class="Tb">
      <h4>개인 정보</h4>
      <table class="t_b">        
        <tbody>
          <tr>
            <th>아이디&nbsp;</th>
            <td colspan="3" class="txt_last"><div id="userid">
              <input type="text" class="txt_4" name="userid" id="userid" value="${userid}" readonly>
            </div></td>                                   
          </tr>         

          <tr>
            <th>이름&nbsp;</th>
            <td colspan="3" class="txt_last"><span id="QMemNm">
              <input type="text" class="txt_3" name="name" value="${name}" readonly>
            </span></td>
          </tr>

          <tr>
            <th>비밀번호&nbsp;</th>
            <td class="txt_last"> 
              <input type="password" class="txt_4" name="pwd" id="pwd" oninput="validatepwd(this.value, 'pwd')">
             
            </td>
          </tr>     
          
          <tr>
            <th>비밀번호 확인&nbsp;</th>
            <td class="txt_last">
              <input type="password" class="txt_4" id="pwd_check" name="pwd_check" oninput="validatePwdMatch(this.value, 'pwd')">
            </td>
          </tr>      
          
          <script>
          
          function JoinCheck() {	
        	  
        	   var email = document.frm.email.value;
        	    // 정규표현식을 사용하여 이메일 형식 확인
        	  var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        	  
        	  var phone = document.frm.phone.value;
        	  // 정규표현식을 사용하여 휴대폰번호 형식 확인
        	  var phoneRegex = /^\d{10,11}$/;  	        	  
        	   
        		if (document.frm.pwd.value.length < 8) {
        			alert("비밀번호는 8글자 이상이어야 합니다.");
        			document.frm.pwd.focus();
        			return false;	
        		}
        		if (document.frm.pwd.value != document.frm.pwd_check.value) {
        			alert("암호가 일치하지 않습니다.");
        			document.frm.pwd.focus();
        			return false;
        		}
        	    if (!emailRegex.test(email)) {
        	   		alert("올바른 이메일 형식이 아닙니다.");
        	   	 	document.frm.email.focus();
        	    	return false;
        	    } 
        	 	if (!phoneRegex.test(phone)) {
        	    	alert("올바른 전화번호 형식이 아닙니다.");
        	    	document.frm.phone.focus();
        	    	return false;
        		}		
        		return true;
        	}
          </script>
          
          <tr>
            <th>전화번호&nbsp;</th>
            <td class="txt_last">
              <div class="ttt" style="display: inline-block;">
              <input type="text" class="txt_4" name="phone" id="txt_Mobile2" maxlength="13" value="${phone}" oninput="validatePhoneNumber(this.value, 'phone')">
              
              </div>
            </td>
          </tr>

          <tr>
            <th>이메일&nbsp;</th>
            <td class="txt_last">
              <input type="text" name="email" value="${email}" class="txt_4" id="email">
            </td>
          </tr>

          <tr class="txt_last" aria-required="true">
     <th class="ta-l required" style="padding-bottom: 112px;">주소&nbsp;</th>
      <td class="txt_last"><input  type="text" id="add1" name="add1" value="${add1}" style=" width: 255px;
        margin-bottom: 5px;
        height: 48px;
        padding: 0;
        border: 1px solid rgb(224, 149, 50);
        color: #444; line-height: 31px;"  size="45">    
        <div id="addbtn">
          <input type="button" class="addch" value="우편번호찾기" onclick="execDaumPostcode()"> <!-- zipCheck()함수를 사용해 우편번호와 주소를 검색한다. -->
          </div>
       <input  type="text"  placeholder="주소" id="add2"  name="add2" value="${add2}" autocomplete="off" style=" width: 400px;
        margin-bottom: 5px;
        height: 48px;
        padding: 0;
        border: 1px solid rgb(224, 149, 50);;
        color: #444; line-height: 31px;"  size="45">
         <input  type="text" placeholder="상세주소" autocomplete="off" style=" width: 400px;
        margin-bottom: 5px;
        height: 48px;
        padding: 0;
        border: 1px solid rgb(224, 149, 50);;
        color: #444; line-height: 31px;"  size="45" id="add3" name="add3" value="${add3}" size="45" id="add3" name="add3" value="${add3}" size="45">
        <span id="guide" style="color:#999"></span>
      </td>
       <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
      </tr>
        </tbody>
      </table>

     <div id="error">
      <span id="pwd_error"></span>  
      <p id="pwd_match_error"></p>  
      <p id="phone_error" ></p>
     </div>


      <div class="bb">
        <input type="submit" class="but" value="수정하기">
      </div>  

    </div>    
  </div> 
  

  </div>
</form>
 
<%@ include file="/footer/footer.jsp" %> 

</body>
</html>