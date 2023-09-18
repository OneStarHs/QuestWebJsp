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


function go_rep(qna_Seq) {
	  var theForm = document.frm;
	  var replyTextarea = theForm.querySelector('textarea[name="qna_Reply"]');
	  if (replyTextarea.value.trim() === '') {
		    alert('답변을 입력해주세요');
		    return;
		  }
	  theForm.qna_Seq.value = qna_Seq;
	  theForm.action = "NoticeServlet?command=admin_qna_repsave";
	  theForm.submit();
	}

function goBack() {
  history.back();
}
function confirmDelete(qna_Seq) {
	  if (confirm("삭제하시겠습니까?")) {
	    // 삭제를 확인한 경우 처리할 로직을 작성합니다.
	    // 여기에서는 NoticeServlet을 호출하여 삭제를 수행하는 예시입니다.
	    window.location.href = "NoticeServlet?command=admin_qna_delete&qna_Seq=" + qna_Seq;
	  }
	}

</script>
</head>
<body style="overflow-x: hidden">
	<%@ include file="../header.jsp"%>
	<%@ include file="/admin/sub_menu.jsp"%>
	<div class="free" align="center">
		<div class="qnaview" align="center">
			<form name="frm" method="post">
			 <input type="hidden" name="qna_Seq" value="${qnaVO.qna_Seq}">		
				<table class="qnatbl2">
					<caption>
						<h2>${qnaVO.qna_Title}</h2>
					</caption>
					<tr class="qnadate">
						<th></th>
						<td><fmt:formatDate value="${qnaVO.qna_Date}" type="date" /></td>
					</tr>
					<tr>
					 <th>질문내용</th>
					 <td><div class="qnacontent">
					  <div class="qna-box">${qnaVO.qna_Content}</div>
					 </div></td>
					</tr>
					<tr>
				      <th>답글</th>
				      <td>
				       <div class="qnacontent">
					 <div class="qna-box">
					   <c:choose>
					     <c:when test="${qnaVO.qna_Rep==1}">
					       <textarea name="qna_Reply" rows="3" cols="50"></textarea>					      
					     </c:when>									
					     <c:otherwise>
					       ${qnaVO.qna_Reply}
					     </c:otherwise>
					   </c:choose>
					  </div>
					</div>
				      </td>
    				</tr>
				</table>		
					 <div id="buttonss">
					  <span id="btn_qna2"><input type="button" value="목록" class="cancel" onclick="go_list()"></span> 
					 <c:choose>
				      <c:when test="${qnaVO.qna_Rep==1}">	
				       <span id="btn_qna2"><input type="button" class="submit" value="저장" onclick="go_rep('${qnaVO.qna_Seq}')"></span>			      
				      </c:when>									
				      <c:otherwise>
				      <span id="btn_qna2">
				      <input type="button" value="답변 수정하기" class="submit" onclick="location.href='NoticeServlet?command=admin_qna_repupdate_form&qna_Seq=${qnaVO.qna_Seq}'"></span>
				      </c:otherwise>
				      </c:choose>	
				       <span id="btn_qna2"><input type="button" value="삭제" class="cancel" onclick="confirmDelete('${qnaVO.qna_Seq}')">
				      
				        </span> 				 
					 </div>
				</form>
			</div>
		</div>
	
</body>
</html>