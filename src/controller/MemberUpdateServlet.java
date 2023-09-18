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


/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String Idcheck = (String)session.getAttribute("loginUser");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.getMember(Idcheck);
		request.setAttribute("userid", mVo.getUserid());
		request.setAttribute("name", mVo.getName());
		request.setAttribute("phone", mVo.getPhone());		
		request.setAttribute("email", mVo.getEmail());		
		request.setAttribute("add1", mVo.getAdd1());		
		request.setAttribute("add2", mVo.getAdd2());		
		request.setAttribute("add3", mVo.getAdd3());		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("mypage/sujung.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐을 방지
		// 폼에서 입력한 회원 정보 얻어오기
		String userid = request.getParameter("userid");		
		String rawpwd = request.getParameter("pwd");
		String pwd = SHA256.encodeSha256(rawpwd);
		String name = request.getParameter("name");		
		String email = request.getParameter("email");		
		String phone = request.getParameter("phone");	
		String add1 = request.getParameter("add1");	
		String add2 = request.getParameter("add2");	
		String add3 = request.getParameter("add3");	
		
		// 회원 정보를 저장할 객체 생성
		MemberVO mVo = new MemberVO();
		mVo.setUserid(userid);		
		mVo.setPwd(pwd);
		mVo.setName(name);
		mVo.setEmail(email);
		mVo.setPhone(phone);		
		mVo.setAdd1(add1);		
		mVo.setAdd2(add2);		
		mVo.setAdd3(add3);		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMember(mVo);
		response.sendRedirect("login.do");
	}

}