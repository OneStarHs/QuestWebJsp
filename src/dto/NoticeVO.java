package dto;

import java.sql.Timestamp;

public class NoticeVO {
	private Integer Notice_num;
	private String User_Name;
	//private String Notice_Pw;
	private String Notice_Type;
	private String Notice_Title;
	private String Notice_Content;
	private String Notice_img;
	private Timestamp Notice_Date;
	public Integer getNotice_num() {
		return Notice_num;
	}
	public void setNotice_num(Integer notice_num) {
		Notice_num = notice_num;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
//	public String getNotice_Pw() {
//		return Notice_Pw;
//	}
//	public void setNotice_Pw(String notice_Pw) {
//		Notice_Pw = notice_Pw;
//	}
	public String getNotice_Type() {
		return Notice_Type;
	}
	public void setNotice_Type(String notice_Type) {
		Notice_Type = notice_Type;
	}
	public String getNotice_Title() {
		return Notice_Title;
	}
	public void setNotice_Title(String notice_Title) {
		Notice_Title = notice_Title;
	}
	public String getNotice_Content() {
		return Notice_Content;
	}
	public void setNotice_Content(String notice_Content) {
		Notice_Content = notice_Content;
	}
	public String getNotice_img() {
		return Notice_img;
	}
	public void setNotice_img(String notice_img) {
		Notice_img = notice_img;
	}
	public Timestamp getNotice_Date() {
		return Notice_Date;
	}
	public void setNotice_Date(Timestamp notice_Date) {
		Notice_Date = notice_Date;
	}
	
	
}
