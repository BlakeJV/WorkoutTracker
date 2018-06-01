package WorkoutTracker;

import java.sql.*;

/**
 * This class holds database variables to easily connect to the local database
 * Holds functions to interact with the database quickly.
 * @author Blake
 *
 */
public class Database {
	
	//database variables
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	private String database;
	private String databaseAdminName;
	private String databaseAdminPass;
	
	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getDatabaseAdminName() {
		return databaseAdminName;
	}

	public void setDatabaseAdminName(String databaseAdminName) {
		this.databaseAdminName = databaseAdminName;
	}

	public String getDatabaseAdminPass() {
		return databaseAdminPass;
	}

	public void setDatabaseAdminPass(String databaseAdminPass) {
		this.databaseAdminPass = databaseAdminPass;
	}

	//default database connection
	public Database(){
		this.database = "jdbc:mysql://localhost:3306/workouts?useSSL=true";
		this.databaseAdminName = "root";
		this.databaseAdminPass = "admin";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(this.database, this.databaseAdminName, this.databaseAdminPass);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//custom database constructor
	public Database(String databaseName, String databaseAdminName, String databaseAdminPass){
		this.database = databaseName;
		this.databaseAdminName = databaseAdminName;
		this.databaseAdminPass = databaseAdminPass;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(this.database, this.databaseAdminName, this.databaseAdminPass);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//connect
	public void closeConnection() throws SQLException{
		this.con.close();		
	}
	
	//perform search/select query
	public void executeSQLQuery(String query) throws SQLException{
		this.stmt = con.createStatement();
		this.rs = stmt.executeQuery(query);
	}
	
	//perform update/insert/delete
	public void executeSQLUpdate(String query) throws SQLException{
		this.stmt = con.createStatement();
		stmt.executeUpdate(query);
	}
	
	public void insertIntoWorkout(Workout w) throws SQLException{
		this.stmt = con.createStatement();
		stmt.executeUpdate("insert into workout (workout_name, workout_distance, "
				+ "workout_calories, workout_vertft, workout_time) values "
				+ "('"+w.getName()+"' , "+w.getDistance()+", "+w.getCalorie()+", "+w.getVertFt()+", '"+Math.round(w.t.getHours())+":"+Math.round(w.t.getMinutes())+":"+Math.round(w.t.getSeconds())+"')");
	}
	
	public void insertIntoUsers(User u) throws SQLException{
		this.stmt = con.createStatement();
		stmt.executeUpdate("insert into users (users_email, users_name, "
				+ "users_pass) values "
				+ "('"+u.getEmailAddress()+"', '"+u.getFirstName()+" "+u.getLastName()+"', '"+u.getPassword()+"')");
	}
	
	//print query results from executeQuery
	public void displayQueryResult() throws SQLException {
		this.rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		while(this.rs.next()){
			for (int i = 1; i <= columnCount; i++){
				System.out.print(rs.getObject(i) + " ");
			}
			System.out.println();
		}
	}
	
	public String getUserPassword() throws SQLException {
		this.rsmd = rs.getMetaData();
		rs.next();
		String pass = rs.getString(1);
		return pass;
//		int columnCount = rsmd.getColumnCount();
//		while(this.rs.next()){
//			for (int i = 1; i <= columnCount; i++){
//				System.out.print(rs.getObject(i) + " ");
//			}
//			System.out.println();
//		}
	}
	//connect to database, perform query, print results.
	//	try {
	//		Class.forName("com.mysql.cj.jdbc.Driver");
	//		Connection con = DriverManager.getConnection(database, databaseAdminName, databaseAdminPass);
	//		Statement stmt = con.createStatement();
	//		
	//		//setting a query
	//		ResultSet rs = stmt.executeQuery("select * from workout");
	//		//getting metadata for use in loops
	//		ResultSetMetaData rsmd = rs.getMetaData();
	//		//columncount for loop displaying the entire row
	//		int columnCount = rsmd.getColumnCount();
	//		while(rs.next()){
	//			for (int i = 1; i <= columnCount; i++){
	//				//System.out.println(rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3) + " " + rs.);
	//				System.out.print(rs.getObject(i) + " ");
	//			}
	//			System.out.println();
	//		}
	//		con.close();
	//		
	//	} catch (Exception e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
}
