<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
  <html lang="ko">
   <head>
    <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css/common.css">
  <link rel="stylesheet" type="text/css" href="css/header.css">
  <link rel="stylesheet" type="text/css" href="css/footer.css">
  <link rel="stylesheet" type="text/css" href="css/accepted.css">
  <link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon">
  <script type="text/javascript" src="script/accepted.js"></script>
  <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>  
  <title>퀘스트샵</title>
</head>
<body>
<%@ include file="../header/header.jsp" %> 

<div class="color1">
          <section id="top">
      <div class="Notice">
          <h1>인터넷접수</h1>
      </div>
         </section>
        </div>      
  <div id="singmain" style="margin: auto;">
   <div class="join">
     <div class="info" style="clear:both;">
     </div>
     <div class="search-window">
     </div>
    </div>
</div>

      <form action="accepted.do" accept-charset="UTF-8" method="post" name = "myacc" onsubmit="return checkSubmit();">
      <div id="main_post">
    <section class="header_post">
      <div class="header_start">
        <div class="title_start">
          <h2 class="title">출발지</h2>
          <div class="explanation">어디서 출발할까요?</div>
        </div>
        <div class="np">
          <div class="name">
            <input type="text" name ="Dep_Name"  id="Dep_Name" placeholder="고객명/상호*(한글)" autocomplete="off">  
          </div>
          <div class="phone">
               <input type="text" name ="Dep_PN" placeholder="연락처*(-를 빼고넣으세요.)" autocomplete="off" id="Dep_PN" onblur="validatePhoneNumber(this.value , 'Dep_PN')">
               <span id="Dep_PN_error" style="color: red;"></span>
          </div>
        </div>
       <div class="np">
          <div class="post">
          <input type="text" name ="Dep_Add1" placeholder="우편번호*" autocomplete="off" id="Dep_Add1">
        </div>
          <div class="searchadd">
            <input type="button" onclick="sample4_execDaumPostcode(1)" value="우편번호 찾기">
          </div>
        </div>
        <div class="np">
          <div class="address">
            <input type="text" name ="Dep_Add2" placeholder="주소*" autocomplete="off" id="Dep_Add2">
          </div>
        </div>
        <div class="np">
        <div class="plus">
          <input type="text" name ="Dep_Add3" placeholder="상세주소*" autocomplete="off" id="Dep_Add3" onblur="validateAddress(this.value,'Dep_Add3')">
         <span id="Dep_Add3_error" style="color: red;"></span>
        </div>
      </div>
      </div>
      <div class="header_mid">
        <div class="title_start">
          <h2 class="title">도착지</h2>
          <div class="explanation">어디로 배송할까요?</div>
        </div>
        <div class="np">
          <div class="name">
            <input type="text" name ="Arr_Name" placeholder="고객명/상호*(한글)" autocomplete="off" id="Arr_Name" >
          </div>
          <div class="phone">
            <input type="text" name ="Arr_PN" placeholder="연락처*(-를 빼고넣으세요.)" autocomplete="off" id="Arr_PN" onblur="validatePhoneNumber(this.value , 'Arr_PN')">
               <span id="Arr_PN_error" style="color: red;"></span>
          </div>
        </div>
        <div class="np">
          <div class="post">
          <input type="text" name ="Arr_Add1" placeholder="우편번호*" autocomplete="off" id="Arr_Add1">
        </div>
          <div class="searchadd">
            <input type="button" onclick="sample4_execDaumPostcode(2)" value="우편번호 찾기">
          </div>
        </div>
        <div class="np">
          <div class="address">
            <input type="text" name ="Arr_Add2" placeholder="주소*" autocomplete="off" id="Arr_Add2">
          </div>
        </div>
        <div class="np">
        <div class="plus">
          <input type="text" name ="Arr_Add3" placeholder="상세주소*" autocomplete="off" id="Arr_Add3" onblur="validateAddress(this.value,'Arr_Add3')">
         <span id="Arr_Add3_error" style="color: red;"></span>
        </div>
        </div>
        <div class="header_order">
          <div class="title_start">
            <h2 class="title">주문 확인</h2>
            <div class="explanation">예상 금액을 확인할 수 있습니다.</div>
          </div>
          <div class="title_end">
            <div class="money">
              <div class="text">예상요금</div>
           <input type="text" id="User_Money" name="User_Money"  value="10000" readonly>

           <b>원</b>
            </div>
          </div>
          <div class="redtext">
            * 현재 예상 요금은 예상치이므로 수행 시의 날씨나 지역에 <br> 따라 변동 될수있습니다.<br>변동이 발생하는 경우에는 운송사에서 별도의 안내드립니다.
          </div>
        </div>
      </div>
   
    </section>
    <section class="mid_post">
      <div class="title_start">
        <h2 class="title">운송 선택</h2>
        <div class="explanation">운송 방식을 선택해주세요.</div>
        
      </div>
      <div class="selectT">
      <ul>
        <li><input type="radio" name="User_Ship" value="1" onclick="handleRadioChange(this)" onchange="changeText()" checked>대중교통</li>
        <li><input type="radio" name="User_Ship" value="2" onclick="handleRadioChange(this)" onchange="changeText()">오토바이</li>
        <li><input type="radio" name="User_Ship" value="3" onclick="handleRadioChange(this)" onchange="changeText()">라보</li>
      </ul>
      <ul>
        <li><input type="checkbox" name="User_ShipT" value="1" onchange="changeText()" id="opencheck1" disabled>왕복</li>
        <li><input type="checkbox" name="User_ShipQ" value="1" onchange="changeText()" id="opencheck2" disabled>급송</li>
      </ul>
       </div>
      <div class="quest_last">
            <p>  
          대중교통 : 서류 1~2봉 3kg 내<br>
          오토바이 : 100cm x 50cm x 50cm 20kg 내<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(가로 &nbsp;&nbsp;x 세로 &nbsp;&nbsp;x 높이)<br>
          라보&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     : 140cm x 220cm	500kg 내<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(가로 &nbsp;&nbsp;x 세로)  
        </p>
      </div>
      <div class="title_end">
        <h2 class="title">물품 메모</h2>
        <div class="explanation">물품의 상세 정보를 적어주세요</div>
      </div>
      <textarea name ="User_Text"  id= "User_Text" placeholder="예시 1) 서류 2보 있어요! 

