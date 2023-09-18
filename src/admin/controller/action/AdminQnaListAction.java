package admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.QnaDAO;
import dto.PageVO;
import dto.QnaVO;

public class AdminQnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/qna/qnaList.jsp";
		int pageNum = 1;
		int amount = 10;
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		 QnaDAO qnaDAO = QnaDAO.getInstance();
		 ArrayList<QnaVO> qnaList = qnaDAO.listAllQna(pageNum,amount);
		 int total = qnaDAO.getTotal(); // 전체게시글수
		 PageVO pageVO = new PageVO(pageNum, amount, total);
		 request.setAttribute("pageVO", pageVO);
		 request.setAttribute("qnaList", qnaList);
		 request.getRequestDispatcher(url).forward(request, response);
		 }
		

	}


