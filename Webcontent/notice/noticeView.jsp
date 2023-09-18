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
<script type="text/javascript" src="script/notice.js"></script>
</head>
<body>
<%@ include file="../header/header.jsp" %> 
<div class="clear"></div>
<div class="color1">
		<section id="top">
			<div class="Notice">
				<h2>공지사항</h2>
			</div>
			<div class="search-window"></div>
		</section>
	</div>
<div class="free" align="center">  
          <div class="Notice_content2">         
       <div class="Notice_container">
          <table class="Notice_content" >
            <tr>
               <td class=Notice_title >${notice.notice_Title }</td>   
            </tr>
            <tr>
             <td class=Notice_date ><fmt:formatDate value="${notice.notice_Date }" /></td>
                  
            </tr>
            <tr>
					<td>
					<c:choose>
					<c:when test="${empty notice.notice_img}">
					   <img src='abc.jpg' onerror="this.style.display='none'" alt='' />
					</c:when>
					<c:otherwise>
					<img src ="uploads/${notice.notice_img}">
					</c:otherwise>
					</c:choose>
					</td>
			</tr>             
            <tr>
             <td class="Notice_Content" >${notice.notice_Content }</td>
            </tr>                      
        </table>
        </div>
        <br> <br>
        <div class="btn_box"> 
        
		<input type="button" value="목록" class="btn"
			onclick="goBack()"> 
		</div>
       </div>         
  
 </div>
  <div id="footer"></div>
 <div class="clear"></div>
<%@ include file="../footer/footer.jsp" %> 
</body>
</html>