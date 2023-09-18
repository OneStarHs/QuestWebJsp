package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.QnaDAO;
import dto.QnaVO;

public class AdminQnaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String qna_Seq = request.getParameter("qna_Seq");   
		//int qna_Seq = Integer.parseInt(request.getParameter("qna_Seq"));			  
		    System.out.println(qna_Seq);
			QnaDAO qDao = QnaDAO.getInstance();		
			qDao.deleteQna(qna_Seq);
			System.out.println(qna_Seq);
			response.sendRedirect("NoticeServlet?command=admin_qna_list");

	}

}
