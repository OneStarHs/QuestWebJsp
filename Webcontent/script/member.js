function change(a) {
	//console.log(a);
	//console.log(a.value);
	location.href = "MemberServlet?command=admin_member_list&pageNum=1&amount=" + a.value;
}
function confirmDelete(userid) {
	if (confirm("삭제하시겠습니까?")) {
		// 삭제를 확인한 경우 처리할 로직을 작성합니다.
		// 여기에서는 NoticeServlet을 호출하여 삭제를 수행하는 예시입니다.
		window.location.href = "NoticeServlet?command=admin_member_delete&userid=" + userid;
	}
}

function open_win(url, name) {
	window.open(url, name, "width=1500, height=500");
}