package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.MemberDAO;
import dao.acceptedDAO;

public class AdminOrderDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String reg_Num = request.getParameter("reg_Num");
		
			
			acceptedDAO aDao = acceptedDAO.getInstance();
			aDao.AdminOrderDelete(reg_Num);
			System.out.println("이건 뜨나 "+reg_Num);
			response.sendRedirect("NoticeServlet?command=admin_order_list");


	}

}
