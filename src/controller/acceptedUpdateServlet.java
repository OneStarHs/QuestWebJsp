package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.acceptedDAO;
import dto.PageVO;
import dto.acceptedVO;


@WebServlet("/acceptedUpdate.do")
public class acceptedUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String reg_Num = request.getParameter("reg_Num");
		
		
		acceptedDAO mDao = acceptedDAO.getInstance();
		acceptedVO mVo = mDao.getAccepted(reg_Num);				
		request.setAttribute("mVo", mVo);
		request.setAttribute("depName", mVo.getDep_Name());
		request.setAttribute("depPN", mVo.getDep_PN());
		request.setAttribute("depAdd1", mVo.getDep_Add1());
		request.setAttribute("depAdd2", mVo.getDep_Add2());
		request.setAttribute("depAdd3", mVo.getDep_Add3());
		
		request.setAttribute("arrName", mVo.getArr_Name());		
		request.setAttribute("arrPN", mVo.getArr_PN());
		request.setAttribute("arrAdd1", mVo.getArr_Add1());
		request.setAttribute("arrAdd2", mVo.getArr_Add2());
		request.setAttribute("arrAdd3", mVo.getArr_Add3());
		
		request.setAttribute("usermoney", mVo.getUser_Money());
		request.setAttribute("usership", mVo.getUser_Ship());		
		request.setAttribute("usershipT", mVo.getUser_ShipT());
		request.setAttribute("usershipQ", mVo.getUser_ShipQ());
		request.setAttribute("userText", mVo.getUser_Text());
		request.setAttribute("userPays", mVo.getUser_PayS());
		
		request.setAttribute("regNum", mVo.getReg_Num());
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("Internet_accepted/update.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    HttpSession session = request.getSession();	    
	    
	    
	    int regNum = Integer.parseInt(request.getParameter("Reg_Num"));
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
		
		acceptedVO aVo = new acceptedVO();	
		aVo.setReg_Num(regNum);
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
        
        
        acceptedDAO aDao = acceptedDAO.getInstance();
		int result = aDao.updateAccepted(aVo);
		if (result == 1) {			
			System.out.println("성공");
		} else {			
			System.out.println("실패");
		}		
        RequestDispatcher dispatcher = request.getRequestDispatcher("mypage.do");        
        dispatcher.forward(request, response);
		
	}

}
