function validatepwd(pwd, elementId) {
    var pwdRegex = /^.{8,}$/;
    var errorSpan = document.getElementById(elementId + '_error');
    
    if (!pwdRegex.test(pwd)) {
      errorSpan.textContent = '비밀번호는 8글자 이상이어야 합니다.';
    } else {
      errorSpan.textContent = '';
    }
  }

  function validatePhoneNumber(phone, elementId) {
    var phoneRegex = /^010\d{3,4}\d{4}$/;
    var errorSpan = document.getElementById(elementId + '_error');
    
    if (!phoneRegex.test(phone)) {
      errorSpan.textContent = '휴대폰 번호를 입력하세요.(-없이)';
    } else {
      errorSpan.textContent = '';
    }
   }

   function validatePwdMatch(pwdCheck, pwdElementId) {
    var pwdInput = document.getElementById(pwdElementId);
    var pwdMatchError = document.getElementById('pwd_match_error');
  
    if (pwdInput.value !== pwdCheck) {
      pwdMatchError.textContent = '비밀번호가 일치하지 않습니다.';
    } else {
      pwdMatchError.textContent = '';
    }
  }







// 이메일 선택
$(document).ready('#selectEmail').change(function(){
    $("#selectEmail option:selected").each(function () {
     
     if($(this).val()== '1'){ //직접입력일 경우
        $("#email02").val('');                        //값 초기화
        $("#email02").attr("disabled",false); //활성화
     }else{ //직접입력이 아닐경우
        $("#email02").val($(this).text());      //선택값 입력
        $("#email02").attr("disabled",true); //비활성화
     }
    });
 });

// 주소 찾기
 function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('add1').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('add2').value = fullRoadAddr;
            document.getElementById('add3').value = data.jibunAddress;

            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                //예상되는 도로명 주소에 조합형 주소를 추가한다.
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

            } else {
                document.getElementById('guide').innerHTML = '';
            }
        }
    }).open();
 }
 

