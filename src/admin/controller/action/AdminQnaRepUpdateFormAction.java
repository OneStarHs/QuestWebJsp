package admin.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.QnaDAO;
import dto.QnaVO;

public class AdminQnaRepUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="/admin/qna/qnaRepUpdate.jsp";
		String qna_SeqString = request.getParameter("qna_Seq");
		 System.out.println(qna_SeqString);
	    int qna_Seq = Integer.parseInt(qna_SeqString);
	    QnaDAO qDao = QnaDAO.getInstance();
	    QnaVO qVo = qDao.getQnare(qna_Seq);
	    System.out.println(qna_Seq);
	   
	    request.setAttribute("qna", qVo);
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}

}
