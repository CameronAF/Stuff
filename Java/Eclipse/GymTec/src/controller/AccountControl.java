package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JComboBox;
import model.*;
import view.*;

/**
* Class AccountControl that acts as controller between AccountView and models
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class AccountControl {
	private AccountView view;
	private User user = MainSession.getSessionUser();
	
	/**
	*  Constructor for class AccountControl
	*  @param v the JPanel to be controlled
	*  @postcondition a instance of AccountControl would have been initialized and view will be set to Frame
	*/
	public AccountControl(AccountView v) {
		view = v;
		if (user == null) {
			view.newUser();
			fillComboBoxs();
			if (AllMemberships.getInstance().getTypes().size() == 1 ||
					AllUsers.getInstance().isEmpty() ) {
				view.disableMembership();
			}
			SingleFrame.getFrame().addViewToBlankFrame(view);
		}
		else {
			fillForm();
			view.hideNewUserButtons();
			view.exitEdit();
			if (user.getMembership().getType().equals("Employee")) {
				view.disableMembership();
			}
			Menu mview = new Menu();
			MenuControl lControl = new MenuControl(mview);
			SingleFrame.getFrame().addMenuToBlankFrame(mview);
			SingleFrame.getFrame().addView(view);
		}
		view.setEditPersonalLisneners(new btn_EditPersonalPress());
		view.setSavePersonalLisneners(new btn_SavePersonalPress());
		view.setEditPasswordLisneners(new btn_EditPasswordpPress()); 
		view.setSavePasswordLisneners(new btn_SavePasswordPress());
		view.setEditMembershipLisneners(new btn_EditMembershipPress());
		view.setSaveMembershipLisneners(new btn_SaveMembershipPress());
		view.setCancelMemberLisneners(new btn_CancelMemberPress());
		view.setSaveMemberLisneners(new btn_SaveMemberPress());
		view.setCancelLisneners(new btn_CancelPress());
		view.setfield_PlanLisneners(new field_PlanChange());
	}
	
	/**
	*  Fill all field with the session users information
	*  @precondition Main User is not null
	*  @postcondition Account fields will be filled with Session User information
	*/
	public void fillForm() {
		if (user != null) {
			view.setfield_FirstNameValue(user.getFirstName());
			view.setfield_LastNameValue(user.getLastName());
			view.setfield_EmailValue(user.getEmail());
			view.setfield_PhoneValue(user.getPhone());
			view.setfield_AddressValue(user.getAddress());
			view.setfield_CityValue(user.getCity());
			view.setfield_StateValue(user.getState());
			view.setfield_ZipValue(user.getZip());
			fillComboBoxs();
			Membership userMembership = user.getMembership();
			view.setfield_TypeValue(userMembership.getType());
			view.setfield_PlanValue(userMembership.getPlan());
			view.setfield_CostValue(userMembership.getCost());
		}
	}
	
	/**
	*  Fill Membership JComboBoxes to contain options based on content of available Memberships and SessionUser 
	*  @postcondition ComboBoxes will different per user
	*/
	public void fillComboBoxs() {
		AllMemberships allMemShips = AllMemberships.getInstance();
		LinkedList<String> types = allMemShips.getTypes();
		LinkedList<String> plans = allMemShips.getPlans();
		LinkedList<String> cost = allMemShips.getCost();
		Iterator<String> plansIter = plans.iterator();
		Iterator<String> typesIter = types.iterator();
		Iterator<String> costIter = cost.iterator();
		// remove nothing if only manager, no users, or user is manager
		if(types.size() == 1 || (AllUsers.getInstance().isEmpty()) ||
				(user != null && (user.getMembership().getPlan().equals("Manager")))) {
			//force manager
		}
		// remove all managers if only Employees
		else if (types.stream().allMatch(type -> type.equals("Employee")) ||
				(user != null && (user.getMembership().getType().equals("Employee")))) {
			while(plansIter.hasNext()) {
				typesIter.next();
				costIter.next();
				if (plansIter.next().equals("Manager")) {
					typesIter.remove();
					plansIter.remove();
					costIter.remove();
				}
			}
		}
		// remove all employee types if other type
		else { 
			while(typesIter.hasNext()) {
				plansIter.next();
				costIter.next();
				String type = typesIter.next();
				if (type.equals("Employee")) {
					typesIter.remove();
					plansIter.remove();
					costIter.remove();
				}
			}
		}
		types.forEach(type -> view.addfield_TypeValue(type));
		plans.forEach(plan -> view.addfield_PlanValue(plan));
		cost.forEach(c -> view.addfield_CostValue(c)); 
	}
	
	/**
	*  check if personal info fields are properly filled out by user
	*  @return boolean representation of if Membership info is missing and a popup message if false
	*/
	public boolean validPersonal() {
		if (view.getfield_FirstNameValue() == null || (view.getfield_FirstNameValue().length() < 2)) {
			MessageBox.infoBox("Fill in First Name field", "First Name Missing");
			return false;
		}
		else if (view.getfield_LastNameValue() == null || (view.getfield_LastNameValue().length() < 2)) {
			MessageBox.infoBox("Fill in Last Name field", "Last Name Missing");
			return false;
		}
		else if (view.getfield_EmailValue() == null || !(view.getfield_EmailValue().contains("@"))) {
			MessageBox.infoBox("Use a valid Email", "Invalid Email");
			return false;
		}
		else if (view.getfield_PhoneValue() == null || (view.getfield_PhoneValue().length() < 7)) {
			MessageBox.infoBox("Use a valid Phone number", "Invalid Phone number");
			return false;
		}
		else if (view.getfield_AddressValue() == null || view.getfield_AddressValue().length() < 2) {
			MessageBox.infoBox("Fill in Address field", "Address Missing");
			return false;
		}
		else if (view.getfield_CityValue() == null || view.getfield_CityValue().length() < 2) {
			MessageBox.infoBox("Fill in City field", "City Missing");
			return false;
		}
		else if (view.getfield_StateValue() == null) {
			MessageBox.infoBox("Fill in State field", "State Missing");
			return false;
		}
		else if (view.getfield_ZipValue() == null || view.getfield_ZipValue().length() < 5) {
			MessageBox.infoBox("Fill in Zip field", "Zip Missing");
			return false;
		}
		return true;
	}
	
	/**
	*  check to insure that both password fields match 
	*  @return boolean representation of if both password fields match 
	*/
	public boolean validPassword() {
		if (Arrays.equals(view.getfield_password1Value(),view.getfield_password2Value())) {
			return true;
		}
		MessageBox.infoBox("Password fields to not match", "Password Mismatch");
		return false;
	}
	
	/**
	*  check to insure Membership info is filled out
	*  @return boolean representation of if Membership info is missing
	*/
	public boolean validMembership() {
		if (view.getfield_TypeValue() == null || view.getfield_TypeValue().equals("")) {
			MessageBox.infoBox("Fill in Missing Membership", "Membership Missing");
			return false;
		}
		else if (view.getfield_PlanValue() == null || view.getfield_PlanValue().equals("")) {
			MessageBox.infoBox("Fill in Missing Membership", "Membership Missing");
			return false;
		}
		return true;
	}
	
	/**
	*  Save personal info fields to User
	*  @precondition a user his logged into the session
	*  @postcondition Personal Info will be changed for User
	*/
	private void savePersonalData() {
		if (user != null) {
			user.setFirstName(view.getfield_FirstNameValue());
			user.setLastName(view.getfield_LastNameValue());
			user.setPhone(view.getfield_PhoneValue());
			user.setEmail(view.getfield_EmailValue());
			user.setAddress(view.getfield_AddressValue());
			user.setCity(view.getfield_CityValue());
			user.setState(view.getfield_StateValue());
			user.setZip(view.getfield_ZipValue());
		}
	}
	
	/**
	*  Save password field to User
	*  @precondition a user his logged into the session
	*  @postcondition Password will be changed for User
	*/
	private void savePasswordData() {
		if (user != null) {
			user.setPassword(view.getfield_password1Value());
		}
	}
	
	/**
	*  Save membership fields to User
	*  @precondition a user his logged into the session and a instance of Membership chosen exist
	*  @postcondition Membership will be changed for User
	*/
	private void saveMembershipData() {
		if (user != null) {
			Membership membership = AllMemberships.getInstance().getMembership(view.getfield_TypeValue(), view.getfield_PlanValue());
			if (membership != null) {
				user.setMembership(membership);
			}
		}
	}
	
	// Button ActionListeners
	/**class btn_EditPersonalPress that implements ActionListener to be used by Personal Edit button
	 * @precondition Button must be initialized be for use 
	 * @postcondition Personal Info fields will be enabled and save and cancel buttons will be visible */
	class btn_EditPersonalPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.enablePersonal();
		}	
	}
	
	/**class btn_SavePersonalPress that implements ActionListener to be used by Personal info Save button
	 * @precondition Button must be initialized be for use 
	 * @postcondition personal information changes will be saved to the user */
	class btn_SavePersonalPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (validPersonal()) {
				savePersonalData();
				view.exitEdit();
			}
		}	
	}
	
	/**class btn_EditPasswordpPress that implements ActionListener to be used by Password Edit button
	 * @precondition Button must be initialized be for use 
	 * @postcondition Password fields will be enabled and save and cancel buttons will be visible */
	class btn_EditPasswordpPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.enablePassword();
		}	
	}
	
	/**class btn_SavePasswordPress that implements ActionListener to be used by Password Save button
	 * @precondition Button must be initialized be for use 
	 * @postcondition Password changes will be saved to the user */
	class btn_SavePasswordPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (validPassword()) {
				savePasswordData();
				view.exitEdit();
			}
		}	
	}
	
	/**class btn_EditMembershipPress that implements ActionListener to be used by Membership Edit button
	 * @precondition Button must be initialized be for use 
	 * @postcondition some membership fields will be enabled and save and cancel buttons will be visible */
	class btn_EditMembershipPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.enableMembership();
		}	
	}
	
	/**class btn_SaveMembershipPress that implements ActionListener to be used by Membership Save button
	 * @precondition Button must be initialized be for use 
	 * @postcondition Membership changes will be saved to the user */
	class btn_SaveMembershipPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (validMembership()) {
				saveMembershipData();
				view.exitEdit();
			}
		}	
	}
	
	/**class btn_CancelPress that implements ActionListener to be used by any Cancel button
	 * @precondition Button must be initialized be for use 
	 * @postcondition All fields will be disabled and all buttons but edit buttons will be hidden */
	class btn_CancelPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			view.exitEdit();
			fillForm();
		}	
	}
	
	/**class btn_SaveMemberPress that implements ActionListener to be used by New Member Save button
	 * @precondition Button must be initialized be for use 
	 * @postcondition new user will be created and the user will go back to the login screen */
	class btn_SaveMemberPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (validPassword() && validPersonal() && validMembership()) {
				AllUsers users = AllUsers.getInstance();
				if (users.isEmailAvalable(view.getfield_EmailValue())) {
					user = new User();
					savePersonalData();
					savePasswordData();
					saveMembershipData();
					users.addUser(user);
					LoginView view = new LoginView();
					LoginControl lControl = new LoginControl(view);
				}
				else {
					MessageBox.infoBox("Email already in use", "Email unavailable");
				}
			}
		}	
	}
	
	/**class btn_CancelMemberPress that implements ActionListener to be used by New Member Cancel button
	 * @precondition Button must be initialized be for use 
	 * @postcondition return user to login screen  */
	class btn_CancelMemberPress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LoginView view = new LoginView();
			LoginControl lControl = new LoginControl(view);
		}	
	}
	
	/**class field_PlanChange that implements ActionListener to be used by plan field JDropBox
	 * @precondition JDropBox must be initialized be for use 
	 * @postcondition related JComboBoxs will have selected index changed to this source JComboBox */
	class field_PlanChange implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox box = (JComboBox) e.getSource();
			int index = box.getSelectedIndex();
			view.setfield_TypeValue(index);
			view.setfield_CostValue(index);
		}	
	}
}
