package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.NoticeDAO;

public class AdminNoticeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String notice_num = request.getParameter("notice_num");
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		nDao.deleteNotice(notice_num);
		
		response.sendRedirect("NoticeServlet?command=admin_notice_list");

	}

}
