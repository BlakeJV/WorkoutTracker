package WorkoutTracker;

/**
 *	Helper class used to make time conversions 
 * @author Blake
 *
 */
public class Time extends Workout{
	//types of time to track
	private float years;	
	private float months;
	private float weeks;
	private float days;
	private float hours;
	private float minutes;
	private int seconds;
	
	//getters/setters
	public float getYears() {
		return years;
	}
	public void setYears(float years) {
		this.years = years;
	}
	public float getMonths() {
		return months;
	}
	public void setMonths(float months) {
		this.months = months;
	}
	public float getWeeks() {
		return weeks;
	}
	public void setWeeks(float weeks) {
		this.weeks = weeks;
	}
	public float getDays() {
		return days;
	}
	public void setDays(float days) {
		this.days = days;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public float getMinutes() {
		return minutes;
	}
	public void setMinutes(float minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	//converting functions
	public float weeksToYears(float weeks){
		return (float) (weeks / 52.14285714) ;
	}
	public float daysToWeeks(float days){
		return days / 7;
	}
	public float hoursToDays(float hours){
		return hours / 24;
	}
	public float minutesToHours(float minutes){
		return minutes / 60;
	}
	public float secondsToMinutes(int seconds){
		return seconds / 60;
	}
	
	//default
	public Time() {
		this.years = 0;
		this.months = 0;
		this.weeks = 0;
		this.days = 0;
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
	}
	//
	public Time(float min, int second){
		this.minutes = min;
		this.seconds = second;
	}
}
