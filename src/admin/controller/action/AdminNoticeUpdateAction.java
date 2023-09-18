package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.NoticeDAO;
import dto.NoticeVO;

public class AdminNoticeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeVO nVo = new NoticeVO();

		nVo.setNotice_num(Integer.parseInt(request.getParameter("notice_num")));
		nVo.setUser_Name(request.getParameter("user_Name"));
		//nVo.setNotice_Pw(request.getParameter("notice_Pw"));
		nVo.setNotice_Type(request.getParameter("notice_Type"));
		nVo.setNotice_Title(request.getParameter("notice_Title"));
		nVo.setNotice_Content(request.getParameter("notice_Content"));
		nVo.setNotice_img(request.getParameter("notice_img"));

		NoticeDAO nDao = NoticeDAO.getInstance();
		nDao.updateNotice(nVo);

		response.sendRedirect("NoticeServlet?command=admin_notice_list");

	}

}
