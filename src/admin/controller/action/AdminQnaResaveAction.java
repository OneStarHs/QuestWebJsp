package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.QnaDAO;
import dto.QnaVO;

public class AdminQnaResaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		 //String url = "NoticeServlet?command=admin_qna_detail";
		 String qna_Seq = request.getParameter("qna_Seq").trim();
		 String qna_Reply =request.getParameter("qna_Reply").trim();
		 System.out.println("댓글들어옴");
		 QnaVO qnaVO = new QnaVO();
		 qnaVO.setQna_Seq(Integer.parseInt(qna_Seq));
		 qnaVO.setQna_Reply(qna_Reply); 
		 QnaDAO qnaDAO = QnaDAO.getInstance();
		 qnaDAO.updateQna(qnaVO);
		 
		 // 수정한 게시물로 이동하기 위해 상세 페이지 URL을 생성합니다.
		 String url = "NoticeServlet?command=admin_qna_detail&qna_Seq=" + qna_Seq;
		 response.sendRedirect(url);
		 System.out.println(url);

	}

}
