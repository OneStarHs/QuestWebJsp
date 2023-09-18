package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.acceptedDAO;
import dto.PageVO;
import dto.acceptedVO;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
	    String Idcheck = (String)session.getAttribute("loginUser");
	    
	    if (Idcheck != null) {
	        // 추가된 부분 시작
	    	int pageNum = 1;
			int amount = 15;
			if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
				amount = Integer.parseInt(request.getParameter("amount"));
			}
	    	
//	        List<acceptedVO> acceptedList = mDao.selectAllNotices(Idcheck);
//	        request.setAttribute("acceptedList", acceptedList);
//	        request.setAttribute("Idcheck", Idcheck);	        

			acceptedDAO mDao = acceptedDAO.getInstance();
			List<acceptedVO> aList = mDao.getListA(pageNum, amount, Idcheck);
			int total = mDao.gettal(Idcheck); // 전체게시글수
			PageVO pageVO = new PageVO(pageNum, amount, total);
			request.setAttribute("pageVO", pageVO);
			request.setAttribute("acceptedList", aList);
			request.setAttribute("Idcheck", Idcheck);
	        
	       

	        RequestDispatcher dispatcher = request.getRequestDispatcher("mypage/my_page.jsp");
	        dispatcher.forward(request, response);
	    } else {
	        response.sendRedirect("login.do"); // 로그인 페이지로 리다이렉트
	    }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}

}
