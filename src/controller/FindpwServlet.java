package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/findpw.do")
public class FindpwServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Login_join/findpw.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String userid = request.getParameter("userid");
        String phone = request.getParameter("phone");
        MemberDAO dao = MemberDAO.getInstance();
        String userPw = dao.findpw(name, userid, phone); // 아이디를 찾는 메서드
        if (userPw != null) {
            // 회원정보가 존재하는 경우, 비밀번호 변경 페이지로 이동
            request.getSession().setAttribute("USERID", userid);
            response.sendRedirect("PWCH.do"); // PWCHServlet으로 이동
        } else {
            // 회원정보가 존재하지 않는 경우, 오류 메시지를 전달하고 다시 비밀번호 찾기 페이지로 이동
            String message = "회원정보가 존재하지 않습니다.";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/Login_join/findpw.jsp").forward(request, response);
        }

        // PrintWriter 닫기
        out.close();
    }
}

