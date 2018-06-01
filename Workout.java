package WorkoutTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;


/***
 * This class holds information on the typical workout, such as time, calories burned, ect.
 * 
 * @author Blake
 * @version 1.0
 * @since 3/14/2018
 */
public class Workout {
	private String name;
	private double distance;
	private int calorie;
	private int vertFt;
	Time t;
	Calendar date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getTime() {
		return t.getMinutes();
	}
	public void setTime(float min, int sec) {
		this.t.setMinutes(min);
		this.t.setSeconds(sec);
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public int getVertFt() {
		return vertFt;
	}
	public void setVertFt(int vertFt) {
		this.vertFt = vertFt;
	}
	
	//default constructor
	public Workout(){
		this.t = new Time();
		this.calorie = 0;
		this.distance = 0;
		this.vertFt = 0;
		this.name = "guest";
	}
	//normal entry constructor
	public Workout(float min, int sec, int distance, int calorie, int vertFt) {
		this.t = new Time(min, sec);
		this.distance = distance;
		this.calorie = calorie;
		this.vertFt = vertFt;
		this.name = "guest";
	}
	
	/**
	 * Sets basic workout information via user input for THIS workout.
	 * 
	 */
	public void setWorkoutInfoInput(Scanner input) {
		//Scanner in = new Scanner(System.in);
		//Time t = new Time();
		//input = new Scanner(System.in);
		
		System.out.print("Minutes: ");
		float min;
		min = input.nextFloat();
		System.out.print("Seconds: ");
		int seconds;
		seconds = input.nextInt();
		this.t = new Time(min, seconds);
		
		System.out.print("Distance: ");
		this.distance = input.nextDouble();
		
		System.out.print("Calories: ");
		this.calorie = input.nextInt();
		
		System.out.print("VertFt: ");
		this.vertFt = input.nextInt();
		
		//input.close();
	}
	
	/**
	 * Sets basic workout information via passed in values for THIS workout.
	 * 
	 */
	public void setWorkoutInfoByValue(float min, int sec, double dis, int cal, int vertf) {
		this.t = new Time(min, sec);
		this.distance = dis;
		this.calorie = cal;
		this.vertFt = vertf;
	}
	
	/**
	 * Returns basic workout information
	 * 
	 */
	public void printWorkoutInfo(){
		System.out.print("Time: " + (int)t.getMinutes() + " minutes and " + t.getSeconds() + " seconds");
		System.out.print("\nDistance: " + this.distance);
		System.out.print("\nCalories: " + this.calorie);
		System.out.print("\nVertical Ft: " + this.vertFt);
		System.out.println();
	}
	
	/**
	 * 
	 * #TODO use for future json work
	 */
	public void printWorkoutInfoJson(){
		System.out.print("Time: " + (int)t.getMinutes() + " minutes and " + t.getSeconds() + " seconds");
		System.out.print("\nDistance: " + this.distance);
		System.out.print("\nCalories: " + this.calorie);
		System.out.print("\nVertical Ft: " + this.vertFt);
	}
	
	@Override
	public String toString() {
		return "Workout: distance= " + distance + ", calorie= " + calorie + ", vertFt= " + vertFt + ", time: minutes= " + t.getMinutes()
		+ ", seconds= " + t.getSeconds();
	}
	/**
	 * Saves workout information to file location "src/fileName.txt"
	 * @throws FileNotFoundException 
	 * 
	 */
	public void saveToFile(String fileName) throws FileNotFoundException{
		PrintWriter out = new PrintWriter("src/Workouts/" + fileName + ".txt");
		out.print(this.toString());
		out.close();
	}
	
	/**
	 * This method will load a passed in file source and return a new workout.
	 * Method must be used with correct format, or it will not work. Using "," as a delimiter and hardcoded substring values on the source file.
	 * Refer to the toString() method for exact format.
	 * @param fileName
	 * @return Workout
	 * @throws FileNotFoundException
	 */
	public void loadFromFile(String fileName, Scanner input) throws FileNotFoundException {		
		input = new Scanner(new File(fileName));
		input.useDelimiter(",");
		
		//Workout stats = new Workout();
		int counter = 0;
		while (input.hasNext()){
			
			String content = input.next();
			
			switch (counter){
				case 0: //System.out.println(content.substring(19, content.length())); //distance
						this.distance = Double.parseDouble(content.substring(19, content.length()));
						break;
				case 1: //System.out.println(content.substring(10, content.length())); //cal
						this.calorie = Integer.parseInt(content.substring(10, content.length()));
						break;
				case 2: //System.out.println(content.substring(9, content.length()));	 //vertft
						this.vertFt = Integer.parseInt(content.substring(9, content.length()));
						break;
				case 3: //System.out.println(content.substring(16, content.length())); //min
						this.t.setMinutes(Float.parseFloat(content.substring(16, content.length())));
						break;
				case 4: //System.out.println(content.substring(10, content.length())); //sec
						this.t.setSeconds(Integer.parseInt(content.substring(10, content.length())));
						break;
			}
			//System.out.println(content);
			counter++;
		}
		//return stats;
		input.close();
	}
	
}
