package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDAO;
import dto.NoticeVO;
import dto.PageVO;

public class NoticeSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/notice/noticeList.jsp";
        int pageNum = 1;
        int amount = 10;
        if (request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
            amount = Integer.parseInt(request.getParameter("amount"));
        }
        NoticeDAO nDao = NoticeDAO.getInstance();
        String notice_Title = request.getParameter("notice_Title");
        List<NoticeVO> searchList = nDao.searchNotice(notice_Title, pageNum, amount);
        int total = nDao.getTotal(); // 전체게시글수
        PageVO pageVO = new PageVO(pageNum, amount, total);
        request.setAttribute("pageVO", pageVO);
        request.setAttribute("noticeList", searchList); //noticeList.jsp에 item "noticeList"
        request.getRequestDispatcher(url).forward(request, response);
    }

}