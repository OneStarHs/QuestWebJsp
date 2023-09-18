package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberVO;
import util.SHA256;

@WebServlet("/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	String url = "/mypage/out.jsp";
		String Idcheck = (String)session.getAttribute("loginUser");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.getMember(Idcheck);
		request.setAttribute("userid", mVo.getUserid());
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(url);
		dispatcher.forward(request, response);
    	
    	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url = "mypage/out.jsp";	
    	String userid = request.getParameter("userid");
    	String rawpwd = request.getParameter("pwd");
    	String pwd = SHA256.encodeSha256(rawpwd);     	
    	
		MemberDAO mDao = MemberDAO.getInstance();
		
		boolean result = mDao.deleteMember(userid, pwd);
		
		if (result == true) { 
			HttpSession session = request.getSession();
		    session.invalidate();
		    url ="/Main.jsp";		    
		    response.sendRedirect(request.getContextPath() + url); // Main_In.jsp 페이지로 리다이렉트
		} else {
		    // 로그인 실패한 경우
		    request.setAttribute("message", "아이	디 또는 비밀번호가 올바르지 않습니다.");
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
		}
	}
}