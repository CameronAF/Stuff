package q5_4;

/**
 * Observer interface, for Observer pattern
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/24/2018
 */
public interface Observer {
	//method to update the observer, used by subject
	public void update(String color, int value);
}