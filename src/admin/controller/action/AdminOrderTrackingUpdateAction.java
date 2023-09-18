package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.acceptedDAO;
import dto.acceptedVO;

public class AdminOrderTrackingUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reg_Num = request.getParameter("reg_Num");
		String tracking = request.getParameter("tracking");
		acceptedVO aVo = new acceptedVO();
		aVo.setReg_Num(Integer.parseInt(request.getParameter("reg_Num")));
		aVo.setTracking(request.getParameter("tracking"));
		
		 acceptedDAO aDao = acceptedDAO.getInstance();
		 aDao. updateTracking(reg_Num, tracking);
		 response.sendRedirect("NoticeServlet?command=admin_order_list");

	}

}
