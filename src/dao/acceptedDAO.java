package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.NoticeVO;
import dto.QnaVO;
import dto.acceptedVO;
import util.DBManager;


public class acceptedDAO {
	private acceptedDAO() {
	}

	private static acceptedDAO instance = new acceptedDAO();

	public static acceptedDAO getInstance() {
		return instance;
	}
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	public int insertMember(acceptedVO aVo) {
		int result = -1;
		String sql = "INSERT INTO INTERNETACCEPTED VALUES(?, Reg_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, aVo.getUser_ID());
			pstmt.setString(2, aVo.getDep_Name());
			pstmt.setString(3, aVo.getDep_PN());
			pstmt.setString(4, aVo.getDep_Add1());
			pstmt.setString(5, aVo.getDep_Add2());
			pstmt.setString(6, aVo.getDep_Add3());
			pstmt.setString(7, aVo.getArr_Name());
			pstmt.setString(8, aVo.getArr_PN());
			pstmt.setString(9, aVo.getArr_Add1());
			pstmt.setString(10, aVo.getArr_Add2());
			pstmt.setString(11, aVo.getArr_Add3());
			pstmt.setInt(12, aVo.getUser_Money());
			pstmt.setString(13, aVo.getUser_Ship());
			pstmt.setString(14, aVo.getUser_ShipT());
			pstmt.setString(15, aVo.getUser_ShipQ());
			pstmt.setString(16, aVo.getUser_Text());
			pstmt.setString(17, aVo.getUser_PayS());
			pstmt.setString(18, aVo.getUser_Date());
			pstmt.setString(19, aVo.getTracking());
			
			result = pstmt.executeUpdate();
			System.out.println("여긴 뭘까"+result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateAccepted(acceptedVO aVo) {
		int result = -1;
		String sql = "update INTERNETACCEPTED set Dep_Name=?, Dep_PN=?, Dep_Add1=?, Dep_Add2=?, Dep_Add3=?, Arr_Name=?, Arr_PN=?, Arr_Add1=?, Arr_Add2=?, Arr_Add3=?, User_Money=?, User_Ship=?, User_ShipT=?,  User_ShipQ=?, User_Text=? where reg_Num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, aVo.getDep_Name());
			pstmt.setString(2, aVo.getDep_PN());
			pstmt.setString(3, aVo.getDep_Add1());
			pstmt.setString(4, aVo.getDep_Add2());
			pstmt.setString(5, aVo.getDep_Add3());
			pstmt.setString(6, aVo.getArr_Name());
			pstmt.setString(7, aVo.getArr_PN());
			pstmt.setString(8, aVo.getArr_Add1());
			pstmt.setString(9, aVo.getArr_Add2());
			pstmt.setString(10, aVo.getArr_Add3());
			pstmt.setInt(11, aVo.getUser_Money());
			pstmt.setString(12, aVo.getUser_Ship());
			pstmt.setString(13, aVo.getUser_ShipT());
			pstmt.setString(14, aVo.getUser_ShipQ());
			pstmt.setString(15, aVo.getUser_Text());
			pstmt.setInt(16, aVo.getReg_Num());			
			
			result = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 아이디로 회원 정보 가져오는 메소드
		public acceptedVO getMember(String User_ID) {
			String sql = "select * from INTERNETACCEPTED where USER_ID=? ORDER BY reg_num DESC";
			acceptedVO mVo = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			System.out.println(User_ID+": getmember");
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, User_ID);
				rs = pstmt.executeQuery();			
				if (rs.next()) {
					mVo = new acceptedVO();
					mVo.setUser_ID(rs.getString("User_ID"));					
					mVo.setReg_Num(rs.getInt("Reg_Num"));
					mVo.setDep_Name(rs.getString("Dep_Name"));
					mVo.setDep_PN(rs.getString("Dep_PN"));
					mVo.setDep_Add1(rs.getString("Dep_Add1"));
					mVo.setDep_Add2(rs.getString("Dep_Add2"));
					mVo.setDep_Add3(rs.getString("Dep_Add3"));
					mVo.setArr_Name(rs.getString("Arr_Name"));
					mVo.setArr_PN(rs.getString("Arr_PN"));
					mVo.setArr_Add1(rs.getString("Arr_Add1"));
					mVo.setArr_Add2(rs.getString("Arr_Add2"));
					mVo.setArr_Add3(rs.getString("Arr_Add3"));
					mVo.setUser_Money(rs.getInt("User_Money"));
					mVo.setUser_Ship(rs.getString("User_Ship"));
					mVo.setUser_ShipT(rs.getString("User_ShipT"));
					mVo.setUser_ShipQ(rs.getString("User_ShipQ"));
					mVo.setUser_Text(rs.getString("User_Text"));
					mVo.setUser_PayS(rs.getString("User_PayS"));
					mVo.setUser_Date(rs.getString("User_Date"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return mVo;
		}
		
		
		public acceptedVO getAccepted(String reg_Num) {
			String sql = "select * from INTERNETACCEPTED where reg_Num=?";			
			acceptedVO mVo = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			System.out.println(reg_Num+": getAccepted");
			ResultSet rs = null;
						try {
				conn = DBManager.getConnection();				
				pstmt = conn.prepareStatement(sql);				
				pstmt.setString(1, reg_Num);
				System.out.println(reg_Num+": getAccepted23");
				rs = pstmt.executeQuery();			
				if (rs.next()) {
					mVo = new acceptedVO();
					mVo.setUser_ID(rs.getString("User_ID"));					
					mVo.setReg_Num(rs.getInt("Reg_Num"));
					mVo.setDep_Name(rs.getString("Dep_Name"));
					mVo.setDep_PN(rs.getString("Dep_PN"));
					mVo.setDep_Add1(rs.getString("Dep_Add1"));
					mVo.setDep_Add2(rs.getString("Dep_Add2"));
					mVo.setDep_Add3(rs.getString("Dep_Add3"));
					mVo.setArr_Name(rs.getString("Arr_Name"));
					mVo.setArr_PN(rs.getString("Arr_PN"));
					mVo.setArr_Add1(rs.getString("Arr_Add1"));
					mVo.setArr_Add2(rs.getString("Arr_Add2"));
					mVo.setArr_Add3(rs.getString("Arr_Add3"));
					mVo.setUser_Money(rs.getInt("User_Money"));
					mVo.setUser_Ship(rs.getString("User_Ship"));
					mVo.setUser_ShipT(rs.getString("User_ShipT"));
					mVo.setUser_ShipQ(rs.getString("User_ShipQ"));
					mVo.setUser_Text(rs.getString("User_Text"));
					mVo.setUser_PayS(rs.getString("User_PayS"));
					mVo.setUser_Date(rs.getString("User_Date"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return mVo;
		}
		
		public List<acceptedVO> selectAllNotices(String User_ID) {
		    // 최근 게시물 먼저 출력
		    String sql = "select * from INTERNETACCEPTED where USER_ID=? ORDER BY reg_num DESC";
		    List<acceptedVO> list = new ArrayList<acceptedVO>();
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		        conn = DBManager.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, User_ID);
		        rs = pstmt.executeQuery();
		        while (rs.next()) {
		            acceptedVO nVo = new acceptedVO();
		            nVo.setUser_ID(rs.getString("user_ID"));
		            nVo.setReg_Num(rs.getInt("reg_Num"));
		            nVo.setArr_Name(rs.getString("arr_Name"));
		            nVo.setUser_Text(rs.getString("user_Text"));
		            nVo.setUser_PayS(rs.getString("user_PayS"));
		            nVo.setUser_Date(rs.getString("User_Date"));
		            nVo.setTracking(rs.getString("Tracking"));
		            list.add(nVo);
		        }
		        System.out.println("글정보 저장 완료!(list)");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBManager.close(conn, pstmt, rs);
		    }
		    return list;
		}
		

		public List<acceptedVO> getList(int pageNum, int amount) {
		    List<acceptedVO> list = new ArrayList<>();
		    String sql = "select * " + "from (select rownum rn," + " a.* " + "from (select *" + " from INTERNETACCEPTED order by Reg_Num desc) a ) "
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
		            acceptedVO aVo = new acceptedVO();
		            aVo.setUser_ID(rs.getString("user_ID"));
		            aVo.setReg_Num(rs.getInt("reg_Num"));
		            aVo.setDep_Name(rs.getString("dep_Name"));
		            aVo.setDep_PN(rs.getString("dep_PN"));
		            aVo.setDep_Add1(rs.getString("dep_Add1"));
		            aVo.setDep_Add2(rs.getString("dep_Add2"));
		            aVo.setDep_Add3(rs.getString("dep_Add3"));
		            aVo.setArr_Name(rs.getString("arr_Name"));
		            aVo.setArr_PN(rs.getString("arr_PN"));
		            aVo.setArr_Add1(rs.getString("arr_Add1"));
		            aVo.setArr_Add2(rs.getString("arr_Add2"));
		            aVo.setArr_Add3(rs.getString("arr_Add3"));
		            aVo.setUser_Money(rs.getInt("user_Money"));
		            aVo.setUser_Ship(rs.getString("user_Ship"));
		            aVo.setUser_ShipT(rs.getString("user_ShipT"));
		            aVo.setUser_ShipQ(rs.getString("user_ShipQ"));
		            aVo.setUser_Text(rs.getString("user_Text"));
		            aVo.setUser_PayS(rs.getString("user_PayS"));
		            aVo.setUser_Date(rs.getString("User_Date"));
		            aVo.setTracking(rs.getString("Tracking"));
		            list.add(aVo);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBManager.close(conn, pstmt, rs);
		    }
		    return list;
		}	

			
		public int getCountByTracking(String User_ID, int tracking) {
		    String sql = "SELECT COUNT(*) AS count FROM INTERNETACCEPTED WHERE User_ID = ? AND Tracking = ?";
		    int count = 0;
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		        conn = DBManager.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, User_ID);
		        pstmt.setInt(2, tracking);
		        rs = pstmt.executeQuery();
		        if (rs.next()) {
		            count = rs.getInt("count");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBManager.close(conn, pstmt, rs);
		    }
		    return count;
		}
		

		public int getTotal() {
		    int result = 0;
		    String sql = "select count(*) as total from INTERNETACCEPTED";
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
		
		public int gettal(String User_ID) {
		    int result = 0;
		    String sql = "select count(*) as total from INTERNETACCEPTED where User_ID=?";
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		        conn = DBManager.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, User_ID);
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
		
		public void AdminOrderDelete(String reg_Num) {
			String sql = "DELETE FROM INTERNETACCEPTED WHERE reg_Num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, reg_Num);				
				pstmt.executeUpdate();
			} catch (Exception e) {			
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		public void updateTracking(String reg_Num, String tracking) {
		    String sql = "update INTERNETACCEPTED set tracking=? WHERE reg_Num=?";
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    System.out.println(sql);
		    try {
		        conn = DBManager.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, tracking);
		        pstmt.setString(2, reg_Num);
		        pstmt.executeUpdate(); // UPDATE 문이므로 executeUpdate()를 사용합니다.
		        System.out.println(tracking);
		        System.out.println(reg_Num);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        DBManager.close(conn, pstmt);
		    }
		}
		
		public List<acceptedVO> getListA(int pageNum, int amount, String User_ID){		
			List<acceptedVO> list = new ArrayList<>();		
			String sql = "select * "
					+ 	 "from (select rownum rn,"
					+ 				   " a.* "
					+ 			"from (select *"
					+ 				 " from INTERNETACCEPTED order by reg_num desc) a ) "
					+ 	 "where rn > ? and rn <= ? and User_ID = ?";		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		try {
			conn = DBManager.getConnection(); // 연결			
			pstmt = conn.prepareStatement(sql); // sql준비
			 
			pstmt.setInt(1, (pageNum - 1) * amount);
			pstmt.setInt(2, pageNum * amount);	
			pstmt.setString(3, User_ID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// 한바퀴 회전당 VO를 하나씩 생성
				acceptedVO aVo = new acceptedVO();
	            
				aVo.setUser_ID(rs.getString("user_ID"));
				aVo.setReg_Num(rs.getInt("reg_Num"));
				aVo.setArr_Name(rs.getString("Arr_Name"));
				aVo.setUser_Text(rs.getString("User_Text"));
				aVo.setUser_PayS(rs.getString("User_PayS"));
				aVo.setUser_Date(rs.getString("User_Date"));							
				aVo.setTracking(rs.getString("Tracking"));							
				list.add(aVo);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return list;
		}    

}
