package model;

public class User {
	public int userId;
	public String name;
	public int dept;
	private int rowID;
	
	public User(int userId, String name, int dept, int rowID){
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
