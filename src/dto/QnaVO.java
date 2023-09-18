package dto;

import java.sql.Timestamp;

public class QnaVO {
	 private int Qna_Seq; 
	 private String Qna_Title; 
	 private String Qna_Content;
	 private String Qna_Reply;
	 private String User_Id; 
	 private String Qna_Rep ; 
	 private Timestamp Qna_Date;
	 
	 
	 public int getQna_Seq() {
		return Qna_Seq;
	}
	public void setQna_Seq(int qna_Seq) {
		Qna_Seq = qna_Seq;
	}
	public String getQna_Title() {
		return Qna_Title;
	}
	public void setQna_Title(String qna_Title) {
		Qna_Title = qna_Title;
	}
	public String getQna_Content() {
		return Qna_Content;
	}
	public void setQna_Content(String qna_Content) {
		Qna_Content = qna_Content;
	}
	public String getQna_Reply() {
		return Qna_Reply;
	}
	public void setQna_Reply(String qna_Reply) {
		Qna_Reply = qna_Reply;
	}
	public String getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}
	public String getQna_Rep() {
		return Qna_Rep;
	}
	public void setQna_Rep(String qna_Rep) {
		Qna_Rep = qna_Rep;
	}
	public Timestamp getQna_Date() {
		return Qna_Date;
	}
	public void setQna_Date(Timestamp qna_Date) {
		Qna_Date = qna_Date;
	}
	
}
