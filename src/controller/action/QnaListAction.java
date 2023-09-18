package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDAO;
import dto.PageVO;
import dto.QnaVO;

public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	  throws ServletException, IOException {
		 String url = "qna/qnaList.jsp";
		 int pageNum = 1;
		 int amount = 10;
		 if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
				amount = Integer.parseInt(request.getParameter("amount"));
			}
		 HttpSession session = request.getSession();
		 String loginUserid = (String) session.getAttribute("loginUser");

		 System.out.println(loginUserid);
		 if (loginUserid == null) {
		 url = "login.do";
		 } else {
		 QnaDAO qnaDAO = QnaDAO.getInstance();
		List<QnaVO> qnaList = qnaDAO.getListQ(pageNum,amount,loginUserid);
		 int total = qnaDAO.getTotals(loginUserid); // 전체게시글수
		 PageVO pageVO = new PageVO(pageNum, amount, total);
		 request.setAttribute("pageVO", pageVO);
		 request.setAttribute("qnaList", qnaList);
		 }
		 request.getRequestDispatcher(url).forward(request, response);
		 }
		}
		
		
//		String url = "qna/qnaList.jsp";
//		 
//		 HttpSession session = request.getSession();
//		 MemberVO member = (MemberVO) session.getAttribute("loginUser");
//		// 멤버 객체를 설정하고 로그인 처리
//		session.setAttribute("loginUser", member);
		 
		 
//		 if (member == null) {
//		 url = "login.do";
//		 } else {
//		 QnaDAO qnaDAO = QnaDAO.getInstance();
//		 ArrayList<QnaVO> qnaList = qnaDAO.listQna(member.getUserid());
//		 request.setAttribute("qnaList", qnaList);
//		 }
//		 request.getRequestDispatcher(url).forward(request, response);




