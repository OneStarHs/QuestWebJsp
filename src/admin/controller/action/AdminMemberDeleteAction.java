package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.MemberDAO;

public class AdminMemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String userid = request.getParameter("userid");
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.AdmindeleteMember(userid);
		
		response.sendRedirect("NoticeServlet?command=admin_member_list");


	}

}
