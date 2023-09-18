function FindPwCheck() {
    if (document.getElementById("pwd").value.length === 0) {
        alert("변경할 비밀번호를 입력해 주세요.");
        document.getElementById("pwd").focus();
        return false;
    }
    if (document.getElementById("pwd").value.length < 8 || document.getElementById("pwd").value.length > 12) {
        alert("비밀번호는 최소 8글자, 최대 12글자 이내로 입력해 주세요.");
        document.getElementById("pwd").focus();
        return false;
    }
    if (document.getElementById("pwd").value !== document.getElementById("passwordConfirm").value) {
        alert("비밀번호가 일치하지 않습니다.");
        document.getElementById("passwordConfirm").focus();
        return false;
    }
    return true;
}
