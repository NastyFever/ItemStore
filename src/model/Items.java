package model;

import java.util.HashMap;


public class Items {
	public HashMap<Integer, Item> items = new HashMap<Integer, Item>();
	
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
	
	
	public Item getItem(int barCode) {
		return items.get(barCode);
	}
}
