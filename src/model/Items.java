package model;

import java.util.HashMap;


public class Items {
	public HashMap<String, Item> items = new HashMap<String, Item>();
	
	public Items(){
		
	}

	public boolean addItem(Item item){
		if(items.containsKey(item.itemId))
			return false;
		else {
			items.put(item.itemId, item);
		}
		return true;
	}
	
	
	public Item getItem(String barCode) {
		return items.get(barCode);
	}
}
