package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PlayerDAO {

	Scanner sc = new Scanner(System.in);
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private String sql;
	private PlayerDTO rdto = new PlayerDTO();
	public int resultInt;

	//-----------------------------------------------------------------------------------------------------------------------

	
	//-----------------------------------------------------------------------------------------------------------------------
	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String db_id = "cgi_7_0619_3";
			String db_pw = "smhrd3";
			conn = DriverManager.getConnection(url, db_id, db_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn != null) {
			
		} else {
			
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------
	public int join(String id, String pw1, int pw2) {
		getCon();
		try {
			sql = "INSERT INTO PLAYER VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw1);
			psmt.setInt(3, pw2);
			psmt.setInt(4, 0);
			psmt.setInt(5, 0);
			resultInt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return resultInt;
	}

	//-----------------------------------------------------------------------------------------------------------------------
	public int login(String id, String pw1) {
		getCon();
		try {
			sql = "SELECT player_id, pw1 FROM PLAYER WHERE player_id=? AND pw1=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw1);
			rs = psmt.executeQuery();
			if (rs.next()) {
				resultInt = 1;
			} else {
				resultInt = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return resultInt;
	}

	//-----------------------------------------------------------------------------------------------------------------------
	public void findPw(String id, int pw2) {
		getCon();
		try {
			sql = "SELECT player_id, pw2 FROM PLAYER WHERE player_id=? AND pw2=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setInt(2, pw2);
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println("비밀번호를 초기화 합니다.");
				System.out.print("새로운 비밀번호 >> ");
				String pw1 = sc.next();
				try {
					sql = "UPDATE PLAYER SET pw1=? WHERE player_id=?";
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, pw1);
					psmt.setString(2, id);
					resultInt = psmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close();
				}
				if (resultInt > 0) {
					System.out.println("비밀변호 변경 완료!");
				} else {
					System.out.println("비밀번호 변경 실패!");
				}
			} else {
				System.out.println("정보가 맞지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

}
