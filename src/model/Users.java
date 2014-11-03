package model;

import java.util.HashMap;


public class Users {
	public HashMap<Integer, User> users = new HashMap<Integer, User>();
	
	public Users(){
		
	}

	public boolean addUser(User item){
		if(users.containsKey(item.userId))
			return false;
		else {
			users.put(item.userId, item);
		}
		return true;
	}
	
	
	public User getUser(int barCode) {
		return users.get(barCode);
	}
}