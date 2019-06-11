package model;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Singleton Class AllUsers that is Serializable and an Observer (Observer Patter)
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class AllUsers implements Serializable, Observer {
	private static AllUsers allUsersClass = null;
	private static LinkedList<User> allUsers = new LinkedList<User>();
	
	/**
	 * Constructor for class AllUsers
	 * @postcondition a instance of AllUsers would have been initialized
	 */
	private AllUsers() {
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(this.getClass().getSimpleName()+".dat"));
			allUsers = (LinkedList<User>) in.readObject();	
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
	 * Save the instance of this class as a .dat file in project loaction
	 * @postcondition this instance will be saved 
	 */
	public void saveClass() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(this.getClass().getSimpleName()+".dat"));
			out.writeObject(allUsers);
			out.close();
		}
		catch (IOException e) {
			// don't know what happened
			e.printStackTrace();
		}
	}
	
	/**
	 * Get private static instance of AllServices (Singleton pattern)
	 * @return a static instance of AllServices will be passes 
	 */
	public static AllUsers getInstance() {
		if (allUsersClass == null)  {
			allUsersClass = new AllUsers();
		}
		return allUsersClass;
	}
	
	/**
	 * checks if email  is available or already in used by another user.
	 * @return true if email is available
	 */
	public boolean isEmailAvalable(String email) {
		Iterator<User> users = allUsers.iterator();
		while(users.hasNext()) {
			User user = (User) users.next();
			if (user.getEmail().equals(email))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * get a user from AllUser with a specific email
	 * @param username the email of the user to be retrieved 
	 * @param pw the password of the user to be retrieved 
	 * @return instance of user that matches the given paramaters 
	 */
	public User getUser(String username, char[] pw) {
		if (allUsers == null || allUsers.size() == 0) {
			return null;
		}
		return allUsers.stream()
				.filter(user -> user.verifyLogin(username, pw))
		        .findFirst().orElse(null);
	}
	
	/**
	 * checks if AllUsers is empty or not
	 * @return returns true if All Users is empty
	 */
	public boolean isEmpty() {
		return allUsers.isEmpty();
	}
	
	/**
	 * adds a user to all Users
	 * @param u the User that will be added to AllUsers
	 * @postcondition AllUsers will have 1 more User 
	 */
	public void addUser(User u) {
		allUsers.add(u);
	}
}
