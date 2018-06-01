package WorkoutTracker;


import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

import java.sql.*;

public class Main {
	
	//jswing method
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	public static void main(String[] args) {
//testing
//		Workout w = new Workout();
//		Workout testFromFile = new Workout();
//		String file = "src/workouts.txt";
//		w.setWorkoutInfoByValue(25,15,1.5,250,150);
//		//w.setTime(25, 0);
//		
//		System.out.println();
//		w.printWorkoutInfo();		
//		System.out.println();
//		
//		testFromFile.printWorkoutInfo();
//		try {
//			w.saveToFile("workout");
//			testFromFile.loadFromFile(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		testFromFile.printWorkoutInfo();
		
//		//database variables
//		String database = "jdbc:mysql://localhost:3306/workouts?useSSL=true";
//		String databaseAdminName = "root";
//		String databaseAdminPass = "admin";
//		
//		//workout object setup
//		Workout w = new Workout();
//		w.setWorkoutInfoByValue(25,15,1.5,250,150);
//		System.out.println();
//		w.printWorkoutInfo();		
//		
//		//connect to database
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(database, databaseAdminName, databaseAdminPass);
//			Statement stmt = con.createStatement();
//			
//			//setting a query
//			ResultSet rs = stmt.executeQuery("select * from workout");
//			//getting metadata for use in loops
//			ResultSetMetaData rsmd = rs.getMetaData();
//			//columncount for loop displaying the entire row
//			int columnCount = rsmd.getColumnCount();
//			while(rs.next()){
//				for (int i = 1; i <= columnCount; i++){
//					//System.out.println(rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3) + " " + rs.);
//					System.out.print(rs.getObject(i) + " ");
//				}
//				System.out.println();
//			}
//			con.close();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Database d = new Database();
//		try {
//			//d.executeSQLUpdate("insert into workout (workout_name, workout_distance, "
//			//		+ "workout_calories, workout_vertft, workout_time) values ('zoopy', 1.7, 200, 100, '00:27:20')");
//			d.insertIntoWorkout(w);
//			//d.displayQueryResult();
//			d.closeConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		User u = new User("blake","volk","blakevolk@gmail.com","password123");
//		try {
//			//u.addUserToDB();
//			u.checkPassword("blakevolk@gmail.com", "passwrd123");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		Jswing testing
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			public void run(){
//				//createAndShowGUI();
//				try {
//					LogIn window = new LogIn();
//					
//					//window.frmWorkoutTracker.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.getLoginWindow().setVisible(true);
					//window.frmWorkoutTracker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		//command line - normal main
//		boolean running = true;
//		Scanner input = new Scanner(System.in); //get user input
//		
//		System.out.println("Welcome to the workout tracker.");
//		System.out.println();
//		System.out.println("Please log in, or create a new account.");
//		
//		boolean authenticating = true;
//		while(authenticating){		
//			System.out.println("1. log in");
//			System.out.println("2. Create an account.");
//			System.out.println("3. Exit Program.");
//			
//			int choice = input.nextInt();
//			switch(choice){
//			case 1:
//				System.out.print("Email: ");
//				String email = input.next();
//				
//				System.out.print("\nPassword: ");
//				String pass = input.next();
//				
//				User u = new User(email, pass);
//				try {
//					if(u.checkPassword(email, pass) == true){
//						System.out.println("Login successful.");
//						authenticating = false;
//					}
//					else{
//						System.out.println("Login failed. Try again.");
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				break;
//			case 2:
//				System.out.print("First Name: ");
//				String fname = input.next();
//				System.out.print("\nLast Name: ");
//				String lname = input.next();
//				System.out.print("\nEmail: ");
//				String newEmail = input.next();
//				System.out.print("\nPassword: ");
//				String newPass = input.next();
//				
//				User newUser = new User(fname, lname, newEmail, newPass);
//				//TODO check if user is already in the db
//				try {
//					newUser.addUserToDB();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("\nThank you for creating a new account. Please log in with your information.");				
//				break;
//			case 3:
//				authenticating = false;
//				running = false;
//				break;
//			default:
//				break;
//			}
//		}
//		while(running){
//			
//			System.out.println("Choose an option.");
//			System.out.println("1: Enter Workout Information");
//			System.out.println("2: Exit");
//			System.out.print("");
//			int choice = 0;
//			//if (input.hasNext() == true)
//			choice = input.nextInt();
//			
//				
//			switch(choice){
//			
//			//1 set workout info and save to file.
//			case 1:
//				Workout w = new Workout();
//				w.setWorkoutInfoInput(input);
//				try {
//					w.saveToFile("workout");
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
//				w.printWorkoutInfo();
//				break;
//			case 2:
//				running = false;
//				break;
//			default:
//				System.out.println("Thats not an option.");
//				break;
//			}
//		}
//		
//		input.close();
	}

}
