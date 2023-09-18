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

import dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
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

	// 사용자 인증시 사용하는 메소드
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select USER_PW from MEMBER where USER_ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("USER_PW") != null
						&& rs.getString("USER_PW").equals(pwd)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
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
		return result;
	}

	// 아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember(String userid) {
		String sql = "select * from MEMBER where USER_ID=?";
		MemberVO mVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();			
			if (rs.next()) {
				mVo = new MemberVO();
				mVo.setUserid(rs.getString("User_ID"));
				mVo.setPwd(rs.getString("User_PW"));
				mVo.setName(rs.getString("User_NAME"));
				mVo.setEmail(rs.getString("User_EMAIL"));
				mVo.setPhone(rs.getString("User_PHONE"));
				mVo.setAdd1(rs.getString("User_ADD1"));
				mVo.setAdd2(rs.getString("User_ADD2"));
				mVo.setAdd3(rs.getString("User_ADD3"));
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

	public int confirmID(String userid) {
		int result = -1;
		String sql = "select User_ID from MEMBER where User_ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
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
		return result;
	}

	public int insertMember(MemberVO mVo) {
		int result = -1;
		String sql = "insert into MEMBER values(?, ?, ?, ?, ?, ?, ?, ?)";		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getUserid());
			pstmt.setString(2, mVo.getPwd());
			pstmt.setString(3, mVo.getName());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getPhone());			
			pstmt.setString(6, mVo.getAdd1());
			pstmt.setString(7, mVo.getAdd2());
			pstmt.setString(8, mVo.getAdd3());

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

	public int updateMember(MemberVO mVo) {
		int result = -1;
		String sql = "update MEMBER set User_PW=?, User_NAME=?, User_Email=?, User_Phone=?, User_Add1=?, User_Add2=?, User_Add3=? where User_ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getPwd());			
			pstmt.setString(2, mVo.getName());			
			pstmt.setString(3, mVo.getEmail());
			pstmt.setString(4, mVo.getPhone());
			pstmt.setString(5, mVo.getAdd1());
			pstmt.setString(6, mVo.getAdd2());
			pstmt.setString(7, mVo.getAdd3());
			pstmt.setString(8, mVo.getUserid());			
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
	
	public String findID(String name, String phone) {
	    String userID = null;
	    String sql = "SELECT User_ID FROM MEMBER WHERE User_Name = ? AND User_Phone = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name);
	        pstmt.setString(2, phone);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            userID = rs.getString("User_ID");
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

	    return userID;
	}
	
	public boolean deleteMember(String userid, String pwd) {
		 boolean deleted = false;
		    String sql = "SELECT User_PW FROM MEMBER WHERE User_ID=?";
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;		    
		    try {
		        conn = DBManager.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, userid);
		        rs = pstmt.executeQuery();
		        if (rs.next()) {
		            String storedPwd = rs.getString("User_PW");		            
		            if (pwd.equals(storedPwd)) {
		            	System.out.println("들어옴");
		                // 입력한 비밀번호와 저장된 비밀번호가 일치하면 삭제 작업 수행
		                String deleteSql = "DELETE FROM MEMBER WHERE User_ID=?";
		                pstmt = conn.prepareStatement(deleteSql);
		                pstmt.setString(1, userid);
		                int rowsAffected = pstmt.executeUpdate();
		                if (rowsAffected > 0) {
		                    deleted = true;
		                }
		            }
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
		    return deleted;
		}
	
	
	public String findpw(String name, String userid, String phone) {
	    String userPW = null;
	    String sql = "SELECT User_PW FROM MEMBER WHERE User_Name = ? AND User_ID = ? AND User_Phone = ?";

	    try (
	        Connection conn = DBManager.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	    ) {
	        pstmt.setString(1, name);
	        pstmt.setString(2, userid);
	        pstmt.setString(3, phone);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                userPW = rs.getString("User_PW");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return userPW;
	}
	public int updatePassword(String userid, String newPassword) {
	    int result = -1;
	    String sql = "UPDATE MEMBER SET User_PW = ? WHERE User_ID = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, newPassword);
	        pstmt.setString(2, userid);
	        
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
	 // 회원 출력
		public List<MemberVO> selectAllMembers() {
			String sql = "select * from Member ";
			List<MemberVO> list = new ArrayList<MemberVO>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					MemberVO mVo = new MemberVO();
					mVo.setUserid(rs.getString("User_ID"));
					mVo.setPwd(rs.getString("User_Pwd"));
					mVo.setName(rs.getString("User_Name"));
					mVo.setEmail(rs.getString("User_Email"));
					mVo.setPhone(rs.getString("User_Phone"));
					mVo.setAdd1(rs.getString("User_Add1"));
					mVo.setAdd2(rs.getString("User_Add2"));
					mVo.setAdd3(rs.getString("User_add3"));
					list.add(mVo);
				}
				System.out.println("member(list)");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, stmt, rs);
			}
			return list;
		}

		// 페이징
		public List<MemberVO> getList(int pageNum, int amount) {
			List<MemberVO> list = new ArrayList<>();
			String sql = "select * " + "from (select rownum rn," + " a.* " + "from (select *" + " from member) a ) "
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
					MemberVO mVo = new MemberVO();
					mVo.setUserid(rs.getString("user_ID"));
					mVo.setPwd(rs.getString("User_Pw"));
					mVo.setName(rs.getString("User_Name"));
					mVo.setEmail(rs.getString("User_Email"));
					mVo.setPhone(rs.getString("User_Phone"));
					mVo.setAdd1(rs.getString("User_Add1"));
					mVo.setAdd2(rs.getString("User_Add2"));
					mVo.setAdd3(rs.getString("User_add3"));
					list.add(mVo);
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
			String sql = "select count(*) as total from member";
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
		// 같은아이디 접수갯수세기
		public int getAcceptedCount(String userid) {
			int count = 0;
			String sql = "SELECT COUNT(*) AS count FROM internetaccepted ia " + "JOIN member m ON ia.user_ID = m.user_id "
					+ "WHERE m.user_id = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
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

		public void AdmindeleteMember(String userid) {
			String sql = "DELETE FROM MEMBER WHERE User_ID=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				pstmt.executeUpdate();
			} catch (Exception e) {			
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}	
	}
}


