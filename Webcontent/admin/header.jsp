<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="admin/css/admin.css">
<link rel="stylesheet" type="text/css" href="../css/header.css">
<link rel="stylesheet" type="text/css" href="css/header.css">

<style>

</style>
</head>

<body>
     <header>
     
    
    <a href="Main.jsp"><img id="logo" src="img/questlogo.png"></a>
    <nav id="top_menu">
      <!--  <span><a href="Main.jsp">HOME |</a></span>-->
       <span>
        <c:choose>
            <c:when test="${loginUser == 'admin'}">
            <span><a href="Main.jsp">HOME |</a></span>
            <b>[${loginUser}]님 환영합니다. 관리자 모드</b>
                <form action="${pageContext.request.contextPath}/logout.do" method="post" style="display: inline;">
                    <input type="submit" value="LOGOUT |" style="border:none;border-right:0px; border-top:0px; background-color: #ffffff; color: #000000; font-size: 15px; cursor: pointer;">
                </form>
                 
            <span><a href="NoticeServlet?command=notice_list"> NOTICE </a></span>
            </c:when>
            <c:when test="${isLoggedIn}">
            <b>${loginUser}님 환영합니다.로그인된 상태</b>
                <form action="${pageContext.request.contextPath}/logout.do" method="post" style="display: inline;">
                    <input type="submit" value="LOGOUT |" style="border:none;border-right:0px; border-top:0px; background-color: #ffffff; color: #000000; font-size: 15px; cursor: pointer;">
                </form>
                 
      <span><a href="NoticeServlet?command=notice_list"> NOTICE </a></span>
            </c:when>
            <c:otherwise>
                <span><a href="Main.jsp">HOME |</a></span>
                <a href="${pageContext.request.contextPath}/login.do">LOGIN |</a>
                <span><a href="join.do"> JOIN |</a></span>
                <span><a href="NoticeServlet?command=notice_list"> NOTICE </a></span>
            </c:otherwise>
        </c:choose>
    </span>
     <!--   <span><a href="join.do"> JOIN |</a></span>
      <span><a href="NoticeServlet?command=notice_list"> NOTICE </a></span>-->
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
      
		<div class="clear"></div>
		<div class="color1">
		<section id="top">
			<div class="Notice">
				<h2>관리자 페이지</h2>
			</div>
			<div class="search-window"></div>
		</section>
	</div>
</body>
</html>