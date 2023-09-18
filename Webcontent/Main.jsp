<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
  <html lang="ko">
   <head>
    <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="css/common.css">
  <link rel="stylesheet" type="text/css" href="css/header_main.css">
  <link rel="stylesheet" type="text/css" href="css/footer.css">
  <link rel="stylesheet" type="text/css" href="css/main.css">
  <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon"> 
  <title>퀘스트 샵</title>
</head>

<body style="overflow-x: hidden;" oncontextmenu="return false">  
  <header>
    <a href="Main.jsp"><img id="logo" src="img/logo2.png"></a>
   <nav id="top_menu">
   
    <span>
        <c:choose>
        <c:when test="${loginUser == 'admin'}">
             <b style="border:none;border-right:0px;color: #ffffff; border-top:0px; background-color:transparent;  font-size: 15px; cursor: pointer;">[${loginUser}]님 환영합니다. 관리자 모드 &nbsp &nbsp</b>
            <span><a href="Main.jsp">HOME |</a></span>
                <form action="${pageContext.request.contextPath}/logout.do" method="post" style="display: inline;">
                    <input type="submit" value="LOGOUT |" style="border:none;border-right:0px;color: #ffffff; border-top:0px; background-color:transparent;  font-size: 15px; cursor: pointer;">
                </form>
                 
            <span><a href="NoticeServlet?command=notice_list"> NOTICE </a></span>
            </c:when>
            <c:when test="${isLoggedIn}">
            <b>${loginUser}님 환영합니다.로그인된 상태</b>
             <span><a href="Main.jsp">HOME |</a></span>
                <form action="${pageContext.request.contextPath}/logout.do" method="post" style="display: inline;">
                    <input type="submit" value="LOGOUT |" style="border:none;border-right:0px; border-top:0px;
                      background-color:transparent; color: #ffffff; font-size: 15px; cursor: pointer;">
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
    </span>
    
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
      <div id="main_all02">
       <c:choose>
        <c:when test="${loginUser == 'admin'}">
        <a href="NoticeServlet?command=admin_notice_list"><button type="button" class="bt1">관리자 페이지</button></a>
        </c:when>
         <c:otherwise>
         <a href="accepted.do"><button type="button" class="bt1">접수하기</button></a>
         </c:otherwise>
        </c:choose>
        </div>
        <div id="main_text">
          <p>24시간 내로 빠른 배송</p>
        </div>
    </header>
      <section id="location">
        <div>
            <video src="img/메인페이지.mp4" width="1920px" height="880px" loop="" autoplay="" muted=""  style="vertical-align: bottom;"></video>
        </div>
      </section>
    
  
  <!-- <%@ include file="../footer/footer.jsp" %> -->

  
</body>
</html>