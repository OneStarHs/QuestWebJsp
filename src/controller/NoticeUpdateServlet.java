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

@WebServlet("/noticeUpdate.do")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String notice_num = request.getParameter("notice_num");
		NoticeDAO nDao = NoticeDAO.getInstance();
		NoticeVO nVo= nDao.selectOneNoticeByNum(notice_num);
	    request.setAttribute("notice", nVo);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("notice/noticeUpdate.jsp");
	    dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		   ServletContext context = getServletContext();
		   String path = context.getRealPath("upload");
		   String encType = "UTF-8";
		   int sizeLimit = 20*1027*1024;
		  
		   MultipartRequest multi = new MultipartRequest(
				                    request, 
				                    path, 
				                    sizeLimit, 
				                    encType, 
				                    new DefaultFileRenamePolicy());
		
		      String notice_num = multi.getParameter("notice_num");
		      String user_Name = multi.getParameter("user_Name");
		      //String notice_Pw = multi.getParameter("notice_Pw");
		      String notice_Type = multi.getParameter("notice_Type");
		      String notice_Title = multi.getParameter("notice_Title");
		      String notice_Content = multi.getParameter("notice_Content");
			  String notice_img = multi.getFilesystemName("notice_img");
		   
		   
		   if(notice_img == null) {
			   notice_img=multi.getParameter("nonmakeImg"); 
		   }
		   NoticeVO nVo = new NoticeVO();
		   nVo.setNotice_num(Integer.parseInt(notice_num));
		   nVo.setUser_Name(user_Name);
		   //nVo.setNotice_Pw(notice_Pw);
		   nVo.setNotice_Type(notice_Type);
		   nVo.setNotice_Title(notice_Title);
		   nVo.setNotice_Content(notice_Content);
	 	  nVo.setNotice_img(notice_img);
		 
	 	 NoticeDAO nDao = NoticeDAO.getInstance();
		   nDao.updateNotice(nVo);
		   		
		   response.sendRedirect("noticeList.do");
	  
	}
	}