
function goBack() {
	window.history.back();
}

function qnaCheck() {

	if (formm.qna_Title.value.length == 0) {
		alert("제목을 입력하세요.");
		formm.qna_Title.focus();
		return false;
	}
	if (formm.qna_Content.value.length == 0) {
		alert("내용을 입력하세요.");
		formm.qna_Content.focus();
		return false;
	}
	return true;
}
function go_list() {
		var theForm = document.frm;
		theForm.action = "NoticeServlet?command=admin_qna_list";
		theForm.submit();
	}
	function go_rep(qna_Seq) {
		var theForm = document.frm;
		theForm.qna_Seq.value = qna_Seq;
		theForm.action = "NoticeServlet?command=admin_qna_repsave";
		theForm.submit();
	}