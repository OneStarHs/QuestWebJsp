function hashPassword(pwd) {
  var hashedPassword = CryptoJS.SHA256(pwd).toString();
  return hashedPassword;
}

function passCheck() {
	 var userPassword = '<%= request.getAttribute("USER_PW") %>'; // 서버로부터 전달된 비밀번호
    var inputPassword = document.frm.pwd.value; // 사용자가 입력한 비밀번호

    if (inputPassword.length == 0) {
        alert("비밀번호를 입력해주세요");
        frm.pwd.focus();
        return false;
    }
    
    var hashedInputPassword = hashPassword(inputPassword);

    if (inputPassword != userPassword) {
        alert("비밀번호가 일치하지 않습니다.");
        document.frm.pwd.focus();
        return false;
    }

    // 비밀번호가 일치하는 경우에는 폼 제출을 허용
    return true;
}