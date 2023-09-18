function noticeCheck() {
	
	if (document.frm.notice_Title.value.length == 0) {
		alert("제목 입력하세요.");
		frm.notice_Title.focus();
		return false;
	}
	if (document.frm.notice_Content.value.length == 0) {
		alert("내용을 입력하세요.");
		frm.notice_Content.focus();
		return false;
	}if (document.frm.notice_Pw.value == "") {
		alert("비밀번호를 입력하세요.");
		frm.notice_Pw.focus();
		return false;
	}
	return true;
}

function deleteconfirm(notice_num) {
  // 삭제 확인 메시지를 표시합니다.
  var confirm = window.confirm("이 게시글을 삭제하시겠습니까?");
  // 사용자가 확인을 클릭한 경우 게시글 삭제를 진행합니다.
  if (confirm) {
    location.href = `NoticeServlet?command=admin_notice_delete&notice_num=${notice_num}`;
  }
}

function goBack() {
	window.history.back();
}

function passCheck() {
	if (document.frm.notice_Pw.value == "") {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}
function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}

$("#inotice").prop("checked",true);
$("#inotice").prop("checked",flase);
