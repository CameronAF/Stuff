package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

/**
* Class LoginControl that acts as controller between LoginView and models
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class LoginControl {
	private LoginView view;
	private static AllUsers users = AllUsers.getInstance();

	/**
	*  Constructor for class LoginControl
	*  @param v the JPanel to be controlled
	*  @postcondition a instance of LoginControl would have been initialized and view will be set to Frame
	*/
	public LoginControl(LoginView v) {
		view = v;
		view.add_btn_LogInAction(new btn_LogInPress());
		view.add_btn_SignUpAction(new btn_SignUpPress());
		SingleFrame.getFrame().addViewToBlankFrame(view);
	}
	
	/**class btn_LogInPress that implements ActionListener to be used by Login button
	 * @precondition Button must be initialized be for use 
	 * @postcondition user will be logged into the system or display fail login */
	class btn_LogInPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			User user = users.getUser(view.getUsername(), view.getPassword());
			if (user == null) {
				MessageBox.infoBox("Incorrect username or password", "login failed");
				return;
			}
			else {
				MainSession.logIn(user);
				AccountView accountView = new AccountView();
				AccountControl accountControl = new AccountControl(accountView);
			}
		}	
	}
	
	/**class btn_SignUpPress that implements ActionListener to be used by SignUp button
	 * @precondition Button must be initialized be for use 
	 * @postcondition User will be brought to a Account form to make an account */
	class btn_SignUpPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AccountView accountView = new AccountView();
			AccountControl accountControl = new AccountControl(accountView);
		}
	}
}