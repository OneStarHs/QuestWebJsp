<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <head>
    <link rel="shortcut icon" href="../img/logo.png" type="image/x-icon"> 
    <title>퀘스트 회원가입</title> 
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>    
    <script src="js/find.js"></script>
    <link rel="stylesheet" href="../css/find.css">
    <link rel="stylesheet" type="text/css" href="../css/common.css">
    <link rel="stylesheet" type="text/css" href="../css/header.css">
    <link rel="stylesheet" type="text/css" href="../css/footer.css">
    <link rel="shortcut icon" href="../img/questlogo.png" type="image/x-icon"> 
    <title>퀘스트샵</title>

  <body style="overflow-x: hidden">
  
    <header>
    
    <a href="Main.jsp"><img id="logo" src="img/questlogo.png"></a>
    <nav id="top_menu">
       <c:choose>
            <c:when test="${isLoggedIn}">
             <span><a href="Main.jsp">HOME |</a></span>
                <form action="${pageContext.request.contextPath}/logout.do" method="post" style="display: inline;">
                    <input type="submit" value="LOGOUT |" style="border:none;border-right:0px; border-top:0px;
                      background-color:transparent; font-size: 15px; cursor: pointer;">
                      <span><a href="NoticeServlet?command=notice_list"> NOTICE </a></span>
                </form>
            </c:when>
            <c:otherwise>
                <span><a href="Main.jsp">HOME |</a></span>
                <a href="${pageContext.request.contextPath}/login.do">LOGIN |</a>
                <span><a href="join.do"> JOIN |</a></span>
                <span><a href="NoticeServlet?command=notice_list"> NOTICE </a></span>
            </c:otherwise>
        </c:choose>
   </nav>
    <nav id="header_main">
    </nav>
       <section id="main">
        <nav id="main_menu">
      <ul class="menu">
        <li class="sub1"><a href="NoticeServlet?command=notice_list"><p>공지</p></a></li>
        <li class="sub1"><a href="guide.do"><p>이용 가이드</p></a></li>
      	<li class="sub1"><a href="accepted.do"><p>인터넷접수</p></a></li>
        <li class="sub1"><a href="mypage.do"><p>마이페이지</p></a></li>
        <li class="sub1"><a href="center.do"><p>고객센터</p></a></li>
      </ul>
    </nav>
      </section>
    </header>
      
</head>


</body>
</html>