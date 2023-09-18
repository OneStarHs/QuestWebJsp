package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDAO;
import dto.QnaVO;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "NoticeServlet?command=qna_list";

		HttpSession session = request.getSession();
		String loginUserid = (String) session.getAttribute("loginUser");

		if (loginUserid == null) {
			url = "NoticeServlet?command=login_form";
		} else {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setQna_Title(request.getParameter("qna_Title"));
			qnaVO.setQna_Content(request.getParameter("qna_Content"));
			QnaDAO qnaDAO = QnaDAO.getInstance();
			qnaDAO.insertqna(qnaVO, loginUserid);
		}
		response.sendRedirect(url);
	}
}
