package model;

public class InfoDTO {
	String player_id;
	int point;
	int ranking;
	String itemName;
	int itemCnt;

	public InfoDTO(String player_id, int point, int ranking, String itemName, int itemCnt) {
		super();
		this.player_id = player_id;
		this.point = point;
		this.ranking = ranking;
		this.itemName = itemName;
		this.itemCnt = itemCnt;
	}

	public InfoDTO() {
		super();
	}

	public InfoDTO(String player_id, int point, int ranking) {
		super();
		this.player_id = player_id;
		this.point = point;
		this.ranking = ranking;
	}

	public InfoDTO(String itemName, int itemCnt) {
		super();
		this.itemName = itemName;
		this.itemCnt = itemCnt;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCnt() {
		return itemCnt;
	}

	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
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
