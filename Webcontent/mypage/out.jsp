<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>퀘스트샵</title>
<script type="text/javascript" src="script/out.js"></script>
<link rel="stylesheet" href="css/out.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link rel="shortcut icon" href="img/questlogo.png" type="image/x-icon">
</head>

<body>
<%@ include file="../header/header.jsp" %> 
<form action="memberDelete.do" method="post" name="frm">
<input type="hidden" name=command value="${mVo.userid}">
	<div class="free">

		 <section id="left_main">
        <h3>왼쪽 내용</h3>
    <aside id="left">
        <div id="title">
            <a href="mypage.do" style="color:white">마이 페이지</a>
        </div>      
        <ul class="secu">
            <li><a href="memberUpdate.do">개인정보 수정</a></li>            
            <li><a href="NoticeServlet?command=qna_list">문의 내역</a></li>          
            <li><a href="memberDelete.do">회원탈퇴</a></li>                                  
        </ul>
    </aside>
    </section>

		<section id="right_main">
			<h3>중앙 내용</h3>
			<div id="right">
				<div class="title">
					<div class="o">회원 탈퇴</div>
					<div class="t">
						<div class="te">
							<h4>회원 탈퇴</h4>
							<p style="color: red;">회원탈퇴 즉시 회원정보는 모두 삭제되며, 재가입시에도 복원되지
								않습니다.</p>
							<ul>
								<li><b><b>·</b></b> 삭제되는 정보 : 개인정보, 계좌내역</li>
								<li><b><b>·</b></b> 회원탈퇴 시 활동하신 내역들은 모두 삭제됩니다. 회원탈퇴 후 ID로
									사용 권한을 양도하실 수 없습니다.</li>
								<li><b><b>·</b></b> 탈퇴 후 삭제된 데이터는 복구되지 않습니다.</li>
								<li><b><b>·</b></b> 퀘스트 수주에 등록한 게시물은 삭제되지 않고 유지됩니다.</li>
							</ul>

							<hr>

							<h4>1개월간 회원 재가입 제한</h4>
							<p>회원탈퇴 후, 1개월간은 회원 재가입이 불가능합니다.</p>

							<hr>

							<h4>탈퇴 후 정보보관</h4>
							<p>
								전자상거래 등에서의 소비자보호에 관한 법률 제6조에 의거 성명, 주소 등 거래의 주체를 식별할 수 있는 정보에
								한하여 서비스 <br>이용에 관한 동의를 철회한 경우에도 이를 보존할 수 있으며, 동법 시행령 제6조에
								의거 다음과 같이 거래 기록을 보관합니다.
							</p>

							<hr>

							<div>
								<h4>모험가님의 정보를 확인해주세요.</h4>
								<p>회원 탈퇴 후 모두 소멸됩니다.</p>								
							</div>

							<hr>													
						</div>
												
						<div align="center">														
								<table style="width: 80%">
									<tr>
										<th>비밀번호</th>
										<td>
										<input type="hidden" name="userid" id="userid" value="${userid}">							
										<input type="password" name="pwd" id="pwd" size="20">
										</td>
									</tr>
								</table>
								<br> <input type="submit" class="outbt" value="탈퇴"
									onclick="return passCheck()"> 
							</form>
						</div>


					</div>
				</div>

			</div>
		</section>


	</div>

<%@ include file="../footer/footer.jsp" %> 
</body>
</html>