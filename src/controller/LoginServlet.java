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
import util.SHA256;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "/Login_join/Login.jsp";
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") != null) {// 이미 로그인 된 사용자이면
			url = "/Main.jsp"; // 메인 페이지로 이동한다.
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/Login_join/Login.jsp";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String incodingPwd = SHA256.encodeSha256(pwd);
		System.out.println(incodingPwd);
		MemberDAO MDao = MemberDAO.getInstance();
		int result = MDao.userCheck(userid, incodingPwd);
		System.out.println("로그인전");
		if (result == 1) {
		    // 로그인 성공한 경우
		    HttpSession session = request.getSession();
		    session.setAttribute("loginUser", userid);
		    session.setAttribute("loginPwd", incodingPwd); // 로그인 정보를 세션에 저장
		    session.setAttribute("isLoggedIn", true); // 로그인 상태를 true로 설정
		    System.out.println("로그인들어옴");
		    session.getAttribute("loginUser");
		    // 성공한 경우의 처리를 진행합니다.
		    url ="/Main.jsp";
		    response.sendRedirect(request.getContextPath() + url); // Main_In.jsp 페이지로 리다이렉트
		} else {
		    // 로그인 실패한 경우
			 System.out.println("로그인실패");
		    request.setAttribute("message","아이디 또는 비밀번호가 올바르지 않습니다.");
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
		}



		}
	}