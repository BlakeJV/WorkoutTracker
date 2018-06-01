package WorkoutTracker;

import java.sql.SQLException;

/**
 * Used to set, hold, and retrieve user information along with the database.
 * @author Blake
 *
 */
public class User extends Database{
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String fName, String lName, String email, String pass) {
		this.firstName = fName;
		this.lastName = lName;
		this.emailAddress = email;
		this.password = pass;	
	}
	
	public User(String email, String pass) {
		this.firstName = "";
		this.lastName = "";
		this.emailAddress = email;
		this.password = pass;	
	}
	
//	public void checkInput(String input){
//		if (input. == "0"){
//			
//		}
//	}
	
	public void getUserInfo(){
		
	}
	
	public void addUserToDB() throws SQLException{
		Database d = new Database();
		d.insertIntoUsers(this);
		System.out.println("Added user Successfully");
		d.closeConnection();
	}
	
	public boolean checkPassword(String email, String passwordAttempt) throws SQLException{
		Database d = new Database();
		try {
			d.executeSQLQuery("select users_pass from users where users_email = '" + email + "'");
			if (d.getUserPassword().compareTo(passwordAttempt) == 0){
				//System.out.println("Login successful.");
				return true;
			}
			else {
				//System.out.println("Login failed. Try again.");
				return false;
			}
		} 
		catch (SQLException e) {
					
			return false;
		}
	}
}
