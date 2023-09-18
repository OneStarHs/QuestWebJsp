<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
if (window.name == "update") {
window.opener.parent.location.href = 
	"NoticeServlet?command=notice_update_form&notice_num=${param.notice_num}";
} else if (window.name == 'delete') {
alert('삭제되었습니다.');
window.opener.parent.location.href =
	"NoticeServlet?command=notice_delete&notice_num=${param.notice_num}";
}
window.close();
</script>
</body>
</html>