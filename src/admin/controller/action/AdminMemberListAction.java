package admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.Action;
import dao.MemberDAO;
import dto.MemberVO;
import dto.PageVO;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url ="admin/member/memberList.jsp";
		int pageNum = 1;
		int amount = 10;
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		MemberDAO mDao = MemberDAO.getInstance();
		List<MemberVO> memberList = mDao.getList(pageNum, amount);
		for (MemberVO member : memberList) {
			int acceptedCount = mDao.getAcceptedCount(member.getUserid());
			member.setAcceptedCount(acceptedCount);
		}
		int total = mDao.getTotal(); // 전체게시글수
		PageVO pageVO = new PageVO(pageNum, amount, total);
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("memberList", memberList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
 
	}

}
