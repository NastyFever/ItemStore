package model;

import java.util.HashMap;


public class Users {
	public HashMap<String, User> users = new HashMap<String, User>();
	
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
	
	
	public User getUser(String barCode) {
		return users.get(barCode);
	}
}