<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>퀘스트샵</title>
    <script src="js/jquery-3.7.0.js"></script>
    <script type="text/javascript" src="script/center.js"></script>
    <link rel="stylesheet" type="text/css" href="css/center.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon">
    
</head>
<body>
<%@ include file="../header/header.jsp" %>
   <form action="center.do" method="post" name="frm">

    <div class="color1">
      <section id="top">
  <div class="Notice">
      <h1>Quest 고객센터 </h1>
  </div>
     </section>
 </div>

        <div class="mun">
          <div class="search-window">
          </div>
            <section class="pak">
              <div class="mm"> 
              </div>

              <div class="jaju">
                <div class="ja">
                  <h2><strong>자주 묻는 질문 TOP 5</strong></h2>
                </div>
				
				<div class="acco">
				<button type="button" class="collapsible" onclick="collapse(this);">
				본인 인증 방법에는 어떤 것들이 있나요?
				</button>
			    <div class="content">
			         <p>회원가입 방법, 본인 인증 수단, 회원가입 방법에 따른 본인 인증 가능 수단을 안내해 드리겠습니다.</p>
                     <p><strong>회원가입 방법</strong></p>
                     <p><strong>-14세 이상 일반회원 </strong>: 14세 이상 국내거주 내/외국인 회원</p>
                     <p><strong>-14세 미만 어린이 회원 </strong>: 14세 미만인 국내거주 내/외국인 회원</p>                        
                     <p><strong>-법인회원 </strong>: 법인실명인증 후 가입한 회원</p>
                     <p><strong>-해외거주 회원 </strong>: 해외에 거주하는 외국인 회원</p>
                     <p><strong>-실명 인증 회원 </strong>: 2012년 08월 18일 이전 주민번호 입력을 통해 실명인증으로 가입한 회원</p>
                     <p>*14세 미만 어린이 회원의 경우 :&nbsp;가입 시 법정대리인의 동의 및 본인인증 필요</p>
			    </div>
			    <button type="button" class="collapsible" onclick="collapse(this);">
			    본인 인증 방법에는 어떤 것들이 있나요?
			    </button>
			    <div class="content">
			        <p>회원가입 방법, 본인 인증 수단, 회원가입 방법에 따른 본인 인증 가능 수단을 안내해 드리겠습니다.</p>
                     <p><strong>회원가입 방법</strong></p>
                     <p><strong>-14세 이상 일반회원 </strong>: 14세 이상 국내거주 내/외국인 회원</p>
                     <p><strong>-14세 미만 어린이 회원 </strong>: 14세 미만인 국내거주 내/외국인 회원</p>                        
                     <p><strong>-법인회원 </strong>: 법인실명인증 후 가입한 회원</p>
                     <p><strong>-해외거주 회원 </strong>: 해외에 거주하는 외국인 회원</p>
                     <p><strong>-실명 인증 회원 </strong>: 2012년 08월 18일 이전 주민번호 입력을 통해 실명인증으로 가입한 회원</p>
                     <p>*14세 미만 어린이 회원의 경우 :&nbsp;가입 시 법정대리인의 동의 및 본인인증 필요</p>
			    </div>
			    <button type="button" class="collapsible" onclick="collapse(this);">
			    본인 인증 방법에는 어떤 것들이 있나요?
			    </button>
			    <div class="content">
			        <p>회원가입 방법, 본인 인증 수단, 회원가입 방법에 따른 본인 인증 가능 수단을 안내해 드리겠습니다.</p>
                     <p><strong>회원가입 방법</strong></p>
                     <p><strong>-14세 이상 일반회원 </strong>: 14세 이상 국내거주 내/외국인 회원</p>
                     <p><strong>-14세 미만 어린이 회원 </strong>: 14세 미만인 국내거주 내/외국인 회원</p>                        
                     <p><strong>-법인회원 </strong>: 법인실명인증 후 가입한 회원</p>
                     <p><strong>-해외거주 회원 </strong>: 해외에 거주하는 외국인 회원</p>
                     <p><strong>-실명 인증 회원 </strong>: 2012년 08월 18일 이전 주민번호 입력을 통해 실명인증으로 가입한 회원</p>
                     <p>*14세 미만 어린이 회원의 경우 :&nbsp;가입 시 법정대리인의 동의 및 본인인증 필요</p>
			    </div>
			    <button type="button" class="collapsible" onclick="collapse(this);">
			    본인 인증 방법에는 어떤 것들이 있나요?
			    </button>
			    <div class="content">
			        <p>회원가입 방법, 본인 인증 수단, 회원가입 방법에 따른 본인 인증 가능 수단을 안내해 드리겠습니다.</p>
                     <p><strong>회원가입 방법</strong></p>
                     <p><strong>-14세 이상 일반회원 </strong>: 14세 이상 국내거주 내/외국인 회원</p>
                     <p><strong>-14세 미만 어린이 회원 </strong>: 14세 미만인 국내거주 내/외국인 회원</p>                        
                     <p><strong>-법인회원 </strong>: 법인실명인증 후 가입한 회원</p>
                     <p><strong>-해외거주 회원 </strong>: 해외에 거주하는 외국인 회원</p>
                     <p><strong>-실명 인증 회원 </strong>: 2012년 08월 18일 이전 주민번호 입력을 통해 실명인증으로 가입한 회원</p>
                     <p>*14세 미만 어린이 회원의 경우 :&nbsp;가입 시 법정대리인의 동의 및 본인인증 필요</p>
			    </div>
			    <button type="button" class="collapsible" onclick="collapse(this);">
			    본인 인증 방법에는 어떤 것들이 있나요?
			    </button>
			    <div class="content">
			       <p>회원가입 방법, 본인 인증 수단, 회원가입 방법에 따른 본인 인증 가능 수단을 안내해 드리겠습니다.</p>
                     <p><strong>회원가입 방법</strong></p>
                     <p><strong>-14세 이상 일반회원 </strong>: 14세 이상 국내거주 내/외국인 회원</p>
                     <p><strong>-14세 미만 어린이 회원 </strong>: 14세 미만인 국내거주 내/외국인 회원</p>                        
                     <p><strong>-법인회원 </strong>: 법인실명인증 후 가입한 회원</p>
                     <p><strong>-해외거주 회원 </strong>: 해외에 거주하는 외국인 회원</p>
                     <p><strong>-실명 인증 회원 </strong>: 2012년 08월 18일 이전 주민번호 입력을 통해 실명인증으로 가입한 회원</p>
                     <p>*14세 미만 어린이 회원의 경우 :&nbsp;가입 시 법정대리인의 동의 및 본인인증 필요</p>
			    </div>
				</div>
              </div>

              <div class="eil">
                <div class="ei">
                  <h2><strong>1 : 1 문의내역</strong></h2>
                </div>

                <div class="eiei">                	
                  	<c:forEach items="${qnalist}" var="qnaVO" varStatus="status">
					<tr>		
					<div class="oo">
					<div class="nu">			
					<td>${status.index + 1}</td>
					</div>
					
					<div class="neyong">	
					<td><a href="NoticeServlet?command=qna_view&qna_Seq=${qnaVO.qna_Seq}">
					${qnaVO.qna_Title}</a></td>
					</div>
					
					<div class="ymd">
					<td><fmt:formatDate value="${qnaVO.qna_Date}" type="date" /></td>
					</div>
					
					<div class="yn">
					<td>
					<c:choose>
						<c:when test="${qnaVO.qna_Rep==1}"> no </c:when>
						<c:when test="${qnaVO.qna_Rep==2}"> yes </c:when>
					</c:choose>
					</td>
					</div>
					
					</div>					
					</tr>
					</c:forEach>                   
                </div>     
              </div>

              <div class="gong">
                <div class="go">
                  <h2><strong>공지사항</strong></h2> 
                </div>
                                  

                <div class="gogo">                              
                    <c:forEach var="notice" items="${noticeList }">
					<tr class="record">
					<div class="oo">
					<div class="ff">
					<td>					
					<c:choose>
					<c:when test="${notice.notice_Type==1}">주요공지</c:when>
					<c:when test="${notice.notice_Type==2}">공지사항</c:when>
					<c:otherwise>이벤트</c:otherwise>
					</c:choose>
					</td>
					</div>
					
					<div class="num">
					<td><a href="NoticeServlet?command=notice_view&notice_num=${notice.notice_num}">
							${notice.notice_Title } </a></td>
					</div>
					
					<div class="date">
					<td><fmt:formatDate value="${notice.notice_Date }"/></td>
					</div>
					</div>
					</tr>
			    </c:forEach>                     
                </div>               
              </div>              
            </section>
        </div>

</form>

<%@ include file="../footer/footer.jsp" %>
</body>
</html>