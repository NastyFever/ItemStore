package model;

public class Item {
	public String itemId;
	public String name;
	public int price;
	
	public Item(String itemId, String name, int price){
		this.itemId = itemId;
		this.name = name;
		this.price = price;			
	}
	
	
	public String print(){
		return ("Item: (" + itemId + ") " + name + " costs " + price + " SEK" );
	}
	
}
