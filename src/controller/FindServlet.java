package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/find.do")
public class FindServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
           // GET 요청을 처리하는 부분입니다.
           // find.jsp로의 포워딩 또는 다른 작업을 수행할 수 있습니다.
           request.getRequestDispatcher("Login_join/find.jsp").forward(request, response);
       }

       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("UTF-8");
           response.setContentType("text/html; charset=UTF-8");
           PrintWriter out = response.getWriter();

           String name = request.getParameter("name");
           String phone = request.getParameter("phone");

           MemberDAO dao = MemberDAO.getInstance();
           String userID = dao.findID(name, phone); // 아이디를 찾는 메서드

           if (userID != null) {
               String message = name + "님의 아이디는 " + userID + "입니다.";
               request.setAttribute("message", message);
               out.println("<script>alert('" + message + "'); location.href='" + request.getContextPath() + "/login.do';</script>");
           } else {
              out.println("<script>alert('아이디가 존재하지 않습니다.'); location.href='" + request.getContextPath() + "/find.do';</script>");

           }

           // PrintWriter 닫기
           out.close();
       }

}