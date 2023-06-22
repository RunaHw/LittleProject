package model;

public class StoreDTO {
	

	private String itemID ;
	private int itemPrice;
	private String itemImfor;
	
	
	
	public StoreDTO(String itemID, int itemPrice, String itemImfor) {
		super();
		this.itemID = itemID;
		this.itemPrice = itemPrice;
		this.itemImfor = itemImfor;
	}



	public String getItemID() {
		return itemID;
	}



	public void setItemID(String itemID) {
		this.itemID = itemID;
	}



	public int getItemPrice() {
		return itemPrice;
	}



	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}



	public String getItemImfor() {
		return itemImfor;
	}



	public void setItemImfor(String itemImfor) {
		this.itemImfor = itemImfor;
	}



	public StoreDTO() {
	
	}
	
	

}
