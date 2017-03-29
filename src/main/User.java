package main;

public class User {
	private String id;
	private String password;
	private String fName;
	private String lName;
	
	User () {}
	
	User (String id, String password, String fName, String lName){
		this.id = id;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
	}
	
	public static User login(String userID, String password) throws Exception {
		User user = null;
		
		Reader reader = new Reader();
		user = reader.LoadUser(userID);
		
		if (!user.checkPassword(password)) {
			throw new PasswordIncorrect();
		}
		
		return user;
	}
	
	// Gets
	public String getUserID () {
		return this.id;
	}
	
	public boolean checkPassword (String password) {
		
		if (this.password.equals(password))
			return true;
		else
			return false;
	}
	
	public String getFirstName () {
		return this.fName;
	}
	
	public String getLastName () {
		return this.lName;
	}
}