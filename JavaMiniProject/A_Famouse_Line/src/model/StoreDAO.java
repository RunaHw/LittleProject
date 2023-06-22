package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.StoreDTO;

public class StoreDAO {
	
	

	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	
	int result= 0;
	int num2=0;
	String id=null;

	//-------------------------------------------------------------------------------------------------------------------------
	// 연결
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
			System.out.println("DB 연결 실패!");
		}
	
			
		
	}
	
	//-------------------------------------------------------------------------------------------------------------------------
	// 종료
	public  void Close() {
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
	
	//-------------------------------------------------------------------------------------------------------------------------
	// 상점 리스트 뽑아오는 메소드
	public ArrayList<StoreDTO> selectAll() {
		ArrayList<StoreDTO> list = new ArrayList<StoreDTO>();
		
		getCon();
		
		try {
			String sql = "SELECT * FROM STORE";
			psmt = conn.prepareStatement(sql);
		
			rs = psmt.executeQuery();

			
			while(rs.next()) {
				String id = rs.getString(1);
				int pr = rs.getInt(2);
				String imp = rs.getString(3);
				
				
				list.add(new StoreDTO(id,pr,imp));
		
			} 

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Close();
		}
		return list;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------
	// 2차 비번확인 메소드
	public boolean pw2Check(String id, int pw) {
		
		boolean result= false;
		
		getCon();
		try {
			String sql = "SELECT * FROM PLAYER WHERE PLAYER_ID = ? AND PW2 = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setInt(2, pw);
			rs = psmt.executeQuery();

							
			return rs.next();
				
				
			} 

		 catch (SQLException e) {

			e.printStackTrace();
		} finally {
			
			Close();
		}
		
		return result;
	}
		
	//-------------------------------------------------------------------------------------------------------------------------

	public int setPoint(int minus, String Player_id ) { // num = 아이템번호 num2 = 갯수
		
	
		getCon();
		
		try {
			String sql = "UPDATE PLAYER SET POINT = POINT + ? WHERE PLAYER_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  minus);
			psmt.setString(2, Player_id);
			
			return psmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Close();
		}
	 
	 
	 
	 return result;
 }
		
	//------------------------------------------------------------------------------

	public int setRank(int minus, String Player_id ) { // num = 아이템번호 num2 = 갯수
		
	
		getCon();
		
		try {
			String sql = "UPDATE PLAYER SET RANKING = RANKING + ? WHERE PLAYER_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  minus);
			psmt.setString(2, Player_id);
			
			return psmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Close();
		}
	 
	 
	 
	 return result;
 }
		
		
		
		
		
		
		
	
	//------------------------------------------------------------------------------------------------------
	public int inRecord(ArrayList<StoreDTO> StoreList, String Player_ID, int cnt, int i) {
		 getCon();
			try {
				i--;
				int price = StoreList.get(i).getItemPrice() * cnt;
				String sql = "INSERT INTO STORE_LOG(PLAYER_ID, ITEM_ID, ITEM_CNT, PRICE, STORE_DATE ) VALUES ( ? , ? , ?, ?, SYSDATE )";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, Player_ID);
				psmt.setString(2, StoreList.get(i).getItemID());
				psmt.setInt(3, cnt);
				psmt.setInt(4, price);
				
				result = psmt.executeUpdate();
				
				
				return result;
				
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				Close();
			}
			return result;
		 
		 
		 
	 }

}
	

	
