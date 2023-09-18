package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload2.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		
		//여기를 바꿔주면 다운받는 경로가 바뀜
		String savePath = "upload";//저장위치
		//최대 업로드 파일 크기 5MB로 제한
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "UTF-8";		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("서버상의 실제 디렉토리 : ");		
		System.out.println(uploadFilePath);		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, //request객체
					uploadFilePath, //서버상의 실제디렉토리
					uploadFileSizeLimit, //최대업로드 파일크기
					encType,//인코딩방법 //순서 중요
					new DefaultFileRenamePolicy());		//동일이름 존재시 새로운 이름 부여
			Enumeration files = multi.getFileNames();//업로드된 파일의 이름얻기
			while(files.hasMoreElements()) {
				String file =(String)files.nextElement();
				String file_name = multi.getFilesystemName(file);
				String ori_file_name = multi.getOriginalFileName(file);//중복된 파일 업로드하면 이름 바뀜
				out.println("<br> 업로드된 파일명 : "+ file_name);
				out.println("<br> 원본 파일명 : "+ ori_file_name);
				out.println("<hr>");
			}
			
		} catch (IOException e) {
			System.out.print("예외발생 : " + e);
		}//catch
	}

}
