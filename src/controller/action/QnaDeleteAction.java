package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QnaDAO;

public class QnaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qna_Seq = request.getParameter("qna_Seq");   
		//int qna_Seq = Integer.parseInt(request.getParameter("qna_Seq"));			  
		    System.out.println(qna_Seq);
			QnaDAO qDao = QnaDAO.getInstance();		
			qDao.deleteQna(qna_Seq);
			System.out.println(qna_Seq);
			response.sendRedirect("NoticeServlet?command=qna_list");

	}

}
