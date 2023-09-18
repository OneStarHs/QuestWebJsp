function validatePhoneNumber(phoneNumber, elementId) {
  var phoneRegex = /^010\d{3,4}\d{4}$/;
  var errorSpan = document.getElementById(elementId + '_error');
  
  if (!phoneRegex.test(phoneNumber)) {
    errorSpan.textContent = '휴대폰 번호를 입력하세요.(-없이)';
  } else {
    errorSpan.textContent = '';
  }
}

function validateAddress(address, elementId) {
  var errorSpan = document.getElementById(elementId + '_error');
  
  if (address.trim() === '') {
    errorSpan.textContent = '상세주소를 입력해주세요. : )';
  } else {
    errorSpan.textContent = '';
  }
}

function handleRadioChange(radio) {
var checkbox1 = document.getElementById('opencheck1');
var checkbox2 = document.getElementById('opencheck2');
  if (radio.value!=1) {
    checkbox1.disabled = false;
    checkbox2.disabled = false;
   
  } else  {
    checkbox1.disabled = true;
    checkbox2.disabled = true;
    checkbox1.checked = false;
    checkbox2.checked = false;
  }
}
//function setPay(){
//    console.log("버튼이 클릭되었습니다.");
//    var radios = document.getElementsByName("User_PayS");
//    var seletPay;    
//    for (var i = 0; i < radios.length; i++) {
//        if (radios[i].checked) {
//            seletPay = radios[i].value;
//          break;
//        }
//	}
//	 console.log(seletPay);
//	 document.getElementById('User_PayS').value=seletPay;
//}    


function sample4_execDaumPostcode(c) {
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
          if(c==1){
          document.getElementById('Dep_Add1').value = data.zonecode;
          document.getElementById("Dep_Add2").value = roadAddr+"("+jibunAddress+")";
           //커서이동
          document.getElementById("Dep_Add3").focus();
          }else{
			    document.getElementById('Arr_Add1').value = data.zonecode;
          document.getElementById("Arr_Add2").value = roadAddr+"("+jibunAddress+")";
           //커서이동
          document.getElementById("Arr_Add3").focus();  
		  }
          
         
    
     var guideTextBox = document.getElementById("guide");
      }
  }).open();
}

  function changeText(radio) {
  var totalPrice = 0;
  var quick = 10000;
  var real= 0;
 
  var selectedRadio = document.querySelector('input[name="User_Ship"]:checked');
  console.log(selectedRadio);
  if (selectedRadio.value == 1) {
       totalPrice = 10000;
  }
  if (selectedRadio.value == 2){
	   totalPrice = 20000;
  } 
  if (selectedRadio.value == 3){
	   totalPrice = 30000;
  }
  

  var checkboxes = document.querySelectorAll('input[name="User_ShipT"]:checked');
  checkboxes.forEach(function(checkbox) {
    var checkboxPrice = parseInt(checkbox.value);
    console.log(checkboxPrice);
    if (checkboxPrice === 1) {
      totalPrice *= 2;;
    }
  });
    var checkboxes2 = document.querySelectorAll('input[name="User_ShipQ"]:checked');
  checkboxes2.forEach(function(checkbox) {
    var checkboxPrice2 = parseInt(checkbox.value);
    console.log(checkboxPrice2);
    if (checkboxPrice2 === 1) {
      totalPrice += quick;
      real = real+2;
    }
  });
   document.getElementById('User_Money').value = totalPrice;   
 }
 
 
