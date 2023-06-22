package model;

public class RankingDTO {
	private String player_id;
	public int point;
	public int ranking;

	public RankingDTO() {
		super();
	}

	public RankingDTO(String player_id, int point, int ranking) {
		super();
		this.player_id = player_id;
		this.point = point;
		this.ranking = ranking;
	}

	public String getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(String player_id) {
		this.player_id = player_id;
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