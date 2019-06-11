package model;

import java.io.*;
import java.util.LinkedList;

/**
 * Singleton Class AllServices that is Serializable and an Observer (Observer Patter)
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class AllServices implements Serializable, Observer {
	private static AllServices allServicesClass = null;
	private static LinkedList<Service> allServices = new LinkedList<Service>(); 
	
	/**
	 * Constructor for class AllServices
	 * @postcondition a instance of AllServices would have been initialized
	 */
	private AllServices() {
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(this.getClass().getSimpleName()+".dat"));
			allServices = (LinkedList<Service>) in.readObject();	
			in.close();
		}
		catch (FileNotFoundException e) {
			//file was not made yet
		} 
		catch (ClassNotFoundException e) {
			// shouldn't happen
			e.printStackTrace();
		}
		catch (IOException e) {
			// don't know what happened
			e.printStackTrace();
		}
	}
	
	/**
	 * Save the instance of this class as a .dat file in project location
	 * @postcondition this instance will be saved 
	 */
	public void saveClass() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(this.getClass().getSimpleName()+".dat"));
			out.writeObject(allServices);
			out.close();
		}
		catch (IOException e) {
			// don't know what happened
			e.printStackTrace();
		}
	}
	
	/**Get private static instance of AllServices (Singleton pattern)
	 * @return a static instance of AllServices will be passes */
	public static AllServices getInstance() {
		if (allServicesClass == null)  {
			allServicesClass = new AllServices();
		}
		return allServicesClass;
	}
}
