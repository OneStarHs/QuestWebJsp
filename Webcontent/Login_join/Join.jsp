<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
  <html lang="ko">
   <head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="img/logo.png" type="image/x-icon"> 
    <title>퀘스트 회원가입</title> 
    <script type="text/javascript"  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="script/join.js"></script>
    <link rel="stylesheet" href="css/join.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">    
    <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon"> 
    <title>퀘스트샵</title>
  <body style="overflow-x: hidden">
<%@ include file="../header/header.jsp" %> 
<form method="post" action="join.do" name="frm" onsubmit="return JoinCheck();">
   <div class="color1">
          <section id="top">
      <div class="Notice">
          <h1>회원가입</h1>
      </div>
         </section>
        </div>      
  <div id="singmain" style="margin: auto;">
   <div class="join">
     <div class="info" style="clear:both;">
     </div>
     <div class="search-window">
    </div>
    <div class="table1" style="clear:both;">   
      <table> 
        <colgroup>
            <col style="width:163px;">
            <col>
          </colgroup>
          <tbody>
         <hr style=" margin-top: 75px; margin-bottom: 0px; width:680px; border-width:0px 0 0 0; border-color:#dd8a0c;" align="left" >
        <tr>
          <th class="ta-l required" aria-required="true">아이디&nbsp;</th>
	          <td class="td-l">
	              <div class="txt-field">
	                  <input type="text"  placeholder="아이디를 입력하세요." autocomplete="off"  class="text"  name="userid" size="20"  id="userid" value="${userid}" oninput="validateUserID(this.value, 'userid')">
	                  <input type="hidden" name="reid" size="20">
	              </div>
	          </td>
      </tr>

      <tr>
          <tr>
            <th class="ta-l required" aria-required="true">비밀번호&nbsp;</th>
            <td class="td-l">
              <div class="txt-field">
                <input type="password" placeholder="비밀번호를 입력하세요." 
                autocomplete="off" class="text check-id" name="pwd" id="pwd" 
                oninput="validatepwd(this.value, 'pwd')">  
                <br>
				
                  </div>
              </td>
          </tr>
          <tr>
            <th class="ta-l required" aria-required="true">비밀번호 확인&nbsp;</th>
            <td class="td-l">
              <div class="txt-field">
                <input type="password" placeholder="비밀번호를 한 번 더 입력하세요." autocomplete="off" class="text check-id" name="pwd_check" oninput="validatePwdMatch(this.value, 'pwd')">
               </div>
            </td>
          </tr>          
 <th class="ta-l required" aria-required="true">이메일&nbsp;</th>
<td class="td-l">
 <div class="txt-field">
    <input type="text" id="email"  name="email" placeholder="이메일" autocomplete="off" class="text check-id" >
     </div>
</td>
          <tr>
            <th class="ta-l required" aria-required="true">이름&nbsp;</th>
            <td class="td-l">
                <div class="txt-field">
                    <input type="text" placeholder="이름을 입력하세요." autocomplete="off" class="text" name="name" data-pattern="gdEngKor" value="" maxlength="20">
                </div>
            </td>
        </tr>
          <tr>
            <th class="ta-l required">휴대폰번호&nbsp;</th>
            <td class="td-l">
                <div class="txt-field">
                    <input type="text" id="phone" name="phone" class="text" maxlength="12" placeholder="- 없이 입력하세요." data-pattern="gdNum" value="" oninput="validatePhoneNumber(this.value, 'phone')">
                    <br>
               </div>
         </td>
        </tr>   
        <tr>
      <tr class="ta-l required" aria-required="true">
     <th class="ta-l required" style="padding-bottom: 120px;">주소&nbsp;</th>
      <td class="td-l"><input  type="text" id="add1" name="add1" style=" width: 255px;
        margin-bottom: 5px;
        height: 48px;
        padding: 0;
        border: 1px solid rgb(224, 149, 50);;
        color: #444;
        line-height: 31px;" size="5" readonly>
       <input  type="text"  placeholder="주소" id="add2"  name="add2" autocomplete="off" style=" width: 400px;
        margin-bottom: 5px;
        height: 48px;
        padding: 0;
        border: 1px solid rgb(224, 149, 50);;
        color: #444; line-height: 31px;"  size="45">
         <input  type="text" placeholder="상세주소" autocomplete="off" style=" width: 400px;
        margin-bottom: 5px;
        height: 48px;
        padding: 0;
        border: 1px solid rgb(224, 149, 50);
        color: #444; line-height: 31px;" id="add3" name="add3" size="45">
        <span id="guide" style="color:#999"></span>
      </td>
       <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
      </tr>
    </table>

    <div id="error">
      <p id="userid_error" ></p>
      <p id="pwd_error"></p>
      <p id="pwd_match_error"></p>  
      <p id="phone_error" ></p>
    </div>
 <div id="check-btn">
  <input type="button" value="중복체크" name="CH" onclick="idCheck()" class="idch">
  <input type="button" value="우편번호찾기" onclick="execDaumPostcode()" class="addch"> <!-- zipCheck()함수를 사용해 우편번호와 주소를 검색한다. -->
 </div>

  <div class="btn">
      <button type="button" class="skinbtn point1 j-cancel" id="btnCancel"><a style="text-decoration-line: none;
        color: #a74b00;" href="Main.jsp">취소</a></button>
       <input type="submit" class="skinbtn point2 j-join" value="회원가입">
      </div>
  </div>
    </div>
    </div>
     <%@ include file="../footer/footer.jsp" %> 
  </form>
</body>
   </html>