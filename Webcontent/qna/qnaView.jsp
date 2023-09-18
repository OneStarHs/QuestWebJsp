<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="css/Notice_Alert.css"> -->
<link rel="stylesheet" href="css/Notice.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link rel="stylesheet" type="text/css" href="css/qna.css">
<script type="text/javascript" src="script/qna.js"></script>
<script>
function confirmDelete(qna_Seq) {
	  if (confirm("삭제하시겠습니까?")) {
	    // 삭제를 확인한 경우 처리할 로직을 작성합니다.
	    // 여기에서는 NoticeServlet을 호출하여 삭제를 수행하는 예시입니다.
	    window.location.href = "NoticeServlet?command=qna_delete&qna_Seq=" + qna_Seq;
	  }
	}
</script>

</head>
<body>
	<%@ include file="../header/header.jsp"%>
	<div class="color1">
		<section id="top">
			<div class="Notice">
				<h2>문의내역</h2>
			</div>
			<div class="search-window"></div>
		</section>
	</div>


	<div class="free">


		<div class="qnaview" align="center">
			<form name="formm" method="post">
				<table class="qnatbl2">
					<caption>
						<h2>${qnaVO.qna_Title}</h2>
					</caption>
					<tr class="qnadate">
						<th></th>
						<td><fmt:formatDate value="${qnaVO.qna_Date}"
								type="date" /></td>
					</tr>
					<tr>
						<th>질문내용</th>
						<td><div class="qnacontent">
								<div class="qna-box">${qnaVO.qna_Content}</div>
							</div></td>
					</tr>
					<tr>
						<th>답변 내용</th>
						<td><div class="qnacontent">
								<div class="qna-box">
								<c:choose>
										<c:when test="${qnaVO.qna_Rep==2}">${qnaVO.qna_Reply}</c:when>									
										<c:otherwise><br><span class="noreply"> &nbsp &nbsp 답변이 아직 등록되지 않았습니다.</span></c:otherwise>
									</c:choose></div>
							</div></td>
					</tr>
				</table>
				
				<div class="clear"></div>
				<div id="buttonss">
				<span id="btn_qna2"><input type="button" value="목록" class="cancel" onclick="goBack()" > </span>
				<span id="btn_qna2"><input type="button" value="삭제" class="submit" onclick="confirmDelete('${qnaVO.qna_Seq}')">
				<span id="btn_qna2"><input type="button" value="1:1 질문하기" class="cancel"
								onclick="location.href='NoticeServlet?command=qna_write_form'"></span>
				</div>
				
			</form>

		</div>
	</div>

	<%@ include file="../footer/footer.jsp"%>
</body>
</html>
