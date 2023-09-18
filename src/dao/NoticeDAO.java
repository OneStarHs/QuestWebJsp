package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.NoticeVO;
import util.DBManager;

public class NoticeDAO {
	private NoticeDAO() {
	}

	private static NoticeDAO instance = new NoticeDAO();

	public static NoticeDAO getInstance() {
		return instance;
	}

	// C Read UD
	public List<NoticeVO> selectAllNotices() {

		String sql = "select * from notice order by CASE WHEN notice_type = 1 THEN 0 ELSE 1 END,  Notice_num desc";
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				NoticeVO nVo = new NoticeVO();
				nVo.setNotice_num(rs.getInt("Notice_num"));
				nVo.setUser_Name(rs.getString("User_Name"));
				//nVo.setNotice_Pw(rs.getString("Notice_Pw"));
				nVo.setNotice_Type(rs.getString("Notice_type"));
				nVo.setNotice_Title(rs.getString("Notice_Title"));
				nVo.setNotice_Content(rs.getString("Notice_Content"));
				nVo.setNotice_img(rs.getString("Notice_img"));
				nVo.setNotice_Date(rs.getTimestamp("Notice_Date"));

				list.add(nVo);
			}
			System.out.println("글정보 저장 완료!(list)");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	// 페이징
	public List<NoticeVO> getList(int pageNum, int amount) {
		List<NoticeVO> list = new ArrayList<>();
		String sql = "select * " + "from (select rownum rn," + " a.* " + "from (select *"
				+ " from notice order by CASE WHEN notice_type = 1 THEN 0 ELSE 1 END, notice_num desc) a ) "
				+ "where rn > ? and rn <= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection(); // 연결
			pstmt = conn.prepareStatement(sql); // sql준비
			pstmt.setInt(1, (pageNum - 1) * amount);
			pstmt.setInt(2, pageNum * amount);
			rs = pstmt.executeQuery(); // sql문 실행
			while (rs.next()) {
				// 한바퀴 회전당 VO를 하나씩 생성
				NoticeVO nVo = new NoticeVO();
				nVo.setNotice_num(rs.getInt("Notice_num"));
				nVo.setUser_Name(rs.getString("User_Name"));
				//nVo.setNotice_Pw(rs.getString("Notice_Pw"));
				nVo.setNotice_Type(rs.getString("Notice_type"));
				nVo.setNotice_Title(rs.getString("Notice_Title"));
				nVo.setNotice_Content(rs.getString("Notice_Content"));
				nVo.setNotice_img(rs.getString("Notice_img"));
				nVo.setNotice_Date(rs.getTimestamp("Notice_Date"));
				list.add(nVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public int getTotal() {
		int result = 0;
		String sql = "select count(*) as total from notice";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 페이징

	public void insertNotice(NoticeVO nVo) {
		String sql = "insert into notice("
				+ "Notice_num, Notice_Type, Notice_Title, Notice_Content, Notice_img) "
				+ "values(Notice_seq.nextval, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nVo.getNotice_Type());
			//pstmt.setString(2, nVo.getNotice_Pw());
			pstmt.setString(2, nVo.getNotice_Title());
			pstmt.setString(3, nVo.getNotice_Content());
			pstmt.setString(4, nVo.getNotice_img());

			pstmt.executeUpdate();
			System.out.println("글정보 저장 완료!(insert)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
			System.out.println(sql);
		}
	}

	// 게시판글 상세보기
	public NoticeVO selectOneNoticeByNum(String notice_num) {
		String sql = "select * from notice where notice_num = ?";
		NoticeVO nVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice_num);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				nVo = new NoticeVO();

				nVo.setNotice_num(rs.getInt("Notice_num"));
				nVo.setUser_Name(rs.getString("User_Name"));
				//nVo.setNotice_Pw(rs.getString("Notice_Pw"));
				nVo.setNotice_Title(rs.getString("Notice_Title"));
				nVo.setNotice_Content(rs.getString("Notice_Content"));
				nVo.setNotice_img(rs.getString("Notice_img"));
				nVo.setNotice_Date(rs.getTimestamp("Notice_Date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
			System.out.println(sql);
		}
		return nVo;
	}

	public void updateNotice(NoticeVO nVo) {
		String sql = "update notice set Notice_Type=?, Notice_Title=?, Notice_Content=?, "// 공백중요
				+ "Notice_img=? where Notice_num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nVo.getNotice_Type());
		//	pstmt.setString(3, nVo.getNotice_Pw());
			pstmt.setString(2, nVo.getNotice_Title());
			pstmt.setString(3, nVo.getNotice_Content());
			pstmt.setString(4, nVo.getNotice_img());
			pstmt.setInt(5, nVo.getNotice_num());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

//	public NoticeVO checkPassword(String notice_Pw, String notice_num) {
//		String sql = "select * from notice where notice_Pw = ? and notice_num = ?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		NoticeVO nVo = null;
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, notice_Pw);
//			pstmt.setString(2, notice_num);
//
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				nVo = new NoticeVO();
//
//				nVo.setNotice_num(rs.getInt("Notice_num"));
//				nVo.setUser_Name(rs.getString("User_Name"));
//				nVo.setNotice_Pw(rs.getString("Notice_Pw"));
//				nVo.setNotice_Title(rs.getString("Notice_Title"));
//				nVo.setNotice_Content(rs.getString("Notice_Content"));
//				nVo.setNotice_img(rs.getString("Notice_img"));
//				nVo.setNotice_Date(rs.getTimestamp("Notice_Date"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return nVo;
//	}

	public void deleteNotice(String Notice_num) {
		String sql = "delete notice where Notice_num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Notice_num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public List<NoticeVO> searchNotice(String noticetitle, int pageNum, int amount) {
		List<NoticeVO> list = new ArrayList<>();
		String sql = "SELECT *FROM ( SELECT rownum rn, a.*" + "    FROM ("
				+ "        SELECT * FROM notice WHERE notice_title LIKE ?"
				+ "        ORDER BY CASE WHEN notice_type = 1 THEN 0 ELSE 1 END, notice_num DESC )a)"
				+ "WHERE rn >? AND rn <=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection(); // 연결
			pstmt = conn.prepareStatement(sql); // sql준비
			pstmt.setString(1, "%" + noticetitle + "%");
			pstmt.setInt(2, (pageNum - 1) * amount);
			pstmt.setInt(3, pageNum * amount);
			rs = pstmt.executeQuery(); // sql문 실행
			
			while (rs.next()) {
				// 한바퀴 회전당 VO를 하나씩 생성
				NoticeVO nVo = new NoticeVO();
				nVo.setNotice_num(rs.getInt("Notice_num"));
				nVo.setUser_Name(rs.getString("User_Name"));
				//nVo.setNotice_Pw(rs.getString("Notice_Pw"));
				nVo.setNotice_Type(rs.getString("Notice_type"));
				nVo.setNotice_Title(rs.getString("Notice_Title"));
				nVo.setNotice_Content(rs.getString("Notice_Content"));
				nVo.setNotice_img(rs.getString("Notice_img"));
				nVo.setNotice_Date(rs.getTimestamp("Notice_Date"));
				list.add(nVo);
				System.out.println(nVo);
				System.out.println(nVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

}