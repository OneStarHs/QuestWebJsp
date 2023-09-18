package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeDAO;
import dao.QnaDAO;
import dto.NoticeVO;
import dto.PageVO;
import dto.QnaVO;

/**
 * Servlet implementation class CenterServlet
 */
@WebServlet("/center.do")
public class CenterServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	   HttpSession session = request.getSession();
       String userIdcheck = (String)session.getAttribute("loginUser");
       
       	if (userIdcheck != null) {        
    	QnaDAO qnaDAO = QnaDAO.getInstance();
  		List<QnaVO> qnalist = qnaDAO.getlist(userIdcheck);  		
  		request.setAttribute("qnalist", qnalist); 
  		}       

       	int pageNum = 1;
		int amount = 5;
		if(request.getParameter("pageNum") != null && request.getParameter("amount") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		NoticeDAO nDao = NoticeDAO.getInstance();
		List<NoticeVO> noticeList = nDao.getList(pageNum, amount);
		int total = nDao.getTotal(); // 전체게시글수
		PageVO pageVO = new PageVO(pageNum, amount, total);
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("noticeList", noticeList);
          //접근허용 (로그인상태)
          if (userIdcheck == null) {
             RequestDispatcher dispatcher = request.getRequestDispatcher("center/center.jsp");
              dispatcher.forward(request, response);
          } else if(userIdcheck != null) {
        	  RequestDispatcher dispatcher = request.getRequestDispatcher("center/center.jsp");
              dispatcher.forward(request, response);
          }
      }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}