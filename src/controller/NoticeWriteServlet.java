package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.NoticeDAO;
import dto.NoticeVO;

@WebServlet("/noticeWrite.do")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/notice/noticeWrite.jsp");
	       dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		   ServletContext context = getServletContext();
		   String path = context.getRealPath("uploads");
		   String encType = "UTF-8";
		   int sizeLimit = 20*1027*1024;
		   MultipartRequest multi = new MultipartRequest(
				                    request, 
				                    path, 
				                    sizeLimit, 
				                    encType, 
				                    new DefaultFileRenamePolicy());
			System.out.println("서버상의 실제 디렉토리 : ");		
			System.out.println(path);	
	     // String user_Name = multi.getParameter("user_Name");
	     // String notice_Pw = multi.getParameter("notice_Pw");
	      String notice_Type = multi.getParameter("notice_Type");
	      String notice_Title = multi.getParameter("notice_Title");
	      String notice_Content = multi.getParameter("notice_Content");
		  String notice_img = multi.getFilesystemName("notice_img");
		
		  NoticeVO nVo = new NoticeVO();
		  //nVo.setUser_Name(user_Name);
		//  nVo.setNotice_Pw(notice_Pw);
		  nVo.setNotice_Type(notice_Type);
		  nVo.setNotice_Title(notice_Title);
		  nVo.setNotice_Content(notice_Content);
		  nVo.setNotice_img(notice_img);
		 
		  NoticeDAO nDao =  NoticeDAO.getInstance();
		  nDao.insertNotice(nVo);
		
		   response.sendRedirect("NoticeServlet?command=admin_notice_list");
	}

}
