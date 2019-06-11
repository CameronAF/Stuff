package q5_3;

/**
 * Subject interface, for Observer pattern
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/24/2018
 */
public interface Subject {
	//methods to add observers
	public void addObserver (Observer O);
	
	//method to notify observers of change
	public void notifyObserver();
}
