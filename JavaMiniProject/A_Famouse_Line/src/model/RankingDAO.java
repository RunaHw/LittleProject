package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RankingDAO {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private String sql;
	private RankingDTO dtoR = new RankingDTO();
	
	//-------------------------------------------------------------------------------------------------------------
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
	
	//-------------------------------------------------------------------------------------------------------------
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
	
	//-------------------------------------------------------------------------------------------------------------
	public void RankingInfo() {
		getCon();
		try {
			sql = "SELECT * FROM (SELECT PLAYER_ID , RANKING , POINT FROM PLAYER ORDER BY RANKING DESC) WHERE ROWNUM <= 10";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				cnt++;
				System.out.println("순위 : " + cnt + "\t\t 아이디 : " + rs.getString(1) + "\t\t 총합 : " + rs.getInt(2)
						+ "\t\t 포인트 : " + rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

}
