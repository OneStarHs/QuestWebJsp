package admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.acceptedDAO;
import dto.PageVO;
import dto.acceptedVO;

public class AdminOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="admin/order/oderList.jsp";
		int pageNum = 1;
		int amount = 10;
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		acceptedDAO aDao = acceptedDAO.getInstance();
		List<acceptedVO> acceptedList = aDao.getList(pageNum, amount);
		int total = aDao.getTotal(); // 전체게시글수
		PageVO pageVO = new PageVO(pageNum, amount, total);
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("acceptedList", acceptedList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
