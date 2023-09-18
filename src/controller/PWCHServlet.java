package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import util.SHA256;

@WebServlet("/PWCH.do")
public class PWCHServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Login_join/PWCH.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userid = (String) request.getSession().getAttribute("USERID");
        String password = request.getParameter("pwd");
        
        String hashedPassword = SHA256.encodeSha256(password); // 비밀번호를 해싱

        MemberDAO dao = MemberDAO.getInstance();
        dao.updatePassword(userid, hashedPassword); // 해싱된 비밀번호를 데이터베이스에 저장

        // 비밀번호 변경 후 로그인 페이지로 이동
        response.sendRedirect("login.do");
    }
}
