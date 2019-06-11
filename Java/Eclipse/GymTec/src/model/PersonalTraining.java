package model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *Class PersonalTraining that implements Service and is serializable
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class PersonalTraining implements  Serializable, Service {
	private String name;
	private User instructor;
	private DayOfWeek day;
	private LocalTime time;
	private User attendee;
	
	/**
	 * Constructor for class PersonalTraining
	 * @postcondition a instance of PersonalTraining would have been initialized
	 */
	public PersonalTraining() {}
}
