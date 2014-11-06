package model;

public class User {
	public String userId;
	public String name;
	public int dept;
	private int rowID;
	
	public User(String userId, String name, int dept, int rowID){
		this.userId = userId;
		this.name = name;
		this.dept = dept;			
		this.rowID = rowID;
	}
	
	public String print(){
		return ("User: (" + userId + ") " + name + " has a dept of " + dept + " SEK" );
	}
	
	public int getRow(){
		return rowID;
	}
	
}
