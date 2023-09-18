<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.List" %>
<%@ page import="dto.acceptedVO" %>
<%@ page import="dao.acceptedDAO" %>

<%
	String userid = (String) session.getAttribute("loginUser");;
    acceptedDAO dao = acceptedDAO.getInstance();
    int count1 = dao.getCountByTracking(userid, 1); // 접수 대기 항목 수
    int count2 = dao.getCountByTracking(userid, 2);
    int count3 = dao.getCountByTracking(userid, 3);
    int count4 = dao.getCountByTracking(userid, 4);
    // 기타 접수 상태에 따른 항목 수도 필요하다면 추가로 조회
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>퀘스트샵</title>   
    <link rel="stylesheet" href="css/my.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">     
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">  
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>    
    <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon">  
</head>
<script>
        function update(reg_Num) {
            if (confirm("정말로 접수를 수정하시겠습니까?")) {
                // 서블릿으로 이동하는 코드 (원하는 작업 수행)
                window.location.href = "acceptedUpdate.do?reg_Num=" + reg_Num;
            }
        }
</script>
<body>
<%@ include file="../header/header.jsp" %> 
    <div class="color1">
        <section id="top">
    <div class="Notice">
        <h1>마이페이지</h1>
    </div>
       </section>
   </div>

    <div class="middle">  
        <div class="search-window">
        </div>    
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

<form action="mypage.do" method="post" name="frm">

    <section id="right_main">
        <div id="right">
            <div class="title">
                <div class="one">
                    <ul>
                        <li><input value="${Idcheck}" style="pointer-events: none; width:60px; border:0 solid black; font-size: 20px;font-weight: bolder; "> 회원님 환영합니다.</li>
                    </ul>                    
                </div>

                
                <div class="song">                 	

                    <div class="hwak">
                        <p>접수 대기</p>
                        <span class="receipt"><b><%= count1 %></b></span>
                    </div>
                    <div class="chul">
                        <p>접수 완료</p>
                        <span class="receipt"><b><%= count2 %></b></span> 
                    </div>
                    <div class="wan">
                        <p>배송 출발</p>
                        <span class="receipt"><b><%= count3 %></b></span>
                    </div>
                    <div class="wan">
                        <p>배송 완료</p>
                        <span class="receipt"><b><%= count4 %></b></span> 
                    </div>
                    
                </div>

              <div class="eruk">
<!--                       <h4>배송 이력</h4>
                    <div class="nal">                        
                            <span>
                              <input type="radio" id="r_week" name="week" value="week" onclick="">
                              <label for="r1">1주일</label>
                            </span>
                            <span>
                              <input type="radio" id="r_month" name="month" value="month" onclick="">
                              <label for="r2">1개월</label>
                            </span>
                            <span>
                              <input type="radio" id="r_tmonth" name="tmonth" value="tmonth" onclick="">
                              <label for="r3">3개월</label>
                            </span>                          
                        <form><input type='date' id='currentDate_1'/></form> ~ <form><input type='date' id='currentDate'/></form>
                        <input type="button" class="ju" id="ju" value="조회하기">
                    </div>  -->
                    
                    
                    
                   
                 <table class="kk" border="0">
                    <tr class="myfline" >
                        <td style="width: 150px; border:none;">받는 이</td>
                        <td style="width: 150px; border:none;">메모</td>
                        <td style="width: 150px; border:none;">결제 상태</td>
                        <td style="width: 150px; border:none;">수정하기</td>
                        <td style="width: 150px; border:none;">접수 날짜</td>
                        <td style="width: 150px; border:none;">접수 상황</td>
                    </tr>
			
			     <c:forEach items="${acceptedList}" var="acceptedVO">
			     <tr class="mySline" style="border-bottom: 1px dotted #a7a7a7;">     	
                    <td style=" height: 40px; border:none;">${acceptedVO.arr_Name}</td>
			     	<td style=" border:none; text-overflow: ellipsis; white-space: nowrap; max-width: 5px;">${acceptedVO.user_Text}</td>			     	
			        
			   	<td style="border:none;">			        
        		<c:choose>        		
	               <c:when test="${acceptedVO.user_PayS eq '카드결제'}">결제 완료</c:when>   
	               <c:when test="${acceptedVO.user_PayS eq  '계좌이체'}">결제 완료</c:when>   
	               <c:when test="${acceptedVO.user_PayS eq  '선불'}">선불</c:when>   
	               <c:otherwise>착불</c:otherwise>
			    </c:choose> 
		       	</td>
		       
		       	<td style="border:none;">	
		       <input type="text" id="Reg_Num" name="Reg_Num"  value="${regNum}" style="display: none;">
		       <c:choose>
		       <c:when test="${acceptedVO.tracking eq 1 }"> 
		       <a href="javascript:update('${acceptedVO.reg_Num}')" style="color:black; text-decoration: none;">접수 수정</a>		       
		       </c:when>
		       <c:otherwise>수정 불가</c:otherwise>
		       </c:choose>
		       </td>
		       
		       <td style="border:none;">${acceptedVO.user_Date}</td>
		       
               <td style="border:none;">		        
        		<c:choose>        		
	               <c:when test="${acceptedVO.tracking eq 1 }">접수대기</c:when>   
	               <c:when test="${acceptedVO.tracking eq 2 }">접수완료</c:when>   
	               <c:when test="${acceptedVO.tracking eq 3 }">배송출발</c:when>   
	               <c:when test="${acceptedVO.tracking eq 4 }">배송완료</c:when>  
			    </c:choose> 
		       	</td>
		       
			    </tr>
			     </c:forEach>
			     
			    <tr>
				<td colspan="6" align="center" class="paging">
					<ul class="pagination">
		
						<!-- 2. 이전버튼 활성화 여부 -->
						<c:if test="${pageVO.prev }">
							<li><a
								href="mypage.do?pageNum=${pageVO.startPage - 1 }&amount=${pageVO.amount}">이전</a></li>
						</c:if>
		
						<!-- 1. 페이지번호 처리 -->
						<c:forEach var="num" begin="${pageVO.startPage }"
							end="${pageVO.endPage }">
							<li class="${pageVO.pageNum eq num ? 'active' : '' }"><a
								href="mypage.do?pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
						</c:forEach>
		
						<!-- 3. 다음버튼 활성화 여부 -->
						<c:if test="${pageVO.next }">
							<li><a
								href="mypage.do?pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
						</c:if>
					</ul>
				   </td>
			     </tr>    	   
			    
				</table>                   
		      </div>   
            </div>
        </div>
    </section>
</form>

</div>


<%@ include file="../footer/footer.jsp" %> 


<script type="text/javascript" src="scipt/my_page.js"></script>    
</body>
</html>