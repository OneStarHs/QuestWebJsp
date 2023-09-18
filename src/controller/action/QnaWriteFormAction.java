package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QnaWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaWrite.jsp";
		 
		 HttpSession session = request.getSession();
		 String loginUserid = (String) session.getAttribute("loginUser");
		 
		 if (loginUserid == null) {
		 url = "login.do";
		 } 
		 
		 request.getRequestDispatcher(url).forward(request, response);
		 }
		}
	