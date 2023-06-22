package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionDAO {
	ArrayList<QuestionDTO> list = new ArrayList<QuestionDTO>();
	QuestionDTO quesDto = new QuestionDTO();
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement psmt = null;
	Scanner sc = new Scanner(System.in);
	int cnt;
	public int result = 0;
	// DAO
	// Data Access Object : 데이터에 접근하는 객체 [DB에 접근하는 객체]
	// DB에 접근해서 SQL 쿼리를 실행하는 코드(JDBC)를 정의(메서드)해놓은 클래스
	// 하나의 테이블당 하나씩

	//// * 각 메소드는 SQL문을 실행하고 , 실행한 결과를 리턴

	public void getCon() {
		// 드라이버 동적 로딩
		// 데이터베이스 연결 권한 체크!

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String db_user = "cgi_7_0619_3";
			String db_pw = "smhrd3";
			conn = DriverManager.getConnection(db_url, db_user, db_pw);

		} catch (Exception e) {
			System.out.println("getCon() 오류");
			e.printStackTrace();
		}

	}

	// ----------------------------------------------------------------------------------------
	public void Close() {
		// 자원을 반납할 수 있는 기능 -> psmt, conn, rs

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
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// ----------------------------------------------------------------------------------------
	// 모든 메소드에서 사용할 수 있는 결과값 변수!
	// 각 기능에 대한 메소드 구조 생성!

	// ----------------------------------------------------------------------------------------
	// 선택한 장르로만 ArrayList로 묶어줄 메소드
	public ArrayList<QuestionDTO> selectAll(String question) {
		ArrayList<QuestionDTO> list = new ArrayList<QuestionDTO>();

		getCon();
		try {
			String sql = "select * from question where genre =? ORDER BY QUESTION_NUMBER";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, question);

			rs = psmt.executeQuery();

			// rs에 있는 조회 결과를 옮겨 담기
			// 만약에 rs 안에 데이터가 있다면
			// select 는
			while (rs.next()) {
				int question_number = rs.getInt(1);
				String title = rs.getString(2);
				String answer = rs.getString(3);
				String path = rs.getString(4);
				String genre = rs.getString(5);
				String explication = rs.getString(6);
				String path2 = rs.getString(7);

				// 하나로 묶어서 반환
				list.add( new QuestionDTO(question_number, title, answer, path, genre, explication, path2)
						);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Close();
		}
		return list;
	}
	// ----------------------------------------------------------------------------------------
	// 장르선택 매개변수 변환해주는 메소드
	public String genreSel(int select) {
		if(select == 1) {
			return "영화";
		}else if(select == 2) {
			return "드라마";
		}else if(select == 3) {
			return "게임";
		}else if(select == 4) {
			return "광고";
		}else {
			return null;
		}
	}
	// ----------------------------------------------------------------------------------------
	// 문제 정답오답 메소드
	public int isRight(ArrayList<QuestionDTO> list, String cor, int i) {
		String answer =  list.get(i).getAnswer();
		if(answer.equals(cor)) {
			return 0;
		}
		else {
			return -1;
		}
	}
	// ----------------------------------------------------------------------------------------
	
	
	
	
	
	
	
}
