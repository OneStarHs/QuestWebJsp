package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.QnaDAO;
import dto.QnaVO;

public class AdminQnaDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "admin/qna/qnaDetail.jsp";
		 String qna_Seq = request.getParameter("qna_Seq").trim();
		 QnaDAO qDao = QnaDAO.getInstance();
		 QnaVO qnaVO = qDao.getQna(Integer.parseInt(qna_Seq));
		 request.setAttribute("qnaVO", qnaVO);
		 
		 request.getRequestDispatcher(url).forward(request, response);

	}

}
