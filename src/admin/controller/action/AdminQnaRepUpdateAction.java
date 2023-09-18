package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.QnaDAO;
import dto.QnaVO;

public class AdminQnaRepUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	 QnaVO qVo = new QnaVO();
	 
	 qVo.setQna_Seq(Integer.parseInt(request.getParameter("qna_Seq")));
	 qVo.setQna_Reply(request.getParameter("qna_Reply"));
	 
		QnaDAO qDao = QnaDAO.getInstance();
		qDao.updateRepQna(qVo);
		System.out.println("답변수정중");

		response.sendRedirect("NoticeServlet?command=admin_qna_list");

	}
	}


