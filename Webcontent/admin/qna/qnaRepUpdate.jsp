<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/qna.css">
<link rel="stylesheet" href="css/Notice.css">
<script type="text/javascript" src="script/qna.js"></script>

<script>
function go_list() {
  var theForm = document.frm;
  theForm.action = "NoticeServlet?command=admin_qna_list";
  theForm.submit();
}

function go_rep(qna_Seq) {
	  var theForm = document.frm;
	  var replyTextarea = theForm.querySelector('textarea[name="qna_Reply"]');
	  if (replyTextarea.value.trim() === '') {
		    alert('답변을 입력해주세요');
		    return;
		  }
	  theForm.qna_Seq.value = qna_Seq;
	  theForm.action = "NoticeServlet?command=admin_qna_repsave";
	  alert('수정이 완료되었습니다.');
	  theForm.submit();
	}

function goBack() {
  history.back();
}
</script>
</head>
<body style="overflow-x: hidden">
	<%@ include file="../header.jsp"%>
	<%@ include file="/admin/sub_menu.jsp"%>
	<div class="free" align="center">
		<div class="qnaview" align="center">
			<form name="frm" method="post" action="NoticeServlet">
			<input type="hidden" name="command" value="admin_qna_repupdate">
			<input type="hidden" name="qna_Seq">
				<table class="qnatbl2">
					<caption>
						<h2>${qna.qna_Title}</h2>
					</caption>
					<tr class="qnadate">
						<th></th>
						<td><fmt:formatDate value="${qna.qna_Date}" type="date" /></td>
					</tr>
					<tr>
					 <th>질문내용</th>
					 <td><div class="qnacontent">
					  <div class="qna-box">${qna.qna_Content}</div>
					 </div></td>
					</tr>
					<tr>
				      <th>답글</th>
				      <td>
				       <div class="qnacontent">
					 <div class="qna-box">
					   <textarea name="qna_Reply" rows="3" cols="50">${qna.qna_Reply}</textarea>
					      
					  </div>
					</div>
				      </td>
    				</tr>
				</table>
				<div id="buttonss">
				  <span id="btn_qna2"><input type="button" value="목록" class="submit" onclick="go_list()"></span> 
				  <span id="btn_qna2"><input type="button" class="cancel" value="답변 수정하기" onclick="go_rep('${qna.qna_Seq}')"></span>							  
				</div>
				</form>
			</div>
		</div>
	
</body>
</html>