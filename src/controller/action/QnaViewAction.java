package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDAO;
import dto.QnaVO;

public class QnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		String url = "qna/qnaView.jsp";
				HttpSession session = request.getSession();
				String loginUserid = (String) session.getAttribute("loginUser");
		 if (loginUserid == null) {
		 url = "login.do";
		 } else {
		 int qna_Seq = Integer.parseInt(request.getParameter("qna_Seq"));
		 QnaDAO qnaDAO = QnaDAO.getInstance();
		 QnaVO qnaVO = qnaDAO.getQna(qna_Seq);
		 request.setAttribute("qnaVO", qnaVO);
		 }
		 request.getRequestDispatcher(url).forward(request, response);


	}

}
