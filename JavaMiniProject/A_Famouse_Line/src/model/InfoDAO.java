package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InfoDAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	// -------------------------------------------------------------------------------------------------------------
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

	// -------------------------------------------------------------------------------------------------------------
	public void Close() {
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

	// -------------------------------------------------------------------------------------------------------------
	public ArrayList<InfoDTO> InfoCheck(String id) {

		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();

		getCon();
		try {
			String sql = " SELECT PLAYER_ID, POINT, RANKING FROM PLAYER WHERE PLAYER_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String Pid = rs.getString(1);
				int point = rs.getInt(2);
				int ranking = rs.getInt(3);

				list.add(new InfoDTO(Pid, point, ranking));
			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {

			Close();
		}

		return list;
	}
	// -------------------------------------------------------------------------------------------------------------

	public ArrayList<InfoDTO> itemCheck(String id) {

		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();

		getCon();
		try {
			String sql = "SELECT DISTINCT A.PLAYER_ID , A.ITEM_ID , B.아이템합계 FROM STORE_LOG A , (SELECT ITEM_ID , SUM(ITEM_CNT) AS 아이템합계 FROM STORE_LOG GROUP BY ITEM_ID) B WHERE A.ITEM_ID = B.ITEM_ID and A.PLAYER_ID = ? ORDER BY A.ITEM_ID ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {

				String itemId = rs.getString(2);
				int itemCnt = rs.getInt(3);

				list.add(new InfoDTO(itemId, itemCnt));
			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {

			Close();
		}

		return list;
	}

	// ---------------------------------------------------------------------------------------------------------------
	// -------------------------------------- 아이템 감소 메소드
	// Player_id : 플레이어 이름, itemName : 사용한 아이템 이름
	public void updateItem(String Player_id, String itemName) {

		getCon();

		try {

			String sql = "INSERT INTO STORE_LOG VALUES (? , ? , -1 , 0 , SYSDATE )";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Player_id);
			psmt.setString(2, itemName);

			int result = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Close();
		}

	}
}
