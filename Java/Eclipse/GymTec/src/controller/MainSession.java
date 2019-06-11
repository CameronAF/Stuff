package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import model.*;
import view.*;

/**
* Class MainSession that acts as controller between SingleFrame and models
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class MainSession {
	private static MainSession mainSession = new MainSession();
	private static SingleFrame frame = SingleFrame.getFrame();
	private static AllUsers users = AllUsers.getInstance();
	private static AllMemberships memberships = AllMemberships.getInstance();
	private static AllServices services = AllServices.getInstance();
	private static User sessionUser = null;

	/**
	*  Main method where program starts
	*  @postcondition Program will have started with Main Frame displaying
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginView view = new LoginView();
		LoginControl lControl = new LoginControl(view);
		frame.addListener(new closeApp());
		frame.addObserver(users);
		frame.addObserver(memberships);
		frame.addObserver(services);
	}
	
	/**Get Main User logged into the program
	*  @return the User logged in or null if no user has logged in */
	public static User getSessionUser() {
		return sessionUser;
	}
	
	/**
	*  set the session user for the user that logged in
	*  @postcondition Session user will not be null
	*/
	public static void logIn(User user) {
		sessionUser = user;
	}
	
	/**
	*  remove the session user and set program to startup state
	*  @postcondition program will be back at startup state
	*/
	public static void logOut() {
		sessionUser = null;
		LoginView view = new LoginView();
		LoginControl lControl = new LoginControl(view);
		frame.addViewToBlankFrame(view);
	}
	
	/**class closeApp that extends WindowAdapter execute when window closes
	 * @precondition Frame is initialized
	 * @postcondition user can exit window and data models will be saved */
	public static class closeApp extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			SingleFrame frm = (SingleFrame) e.getSource();
			frm.notifyObserver();
		}
	}
}