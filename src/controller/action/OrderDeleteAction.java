package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.acceptedDAO;

public class OrderDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String reg_Num = request.getParameter("reg_Num");
			
			acceptedDAO aDao = acceptedDAO.getInstance();
			aDao.AdminOrderDelete(reg_Num);
			
			response.sendRedirect("NoticeServlet?command=order_delete");

	}

}