function requestPay(){
  // 고객명/상호: 비어 있거나 형식에 맞지 않으면 false 반환
  if (myacc.Dep_Name.value.length == 0||!/^([가-힣])*$/g.test(myacc.Dep_Name.value) ) {
    alert("올바른 출발지 고객명/상호를 입력하세요.");
    myacc.Dep_Name.focus();
    return false;
  }

  // 연락처 체크: 비어 있거나 형식에 맞지 않으면 false 반환
  if (myacc.Dep_PN.value.length==0 || !/^010\d{7,8}$/.test(myacc.Dep_PN.value)) {
    alert("올바른 출발지 연락처를 입력하세요.");
     myacc.Dep_PN.focus();
    return false;
  }

  // 주소 체크: 비어 있으면 false 반환
  if (myacc.Dep_Add1.value.length==0||!/^\d{5}$/.test(myacc.Dep_Add1.value)) {
    alert("올바른 출발지 우편번호를 입력하세요.");
   myacc.Dep_Add1.focus();
    return false;
  }
    if (myacc.Dep_Add2.value.length==0) {
    alert("올바른 출발지 주소를 입력하세요.");
     dmyacc.Dep_Add2.focus();
    return false;
  }
    if (myacc.Dep_Add3.value.length==0) {
    alert("올바른 출발지 상세주소를 입력하세요.");
     myacc.Dep_Add3.focus();
    return false;
  }
    // 고객명/상호: 비어 있거나 형식에 맞지 않으면 false 반환
  if (myacc.Arr_Name.value.length == 0||!/^([가-힣])*$/g.test(myacc.Arr_Name.value)) {
    alert("올바른 도착지 고객명/상호를 입력하세요.");
   myacc.Arr_Name.focus();
    return false;
  }

  // 연락처 체크: 비어 있거나 형식에 맞지 않으면 false 반환
  if (myacc.Arr_PN.value.length == 0 || !/^010\d{7,8}$/.test(myacc.Arr_PN.value)) {
    alert("올바른 도착지 연락처를 입력하세요.")
   myacc.Arr_PN.focus();
    return false;
  }

  // 주소 체크: 비어 있으면 false 반환
  if (myacc.Arr_Add1.value.length==0||!/^\d{5}$/.test(myacc.Arr_Add1.value)) {
    alert("올바른도착지 우편번호를 입력하세요.");
      myacc.Arr_Add1.focus();
    return false;
  }
    if (myacc.Arr_Add2.value.length==0) {
    alert("올바른 도착지 주소를 입력하세요.");
    myacc.Arr_Add2.focus();
    return false;
  }
    if (myacc.Arr_Add3.value.length==0) {
    alert("올바른 도착지 상세주소를 입력하세요.");
   myacc.Arr_Add3.focus();
    return false;
  }   
  
  var radios = document.getElementsByName("User_PayS");
    var selectedPayMethod;

    for (var i = 0; i < radios.length; i++) {
      if (radios[i].checked) {
        selectedPayMethod = radios[i].value;
        break;
      }
    }
  
   const amount = parseInt(document.getElementById("User_Money").value);
   
   if (selectedPayMethod === "0") {
      // 카드 결제일 때
      IMP.request_pay({
	    pg: "tosspayments",
	    pay_method: "card",
	    merchant_uid: "test_lkt1ab2g",
	    name: "테스트 결제",
	    amount: amount,
	    buyer_tel: "010-0000-0000",
  	}, function (rsp) {
        // 결제가 완료되거나 취소되었을 때
        if (rsp.success) {
          document.getElementById("paymentStatus").value = "completed"; // 결제 완료 상태
	        document.myacc.submit();
        } else {
          document.getElementById("paymentStatus").value = "cancelled"; // 결제 취소 상태
        }
        // 결제 완료 후 폼을 제출
      });
    } else if(selectedPayMethod === "1"){
      	IMP.request_pay({
	    pg: "tosspayments",
	    pay_method: "trans",
	    merchant_uid: "test_lks04m3q",
	    name: "테스트 결제",
	    amount: amount,
	    buyer_tel: "010-0000-0000",
	    buyer_email: "buyer@example.com",
	  	}, function (rsp) {
        // 결제가 완료되거나 취소되었을 때
        if (rsp.success) {
          document.getElementById("paymentStatus").value = "completed"; // 결제 완료 상태
        document.myacc.submit();
        } else {
          document.getElementById("paymentStatus").value = "cancelled"; // 결제 취소 상태
        }
        // 결제 완료 후 폼을 제출
      });
    } else if(selectedPayMethod === "2" || selectedPayMethod === "3"){
		document.getElementById("paymentStatus").value = "completed";		
        document.myacc.submit();      
	}

    return true;
  }
  


