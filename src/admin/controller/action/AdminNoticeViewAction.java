package admin.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.NoticeDAO;
import dto.NoticeVO;

public class AdminNoticeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = "/admin/notice/noticeView.jsp";
		
		String notice_num = request.getParameter("notice_num");
		NoticeDAO nDao = NoticeDAO.getInstance();
		//nDao.updateReadCount("Notice_num");
		NoticeVO nVo = nDao.selectOneNoticeByNum(notice_num);
		request.setAttribute("notice", nVo);
		System.out.println(notice_num);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
