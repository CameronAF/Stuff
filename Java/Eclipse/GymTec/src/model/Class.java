package model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.LinkedList;

/**
 * Class Class that implements Service and is Serializable
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class Class implements Serializable, Service {
	private String name;
	private User instructor;
	private DayOfWeek day;
	private LocalTime time;
	private int capacity;
	private LinkedList<User> roster;
	
	/**Get name from Class
	 * @return name value of String type  */
	public String getName() { return name; }
	/**Get instructor from Class
	 * @return instructor value of User type  */
	public User getInstructor() { return instructor; }
	/**Get day from Class
	 * @return day value of DayOfWeek type  */
	public DayOfWeek getDay() { return day; }
	/**Get time from Class
	 * @return time value of LocalTime type  */
	public LocalTime getTime() { return time; }
	/**Get capacity from Class
	 * @return capacity value of int type  */
	public int getCapacity() { return capacity; }
	/**Get roster size from Class
	 * @return name roster size of int type  */
	public int getClassSize() { return roster.size(); }
	/**Get roster from Class
	 * @return a LinkedList of User  */
	public LinkedList<User> getRoster() { return roster; }
	
	/**set the value of name to temp String
	 * @param temp is string value to be set in name
	 * @postcondition name will contain new value  */
	public void setName(String temp) { name = temp; }
	/**set the value of instructor to temp User
	 * @param temp is User value to be set in instructor
	 * @postcondition instructor will contain new value  */
	public void setInstructor(User temp) { instructor = temp; }
	/**set the value of day to temp DayOfWeek
	 * @param temp is DayOfWeek value to be set in day
	 * @postcondition day will contain new value  */
	public void setDay(DayOfWeek temp) { day = temp; }
	/**set the value of time to temp LocalTime
	 * @param temp is LocalTime value to be set in time
	 * @postcondition time will contain new value  */
	public void setTime(LocalTime temp) { time = temp; }
	/**set the value of capacity to temp int
	 * @param temp is int value to be set in capacity
	 * @postcondition capacity will contain new value  */
	public void setCapacity(int temp) { capacity = temp; }

	/**
	 * Constructor for class Class
	 * @postcondition a instance of LoginView would have been initialized
	 */
	public Class() {}
}
