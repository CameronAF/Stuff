package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.User;
import view.*;

/**
* Class MenuControl that acts as controller between Menu and models
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class MenuControl {
	private Menu view;
	private User user = MainSession.getSessionUser();
	private SingleFrame frame = SingleFrame.getFrame();
	
	/**
	*  Constructor for class MenuControl
	*  @param view the JPanel to be controlled
	*  @postcondition a instance of MenuControl would have been initialized and view will be added to Frame
	*/
	public MenuControl(Menu v) {
		view = v;
		if (!(user.getMembership().getPlan().equals("Manager"))) {
			view.hideManagerButtons();
			frame.addMenuToBlankFrame(v);
		}
		view.setLogoutLisneners(new btn_LogoutPress());
		view.setAccountLisneners(new btn_AccountPress());
		view.setServicesLisneners(new btn_ServicesPress()); 
		view.setMembershipLisneners(new btn_MembershipPress());
		view.setMembersLisneners(new btn_MembersPress());
	}
	
	// Button ActionListeners
	/**class btn_LogoutPress that implements ActionListener to be used by Logout button
	 * @precondition Button must be initialized be for use */
	class btn_LogoutPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainSession.logOut();
			LoginView view = new LoginView();
			LoginControl lControl = new LoginControl(view);
			frame.addViewToBlankFrame(view);
		}	
	}
	
	/**class btn_AccountPress that implements ActionListener to be used by Account button
	 * @precondition Button must be initialized be for use */
	class btn_AccountPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AccountView view = new AccountView();
			AccountControl aControl = new AccountControl(view);
			frame.addView(view);
		}	
	}
	
	/**class btn_ServicesPress that implements ActionListener to be used by Services button
	 * @precondition Button must be initialized be for use */
	class btn_ServicesPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ServicesView view = new ServicesView();
			ServicesControl sControl = new ServicesControl(view);
			frame.addView(view);
		}	
	}
	
	/**class btn_MembershipPress that implements ActionListener to be used by Memberships button
	 * @precondition Button must be initialized be for use */
	class btn_MembershipPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MembershipView view = new MembershipView();
			MembershipControl mControl = new MembershipControl(view);
			frame.addView(view);
		}	
	}
	
	/**class btn_MembersPress that implements ActionListener to be used by Members button
	 * @precondition Button must be initialized be for use */
	class btn_MembersPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MembersView view = new MembersView();
			MembersControl mControl = new MembersControl(view);
			frame.addView(view);
		}	
	}
}
