package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.acceptedDAO;
import dto.acceptedVO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
 

        



@WebServlet("/accepted.do")
public class acceptedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	
		    String userIdcheck = (String)session.getAttribute("loginUser");
		    //접근허용 (로그인상태)
		    if (userIdcheck != null) {
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("Internet_accepted/accepted.jsp");
		        dispatcher.forward(request, response);
		    } else {
		        response.sendRedirect("login.do"); // 로그인 페이지로 리다이렉트
		    }
		}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    HttpSession session = request.getSession(); 
    
        String userIdcheck =String.valueOf(session.getAttribute("loginUser"));
        //String userpwdcheck = (String) session.getAttribute("loginPwd");
     if (userIdcheck != null) {
          System.out.println("로그인된 사용자의 ID  : " + userIdcheck);
          //System.out.println("로그인된 사용자의 PW : " + userpwdcheck);
       }
     LocalDate now = LocalDate.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
     String formatedNow = now.format(formatter);
     
     String tracking = "1";
	//	String userid = request.getParameter("User_ID");
       String userid = userIdcheck;
		String depName = request.getParameter("Dep_Name");
		String depPN = request.getParameter("Dep_PN");
		String depAdd1 = request.getParameter("Dep_Add1");
		String depAdd2 = request.getParameter("Dep_Add2");
		String depAdd3 =request.getParameter("Dep_Add3");
		String arrName = request.getParameter("Arr_Name");
		String arrPN = request.getParameter("Arr_PN");
		String arrAdd1 = request.getParameter("Arr_Add1");
		String arrAdd2 = request.getParameter("Arr_Add2");
		String arrAdd3 = request.getParameter("Arr_Add3");
		int usermoney = Integer.parseInt(request.getParameter("User_Money"));
		String usership = request.getParameter("User_Ship");
		String date = formatedNow;
		
		switch (usership) {
		case "1":
			usership = "대중교통";
			break;
	case "2":
		usership = "오토바이";
			break;
	case "3":
		usership = "라보";
		break;

		default:
			usership = "대중교통";
			break;
		}
		String usershipT = "사용안함";
		if (request.getParameter("User_ShipT") == null || request.getParameter("User_ShipT").isEmpty() || request.getParameter("User_ShipT").equals("0")) {
			usershipT = "사용안함";
		}else {
		usershipT ="왕복사용";
		}
		
		String usershipQ  =  "사용안함";
		if (request.getParameter("User_ShipQ") == null || request.getParameter("User_ShipQ").isEmpty() || request.getParameter("User_ShipQ").equals("0")) {
			usershipQ = "사용안함";
		}else {
			usershipQ ="급송사용";
		}
		String usertext = request.getParameter("User_Text");;
		if (request.getParameter("User_Text") == null || request.getParameter("User_Text").isEmpty()) {
			usertext = "특이사항없음";
		}
		
		String userpayS = "카드결제";
		switch (request.getParameter("User_PayS")) {
		case "0":
			userpayS = "카드결제";
			break;

		case "1":
			userpayS = "계좌이체";
			break;
		case "2":
			userpayS = "선불";
			break;
		case "3":
			userpayS = "착불";
			break;
		}
		
		acceptedVO aVo = new acceptedVO();
		aVo.setUser_ID(userid);
		aVo.setDep_Name(depName);
		aVo.setDep_PN(depPN);
		aVo.setDep_Add1(depAdd1);
		aVo.setDep_Add2(depAdd2);
		aVo.setDep_Add3(depAdd3);
		aVo.setArr_Name(arrName);
		aVo.setArr_PN(arrPN);
		aVo.setArr_Add1(arrAdd1);
		aVo.setArr_Add2(arrAdd2);
		aVo.setArr_Add3(arrAdd3);
        aVo.setUser_Money(usermoney);
        aVo.setUser_Ship(usership);
        aVo.setUser_ShipT(usershipT);
        aVo.setUser_ShipQ(usershipQ);
        aVo.setUser_Text(usertext);
        aVo.setUser_PayS(userpayS);
        aVo.setUser_Date(date);
        aVo.setTracking(tracking);
		
        String paymentStatus = request.getParameter("paymentStatus");
        acceptedDAO aDao = acceptedDAO.getInstance();
		int result = aDao.insertMember(aVo);
        if ("completed".equals(paymentStatus)) {        	
    		if (result == 1) {    			
    		System.out.println("성공");
            request.setAttribute("message", "인터넷 접수 및 결제가 완료되었습니다.");
            System.out.println("결제 완료");
        }    		
    } 
        RequestDispatcher dispatcher = request.getRequestDispatcher("mypage.do");
        dispatcher.forward(request, response);
        
	}

}