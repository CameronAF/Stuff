package q5_3;

/**
 * Observer interface, for Observer pattern
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/24/2018
 */
public interface Observer {
	//method to update the observer, used by subject
	public void update(double value);
}
