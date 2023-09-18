package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.QnaVO;
import util.DBManager;

public class QnaDAO {
	private QnaDAO() {
	 }
	private static QnaDAO instance = new QnaDAO();
	 public static QnaDAO getInstance() {
		 return instance;
		 }
	 public ArrayList<QnaVO> listQna(String userid) {
		 ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		 String sql = "select * from qna where user_Id=? order by qna_Seq desc";
		 
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 try {
		 conn = DBManager.getConnection(); 
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, userid); 
		 rs = pstmt.executeQuery();
		 while (rs.next()) {
		 QnaVO qnaVO = new QnaVO();
		 qnaVO.setQna_Seq(rs.getInt("qna_Seq"));
		 qnaVO.setQna_Title(rs.getString("qna_Title"));
		 qnaVO.setQna_Content(rs.getString("qna_Content"));
		 qnaVO.setUser_Id(rs.getString("user_Id"));
		 qnaVO.setQna_Date(rs.getTimestamp("qna_Date")); 
		 qnaVO.setQna_Reply(rs.getString("qna_Reply"));
		 qnaVO.setQna_Rep(rs.getString("qna_Rep")); 
		 qnaList.add(qnaVO);
		 System.out.println("QNALIST");
		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 return qnaList;
		 }
	 
	 
	 
		 public QnaVO getQna(int seq) {
		 QnaVO qnaVO = null;
		 String sql = "select * from qna where qna_Seq=?";
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 try {
		 conn = DBManager.getConnection();
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setInt(1, seq);
		 rs = pstmt.executeQuery();
		 if (rs.next()) {
		 qnaVO = new QnaVO();
		 qnaVO.setQna_Seq(seq);
		 qnaVO.setQna_Title(rs.getString("qna_Title"));
		 qnaVO.setQna_Content(rs.getString("qna_Content"));
		 qnaVO.setUser_Id(rs.getString("user_Id"));
		 qnaVO.setQna_Date(rs.getTimestamp("qna_Date"));
		 qnaVO.setQna_Reply(rs.getString("qna_Reply"));
		 qnaVO.setQna_Rep(rs.getString("qna_Rep")); 
		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 } finally {
		 DBManager.close(conn, pstmt);
		 }
		 return qnaVO;
		 }
		 
		 //qna 추가
		 public void insertqna(QnaVO qnaVO, String user_Id){
		 String sql = "insert into qna (qna_Seq, qna_Title, " +
		 "qna_Content, user_Id) values(qna_seq.nextval, ?, ?, ?)"; 
		 
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 try {
		 conn = DBManager.getConnection();
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, qnaVO.getQna_Title());
		 pstmt.setString(2, qnaVO.getQna_Content());
		 pstmt.setString(3, user_Id);
		 pstmt.executeUpdate();
		 } catch (Exception e) {
		 e.printStackTrace();
		 } finally {
		 DBManager.close(conn, pstmt);
		 } 
		 }
		 
		 public ArrayList<QnaVO> listAllQna(int pageNum, int amount) {//관리자 qnaList
				ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
				// 게시판의 데이터를 가지고 오는 쿼리 rep:1:게시물 2: 답변
				String sql = "select * "
						+ 	 "from (select rownum rn,"
						+ 				   " a.* "
						+ 			"from (select *"
						+ 				 " from qna order by qna_seq desc) a ) "
						+ 	 "where rn > ? and rn <= ?";	
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, (pageNum - 1) * amount);
					pstmt.setInt(2, pageNum * amount);						
					rs = pstmt.executeQuery();
					while (rs.next()) {
						QnaVO qnaVO = new QnaVO();
						qnaVO.setQna_Seq(rs.getInt("qna_Seq"));
						qnaVO.setQna_Title(rs.getString("qna_Title"));
						qnaVO.setQna_Content(rs.getString("qna_Content"));
						qnaVO.setUser_Id(rs.getString("user_Id"));
						qnaVO.setQna_Date(rs.getTimestamp("qna_Date"));
						qnaVO.setQna_Reply(rs.getString("qna_Reply"));
						qnaVO.setQna_Rep(rs.getString("qna_Rep"));
						qnaList.add(qnaVO);
					   }			
					} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}
				return qnaList;
			}
