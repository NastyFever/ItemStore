package model;

public class User {
	public int userId;
	public String name;
	public int dept;
	
	public User(int userId, String name, int dept){
		this.userId = userId;
		this.name = name;
		this.dept = dept;			
	}
	
	public String print(){
		return ("User: (" + userId + ") " + name + " has a dept of " + dept + " SEK" );
	}
	
}
