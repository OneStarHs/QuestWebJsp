

function handleRadioChange(radio) {
var checkbox1 = document.getElementById('opencheck1');
var checkbox2 = document.getElementById('opencheck2');
  if (radio.value!=10000) {
    checkbox1.disabled = false;
    checkbox2.disabled = false;
   
  } else  {
    checkbox1.disabled = true;
    checkbox2.disabled = true;
    checkbox1.checked = false;
    checkbox2.checked = false;
  }
}
function setPay(){
    console.log("버튼이 클릭되었습니다.");
    var radios = document.getElementsByName("setpays");
    var seletPay;
    
    for (var i = 0; i < radios.length; i++) {
        if (radios[i].checked) {
            seletPay = radios[i].value;
          break;
        }
      }
      if (seletPay) {
        switch (seletPay) {
          case '1':            
              IMP.request_pay({
                pg: "tosspayments",
                pay_method: "card",
                merchant_uid: "test_livfytj5",
                name: "테스트 결제",
                amount: 100,
                buyer_tel: "010-0000-0000",
              });
            
            break;
          case '2':
            window.location.href = 'https://www.yahoo.com';
            break;
            case '3':
              IMP.request_pay({
                pg: "tosspayments",
                pay_method: "trans",
                merchant_uid: "test_livg2j4o",
                name: "테스트 결제",
                amount: 100,
                buyer_tel: "010-0000-0000",
                buyer_email: "buyer@example.com",
              });;
            break;
    
}
}
}

function sample4_execDaumPostcode() {
  new daum.Postcode({
      oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var roadAddr = data.roadAddress // 도로명 주소 변수;
          var jibunAddress = data.jibunAddress 
          var extraRoadAddr = ''; // 참고 항목 변수

          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
              extraRoadAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if(data.buildingName !== '' && data.apartment === 'Y'){
             extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
          }
          // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if(extraRoadAddr !== ''){
              extraRoadAddr = ' (' + extraRoadAddr + ')';
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('postcode').value = data.zonecode;
          document.getElementById("roadAddress").value = roadAddr+"("+jibunAddress+")";
          
          //커서이동
          document.getElementById("plusAddress").focus();
    
     var guideTextBox = document.getElementById("guide");
      }
  }).open();
}



  function changeText(radio) {
    var totalPrice = 0;
    var quick = 10000;
    

    
    var radio = document.querySelector('input[name="setshipping"]:checked');
    if(radio){
        totalPrice = radio.value;
        
    }
    var checkboxes = document.querySelectorAll('input[name="setoption"]:checked');
    checkboxes.forEach(function(checkbox) {
      var checkboxPrice = parseInt(checkbox.value);
      if(checkboxPrice == 1){
        totalPrice *=2;
      }
      if(checkboxPrice == 2){
        totalPrice = totalPrice*1+quick;
      }
    });
   
 
  
    var settext =  document.getElementById('resultText');
    settext.textContent = totalPrice+"원";

  }


