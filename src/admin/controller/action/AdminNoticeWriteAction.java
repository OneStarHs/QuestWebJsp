package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.action.Action;
import dao.NoticeDAO;
import dto.NoticeVO;

public class AdminNoticeWriteAction implements Action {

	//private static final String path = "/uploads"; // 파일이 업로드될 디렉토리 경로
//	private static final long MAX_FILE_SIZE = 1024 * 1024; // 1MB (최대 파일 크기)
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		// ServletContext context = getServletContext();
		 String path =  request.getServletContext().getRealPath("uploads");
		 String encType = "UTF-8";
		 int sizeLimit = 20*1027*1024;
		   MultipartRequest multi = new MultipartRequest(
				                    request, 
				                    path, 
				                    sizeLimit, 
				                    encType, 
				                    new DefaultFileRenamePolicy());

		   String user_Name = multi.getParameter("user_Name");
		   String notice_Type = multi.getParameter("notice_Type");
		   String notice_Title = multi.getParameter("notice_Title");
		   String notice_Content = multi.getParameter("notice_Content");
		   String notice_img = multi.getFilesystemName("notice_img");
		   
		   
		   
		   
		NoticeVO nVo = new NoticeVO();
		nVo.setUser_Name(user_Name);
	//	nVo.setNotice_Pw(request.getParameter("notice_Pw"));
		nVo.setNotice_Type(notice_Type);
		nVo.setNotice_Title(notice_Title);
		nVo.setNotice_Content(notice_Content);
		nVo.setNotice_img(notice_img);
		  // 파일 업로드 처리
       // Part filePart = request.getPart("notice_img");
       // long fileSize = filePart.getSize();
//
//        if (fileSize > MAX_FILE_SIZE) {
//            // 파일 업로드 크기가 최대 크기를 초과한 경우에 대한 처리
//            // 예를 들어 오류 메시지를 보여줄 수 있습니다.
//            return; // 더 이상 진행하지 않고 메서드를 종료
//        }
//        
//        
//        
//        String fileName = getFileName(filePart);
//
//        // 파일 저장 경로 생성
//        String filePath = UPLOAD_DIRECTORY + File.separator + fileName;
//
//        // 파일 저장
//        filePart.write(filePath);
//        nVo.setNotice_img(filePath);

        NoticeDAO nDao = NoticeDAO.getInstance();
        nDao.insertNotice(nVo);
        response.sendRedirect("NoticeServlet?command=admin_notice_list");
    }

//    private String getFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        String[] tokens = contentDisp.split(";");
//        for (String token : tokens) {
//            if (token.trim().startsWith("filename")) {
//                return token.substring(token.indexOf("=") + 2, token.length() - 1);
//            }
//        }
//        return "";
//    }
}