//			public List<QnaVO> listQna(int pageNum, int amount){		
//			List<QnaVO> list = new ArrayList<>();		
//			String sql = "select * "
//					+ 	 "from (select rownum rn,"
//					+ 				   " a.* "
//					+ 			"from (select *"
//					+ 				 " from qna order by qna_seq desc) a ) "
//					+ 	 "where rn > ? and rn <= ?";		
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//		try {
//			conn = DBManager.getConnection(); // 연결			
//			pstmt = conn.prepareStatement(sql); // sql준비
//			 
//			pstmt.setInt(1, (pageNum - 1) * amount);
//			pstmt.setInt(2, pageNum * amount);	
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				// 한바퀴 회전당 VO를 하나씩 생성
//				QnaVO nVo = new QnaVO();			
//				nVo.setQna_Seq(rs.getInt("Qna_Seq"));
//				nVo.setQna_Title(rs.getString("Qna_Title"));
//				nVo.setQna_Content(rs.getString("Qna_Content"));			
//				nVo.setQna_Reply(rs.getString("Qna_Reply"));			
//				nVo.setUser_Id(rs.getString("User_Id"));
//				nVo.setQna_Rep(rs.getString("Qna_Rep"));
//				nVo.setQna_Date(rs.getTimestamp("Qna_Date"));							
//				list.add(nVo);
//			}			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}		
//		return list;
//		}  
	//	

		 
		 
		 
		 
		 

			public void updateQna(QnaVO qnaVO) {
				String sql = "update qna set qna_Reply=?, qna_Rep='2' where qna_Seq=?";
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, qnaVO.getQna_Reply());
					pstmt.setInt(2, qnaVO. getQna_Seq());
					pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt);
				}
			}
	//페이징		
	public List<QnaVO> getListQ(int pageNum, int amount, String user_Id){		
			List<QnaVO> list = new ArrayList<>();		
			String sql = "select * "
					+ 	 "from (select rownum rn,"
					+ 				   " a.* "
					+ 			"from (select *"
					+ 				 " from qna order by qna_seq desc) a ) "
					+ 	 "where rn > ? and rn <= ? and user_ID = ?";		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		try {
			conn = DBManager.getConnection(); // 연결			
			pstmt = conn.prepareStatement(sql); // sql준비
			 
			pstmt.setInt(1, (pageNum - 1) * amount);
			pstmt.setInt(2, pageNum * amount);	
			pstmt.setString(3, user_Id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// 한바퀴 회전당 VO를 하나씩 생성
				QnaVO nVo = new QnaVO();			
				nVo.setQna_Seq(rs.getInt("Qna_Seq"));
				nVo.setQna_Title(rs.getString("Qna_Title"));
				nVo.setQna_Content(rs.getString("Qna_Content"));			
				nVo.setQna_Reply(rs.getString("Qna_Reply"));			
				nVo.setUser_Id(rs.getString("User_Id"));
				nVo.setQna_Rep(rs.getString("Qna_Rep"));
				nVo.setQna_Date(rs.getTimestamp("Qna_Date"));							
				list.add(nVo);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return list;
		}    
	
	public ArrayList<QnaVO> getlist(String user_Id) {
	    ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
	    String sql = "SELECT * FROM ("
	            + "  SELECT q.*, ROWNUM AS rn "
	            + "  FROM ("
	            + "    SELECT *"
	            + "    FROM qna"
	            + "    WHERE user_Id = ?"
	            + "    ORDER BY qna_Seq DESC"
	            + "  ) q"
	            + ") WHERE rn <= 5 ORDER BY qna_Seq DESC";	

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        conn = DBManager.getConnection(); 
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, user_Id); 
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            QnaVO qnaVO = new QnaVO();
	            qnaVO.setQna_Seq(rs.getInt("qna_Seq"));
	            qnaVO.setQna_Title(rs.getString("qna_Title"));
	            qnaVO.setQna_Content(rs.getString("qna_Content"));
	            qnaVO.setUser_Id(rs.getString("user_Id"));
	            qnaVO.setQna_Date(rs.getTimestamp("qna_Date")); 
	            qnaVO.setQna_Reply(rs.getString("qna_Reply"));
	            qnaVO.setQna_Rep(rs.getString("qna_Rep")); 
	            qnaList.add(qnaVO);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return qnaList;
	}
	public int getTotals(String user_Id) {
		int result = 0;	
		String sql = "select count(*) as total from QNA where User_id=? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		conn = DBManager.getConnection();		
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, user_Id); 
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				result = rs.getInt("total");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
    	return result;
	}

	public int getTotal() {
		int result = 0;	
		String sql = "select count(*) as total from QNA";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		conn = DBManager.getConnection();		
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();			
			if(rs.next()) {
				result = rs.getInt("total");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
    	return result;
	}
	 public ArrayList<QnaVO> AlistQna(String userid) {
		 ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		 String sql = "SELECT *"
		 		       + "FROM ("
		 		   + "     SELECT *  FROM qna"
		 		   + "       WHERE user_Id = ?"
		 		   + "       ORDER BY qna_Seq desc"
		 		   + ") WHERE rownum <= 5 ";
		 
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 try {
		 conn = DBManager.getConnection(); 
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, userid); 
		 rs = pstmt.executeQuery();
		 while (rs.next()) {
		 QnaVO qnaVO = new QnaVO();
		 qnaVO.setQna_Seq(rs.getInt("qna_Seq"));
		 qnaVO.setQna_Title(rs.getString("qna_Title"));
		 qnaVO.setQna_Content(rs.getString("qna_Content"));
		 qnaVO.setUser_Id(rs.getString("user_Id"));
		 qnaVO.setQna_Date(rs.getTimestamp("qna_Date")); 
		 qnaVO.setQna_Reply(rs.getString("qna_Reply"));
		 qnaVO.setQna_Rep(rs.getString("qna_Rep")); 
		 qnaList.add(qnaVO);
		 System.out.println("QNALIST");
		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 return qnaList;
		 }
	
	 public void updateRepQna(QnaVO qVo) {
			String sql = "update qna set Qna_Reply=? where qna_seq=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, qVo.getQna_Reply());
				pstmt.setInt(2, qVo.getQna_Seq());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}


		public void deleteQna(String qna_Seq) {
			String sql = "delete qna where qna_seq=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			System.out.println(sql);
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,qna_Seq);
				System.out.println(qna_Seq);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		
		public QnaVO getQnare(int qna_Seq) {
			QnaVO qnaVO = null;
			 String sql = "select * from qna where qna_Seq=?";
			 Connection conn = null;
			 PreparedStatement pstmt = null;
			 ResultSet rs = null;
			 try {
			 conn = DBManager.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, qna_Seq);
			 rs = pstmt.executeQuery();
			 if (rs.next()) {
			 qnaVO = new QnaVO();
			 qnaVO.setQna_Seq(qna_Seq);
			 qnaVO.setQna_Title(rs.getString("qna_Title"));
			 qnaVO.setQna_Content(rs.getString("qna_Content"));
			 qnaVO.setUser_Id(rs.getString("user_Id"));
			 qnaVO.setQna_Date(rs.getTimestamp("qna_Date"));
			 qnaVO.setQna_Reply(rs.getString("qna_Reply"));
			 qnaVO.setQna_Rep(rs.getString("qna_Rep")); 
			 }
			 } catch (Exception e) {
			 e.printStackTrace();
			 } finally {
			 DBManager.close(conn, pstmt);
			 }
			 return qnaVO;
			 }
			 
}
