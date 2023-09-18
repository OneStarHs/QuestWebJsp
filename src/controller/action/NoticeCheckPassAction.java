//package controller.action;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.NoticeDAO;
//import dto.NoticeVO;
//
//
//
//public class NoticeCheckPassAction implements Action {
//
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String url = null;
//		
//		String notice_num = request.getParameter("notice_num");
//		String notice_Pw = request.getParameter("notice_Pw");
//		
//		NoticeDAO nDao = NoticeDAO.getInstance();
//		NoticeVO nVo = nDao.selectOneNoticeByNum(notice_num);
//		
//		if(nVo.getNotice_Pw().equals(notice_Pw)) {
//			url = "/notice/checkSuccess.jsp";
//		}else {
//			url = "/notice/noticeCheckPass.jsp";
//			request.setAttribute("message", "비밀번호가 틀렸습니다.");
//		}
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		dispatcher.forward(request, response);
//
//	}
//
//}
