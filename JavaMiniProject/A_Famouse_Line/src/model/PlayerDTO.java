package model;

public class PlayerDTO {

	private String player_id;
	private String pw1;
	private int pw2;
	private int point;
	private int ranking;

	public PlayerDTO() {
		super();
	}

	public PlayerDTO(String player_id, String pw1, int pw2, int point, int ranking) {
		super();
		this.player_id = player_id;
		this.pw1 = pw1;
		this.pw2 = pw2;
		this.point = point;
		this.ranking = ranking;
	}

	public PlayerDTO(String player_id, String pw1) {
		super();
		this.player_id = player_id;
		this.pw1 = pw1;
	}

	public PlayerDTO(String player_id, String pw1, int pw2) {
		super();
		this.player_id = player_id;
		this.pw1 = pw1;
		this.pw2 = pw2;
	}

	public String getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(String player_id) {
		this.player_id = player_id;
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}

	public int getPw2() {
		return pw2;
	}

	public void setPw2(int pw2) {
		this.pw2 = pw2;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}