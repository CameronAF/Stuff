package model;

import java.io.*;
import java.util.LinkedList;

/**
 * Singleton Class AllMemberships that is Serializable and an Observer (Observer Patter)
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class AllMemberships implements Serializable, Observer {
	private static AllMemberships allMembershipsClass = null;
	private static LinkedList<Membership> allMemberships = new LinkedList<Membership>(); 
	
	/**
	 * Constructor for class AllMemberships
	 * @postcondition a instance of AllMemberships would have been initialized
	 */
	private AllMemberships() {
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(this.getClass().getSimpleName()+".dat"));
			allMemberships = (LinkedList<Membership>) in.readObject();	
			in.close();
		}
		catch (FileNotFoundException e) {
			// not an issue
		} 
		catch (ClassNotFoundException e) {
			// shouldn't happen
			e.printStackTrace();
		}
		catch (IOException e) {
			// don't know what happened
			e.printStackTrace();
		}
		if (allMemberships.size() == 0) {
			allMemberships.add(new Membership("Employee", "Manager", "0.00"));
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
			out.writeObject(allMemberships);
			out.close();
		}
		catch (IOException e) {
			// don't know what happened
			e.printStackTrace();
		}
	}
	
	/**Get private static instance of AllMemberships (Singleton pattern)
	 * @return a static instance of AllMemberships will be passes */
	public static AllMemberships getInstance() {
		if (allMembershipsClass == null)  {
			allMembershipsClass = new AllMemberships();
		}
		return allMembershipsClass;
	}
	
	/**
	 * get a specific Membership from AllMemberships
	 * @param type the membership that matches this type value
	 * @param plan the membership that matches this plan value
	 * @return Membership that contains the passes parameters
	 */
	public Membership getMembership(String type, String plan) {
		if (allMemberships == null || allMemberships.size() == 0) {
			return null;
		}
		return allMemberships.stream()
					.filter(mem -> (mem.getType().equals(type) && mem.getPlan().equals(plan)))
			        .findFirst().orElse(null);
	}
	
	/**
	 * checks if there is a Membership at the passed index location
	 * @param index the index to be checked 
	 * @return true if there is a Membership at the passed index
	 */
	public boolean isItemAtIndex(int index) {
		if (allMemberships != null && index < allMemberships.size()) {
			return true;
		}
		return false;
	}
	
	/**
	 * edit a Membership that already exist at a given index
	 * @precondition can not remove contents of first Membership Manager
	 * @param items the new values that will be used for the Membership
	 * @param the index of the Membership in AllMemberships
	 * @return true if the Membership was modified
	 */
	public boolean editMembership(String[] items, int index) {
		boolean noItems = true;
		for (int i = 0; i < items.length; i++ ) {
			if(!items[i].equals("")) { noItems = false; }
		}
		if (index == 0) {
			return false; //Can't remove Manager
		}
		else {
			allMemberships.remove(index);
			if (!noItems) {
				Membership editMem = new Membership(items[0], items[1], items[2]);
				allMemberships.add(index, editMem);
			}
			return true;
		}
	}
	
	/**
	 * get all types of Memberships (types will not be distinct)
	 * @return a LinkedList of Types as Stings
	 */
	public LinkedList<String> getTypes() {
		LinkedList<String> list = new LinkedList<String>();
		allMemberships.forEach(mem -> list.add(mem.getType()));
		return list;
	}
	
	/**
	 * get all plans of Memberships (plans will not be distinct)
	 * @return a LinkedList of Plans as Stings
	 */
	public LinkedList<String> getPlans() {
		LinkedList<String> list = new LinkedList<String>();
		allMemberships.forEach(mem -> list.add(mem.getPlan()));
		return list;	
	}
	
	/**
	 * get all cost of Memberships (cost will not be distinct)
	 * @return a LinkedList of Cost as Stings
	 */
	public LinkedList<String> getCost() {
		LinkedList<String> list = new LinkedList<String>();
		allMemberships.forEach(mem -> list.add(mem.getCost()));
		return list;
	}
	
	/**
	 * adds a Membership to AllMemberships
	 * @param M the Membership that will be added to AllMemberships
	 * @postcondition AllMemberships will have 1 more Membership 
	 */
	public void addMembership(Membership M) {
		allMemberships.add(M);
	}
	
	/**
	 * remove a Membership in AllMemberships
	 * @param index of the Membership that will be removed from AllMemberships
	 * @postcondition AllMemberships will contain 1 less Membership 
	 */
	public void removeMembership(int index) {
		allMemberships.remove(index);
	}
}
