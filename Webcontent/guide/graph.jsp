<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>퀘스트샵</title>
        
        <link rel="stylesheet" href="css/graph.css">
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <link rel="stylesheet" type="text/css" href="css/header.css">
        <link rel="stylesheet" type="text/css" href="css/footer.css">
        <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon"> 
    
        
    </head>
    <body>
       <%@ include file="../header/header.jsp" %>
<form action="graph.do" method="post" name="frm">

    <div class="color1">
        <section id="top">
    <div class="Notice">
        <h1>요금 안내</h1>
    </div>
       </section>
   </div>
  
    <div class="free">  
    <section id="left_main">
    <div class="search-window">
        
    </div>
        <h3>왼쪽 내용</h3>
    <aside id="left">
        <div id="title">
            요금 안내
        </div>      
        <ul>                  
            <li><a href="npc.html">요금표</a></li>                       
        </ul>
    </aside>
    </section>

    <section id="right_main">      
    </section>

    <section id="right_main">
        <h3>오른쪽 내용</h3>
      
    <aside id="right">
        <div class="ri">
            <div class="ri_1">
                <div class="buze">
                    <h2>서울 시내 요금</h2>
                    <h4></h4>
                </div>        
            
                <div class="igig">
                    <img src="img/서울 요금.PNG">
                </div>
            </div>

            <div class="ri_2">
                <div class="buze">
                    <h2>경기 요금</h2>
                    <h4></h4>
                </div>        
            
                <img src="img/경기 요금.png" class="img">
                <div class="modal">
                    <span class="close">&times;</span>
                    <img class="modal_content" id="img01">
                </div>             

            </div>

        </div>            
    </aside>
    </section>
</div> 
</form>

 <%@ include file="../footer/footer.jsp" %>

<script type="text/javascript" src="script/graph.js"></script>
</body>
</html>