예시 2) 6호 박스 2개있어요. 20kg 안넘어유~
    
추가로 전달할 사항이 있으면 알려주세요." cols="50" rows="10" ></textarea><br>
      <div class="redtext">*물품이 파손의 위험이나 고가의 물건인 경우 반드시 메모를 해주세요.</div>
      <div class="title_end">
        <h2 class="title">결제수단</h2>
        <div class="explanation">결제 방법을 선택해주세요.</div>
      </div>
      <div class="selectT">
      <ul>
        <li><input type="radio" name="User_PayS" value="0"  onclick="setPay()" checked>카드결제</li>
        <li><input type="radio" name="User_PayS" value="1"  onclick="setPay()" >계좌이체</li>
        <li><input type="radio" name="User_PayS" value="2"  onclick="setPay()" >선불</li>
        <li><input type="radio" name="User_PayS" value="3"  onclick="setPay()" >착불</li>
      </ul>
      </div>
      <div class="quest_in">
       <!--  <input type="submit" value="접수하기" onclick="requestPay()"> -->
        
        <input type="hidden" id="paymentStatus" name="paymentStatus">
       

		<button class= "paymentbt" type="button" onclick="requestPay()">결제하기</button>
		
		<script>
		  const userCode = "imp14397622";
		  IMP.init(userCode);		
		</script>
        
		
  
      </div>
    </section>
  </div>
      </form>   
<%@ include file="../footer/footer.jsp" %>    

</script>      
</body>
</html>