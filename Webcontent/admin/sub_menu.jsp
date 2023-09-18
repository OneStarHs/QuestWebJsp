<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>퀘스트샵</title>
      
  <link rel="stylesheet" type="text/css" href="css/submenu.css">
</head>
<body>
<nav id="sub_menu">
<h1>Admin Setting</h1>
<ul>
<li><a href='NoticeServlet?command=admin_notice_list' sy> 공지리스트</a></li>
<li><a href='NoticeServlet?command=admin_order_list'> 접수리스트</a></li>
<li><a href='NoticeServlet?command=admin_member_list'> 회원리스트</a></li>
<li><a href='NoticeServlet?command=admin_qna_list'> Q&amp;A리스트</a></li>
</ul>
</nav>
</body>
</html>