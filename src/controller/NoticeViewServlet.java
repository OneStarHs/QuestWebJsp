package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import dto.NoticeVO;

@WebServlet("/noticeView.do")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/notice/noticeView.jsp";
		
		String notice_num = request.getParameter("notice_num");
		NoticeDAO nDao = NoticeDAO.getInstance();
		//nDao.updateReadCount("Notice_num");
		NoticeVO nVo = nDao.selectOneNoticeByNum(notice_num);
		request.setAttribute("notice", nVo);
		System.out.println(notice_num);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
