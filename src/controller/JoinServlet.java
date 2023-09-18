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

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login_join/Join.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String userid = request.getParameter("userid");
        String rawpwd = request.getParameter("pwd");
        String pwd = SHA256.encodeSha256(rawpwd);
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String add1 = request.getParameter("add1");
        String add2 = request.getParameter("add2");
        String add3 = request.getParameter("add3");
        MemberVO mVo = new MemberVO();
        mVo.setName(name);
        mVo.setUserid(userid);
        mVo.setPwd(pwd);
        mVo.setEmail(email);
        mVo.setPhone(phone);
        mVo.setAdd1(add1);
        mVo.setAdd2(add2);
        mVo.setAdd3(add3);

        MemberDAO mDao = MemberDAO.getInstance();
        int result = mDao.insertMember(mVo);
        HttpSession session = request.getSession();
        if (result == 1) {
            session.setAttribute("USERID", mVo.getUserid());
            request.setAttribute("message", "회원 가입에 성공했습니다.");
        } else {
            request.setAttribute("message", "회원 가입에 실패했습니다.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login_join/Login.jsp");
        dispatcher.forward(request, response);
    }
}

