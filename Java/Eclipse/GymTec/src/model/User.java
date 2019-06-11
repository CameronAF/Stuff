package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Class User that is Serializable
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class User implements Serializable {
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private char[] password;
	private String address;
	private String city;
	private States state;
	private String zip;
	private Membership membershipStatus;
	private LinkedList<Service> myServices;
	
	/**
	 * Constructor for class LoginView
	 * @postcondition a instance of LoginView would have been initialized
	 */
	public User() {}
	
	/**Get firstName from User
	 * @return Type value of String type  */
	public String getFirstName() { return firstName; }
	/**Get lastName from User
	 * @return lastName value of String type  */
	public String getLastName() { return lastName; }
	/**Get phone from User
	 * @return phone value of String type  */
	public String getPhone() { return phone; }
	/**Get email from User
	 * @return email value of String type  */
	public String getEmail() { return email; }
	/**Get address from User
	 * @return address value of String type  */
	public String getAddress() { return address; }
	/**Get city from User
	 * @return city value of String type  */
	public String getCity() { return city; }
	/**Get state from User
	 * @return state value of States type  */
	public States getState() { return state; }
	/**Get zip from User
	 * @return zip value of String type  */
	public String getZip() { return zip; }
	/**Get membershipStatus from User
	 * @return membershipStatus value of Membership type  */
	public Membership getMembership() { return membershipStatus; }
	/**Get myServices from User
	 * @return get a linkedList of Services  */
	public LinkedList<Service> getServices() { return myServices; }
	
	/**set the value of firstName to temp String
	 * @param temp is string value to be set in firstName
	 * @postcondition FirstName will contain new value  */
	public void setFirstName(String temp) { firstName = temp; }
	/**set the value of lastName to temp String
	 * @param temp is string value to be set in lastName
	 * @postcondition lastName will contain new value  */
	public void setLastName(String temp) { lastName = temp; }
	/**set the value of phone to temp String
	 * @param temp is string value to be set in phone
	 * @postcondition phone will contain new value  */
	public void setPhone(String temp) { phone = temp; }
	/**set the value of email to temp String
	 * @param temp is string value to be set in email
	 * @postcondition email will contain new value  */
	public void setEmail(String temp) { email = temp; }
	/**set the value of password to temp char
	 * @param temp is char value to be set in password
	 * @postcondition password will contain new value  */
	public void setPassword(char[] temp) { password = temp; }
	/**set the value of char to temp String
	 * @param temp is string value to be set in char
	 * @postcondition char will contain new value  */
	public void setAddress(String temp) { address = temp; }
	/**set the value of city to temp String
	 * @param temp is string value to be set in city
	 * @postcondition city will contain new value  */
	public void setCity(String temp) { city = temp; }
	/**set the value of state to temp States
	 * @param temp is States value to be set in state
	 * @postcondition state will contain new value  */
	public void setState(States temp) { state = temp; }
	/**set the value of zip to temp String
	 * @param temp is string value to be set in zip
	 * @postcondition zip will contain new value  */
	public void setZip(String temp) { zip = temp; }
	/**set the value of membershipStatus to temp Membership
	 * @param temp is Membership value to be set in membershipStatus
	 * @postcondition membershipStatus will contain new value  */
	public void setMembership(Membership temp) { membershipStatus = temp; }
	
	/**
	 * Constructor for class LoginView
	 * @param user is checked against Email
	 * @param pw is checked against password
	 * @return true if params match Email and Password
	 */
	public boolean verifyLogin(String user, char[] pw) {
		if (user.equals(email) && Arrays.equals(pw,password)) {
			return true;
		}
		return false;
	}
}
