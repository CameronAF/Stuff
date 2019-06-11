package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.States;

/**
* Class AccountView that extends JPanel 
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class AccountView extends JPanel {
	private JButton btn_EditPersonal = new JButton("Edit");
	private JButton btn_CancelPersonal = new JButton("Cancel");
	private JButton btn_SavePersonal = new JButton("Save");
	private JTextField field_FirstName = new JTextField("First", 10);
	private JTextField field_LastName = new JTextField("Last", 10);
	private JTextField field_Email = new JTextField("Email", 10);
	private JTextField field_Phone = new JTextField("Phone", 10);
	private JTextField field_Address = new JTextField("Address", 10);
	private JTextField field_City = new JTextField("City", 10);
	private JComboBox<?> field_State = new JComboBox(States.values());
	private JTextField field_Zip = new JTextField("Zip", 10);
	private JButton btn_EditMembership = new JButton("Edit");
	private JButton btn_CancelMembership = new JButton("Cancel");
	private JButton btn_SaveMembership = new JButton("Save");
	private JPasswordField field_password1 = new JPasswordField(10);
	private JPasswordField field_password2 = new JPasswordField(10);
	private JButton btn_EditPassword = new JButton("Edit");
	private JButton btn_CancelPassword= new JButton("Cancel");
	private JButton btn_SavePassword = new JButton("Save");
	private JComboBox<String> field_Type = new JComboBox<String>();
	private JComboBox<String> field_Plan = new JComboBox<String>();
	private JComboBox<String> field_Cost = new JComboBox<String>();
	private JButton btn_SaveMember = new JButton("Save");
	private JButton btn_CancelMember = new JButton("Cancel");
	
	/**
	*  Constructor for class AccountView
	*  @precondition none
	*  @postcondition a instance of AccountView would have been initialized with blank form fields
	*/
	public AccountView() {
		JPanel wrap = new JPanel();
		wrap.setLayout(new GridBagLayout());
		//Personal info section
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 4;
		wrap.add(new JLabel("Personal Information"), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 5;
		wrap.add(btn_SavePersonal, gbc);
		gbc.gridx = 6;
		wrap.add(btn_CancelPersonal, gbc);
		wrap.add(btn_EditPersonal, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		wrap.add(new JLabel("First Name: "), gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		wrap.add(field_FirstName, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 4;
		wrap.add(new JLabel("Last Name: "), gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 5;
		wrap.add(field_LastName, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 3;
		wrap.add(new JLabel("Email: "), gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		wrap.add(field_Email, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 4;
		wrap.add(new JLabel("Phone: "), gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 5;
		wrap.add(field_Phone, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 4;
		wrap.add(new JLabel("Address: "), gbc);
		gbc.gridwidth = 5;
		gbc.gridx = 2;
		wrap.add(field_Address, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 5;
		wrap.add(new JLabel("City: "), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		wrap.add(field_City, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 3;
		wrap.add(new JLabel("State: "), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 4;
		wrap.add(field_State, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 5;
		wrap.add(new JLabel("Zip: "), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 6;
		wrap.add(field_Zip, gbc);
		// Password section
		gbc.gridwidth = 4;
		gbc.gridx = 1;
		gbc.gridy = 7;
		wrap.add(new JLabel("Change Password"), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 5;
		wrap.add(btn_SavePassword, gbc);
		gbc.gridx = 6;
		wrap.add(btn_CancelPassword, gbc);
		wrap.add(btn_EditPassword, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 8;
		wrap.add(new JLabel("Password: "), gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		wrap.add(field_password1, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 4;
		wrap.add(new JLabel("Confirm Password: "), gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 5;
		wrap.add(field_password2, gbc);
		// Membership Section
		gbc.gridwidth = 4;
		gbc.gridx = 1;
		gbc.gridy = 10;
		wrap.add(new JLabel("Membership Information"), gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 5;
		wrap.add(btn_SaveMembership, gbc);
		gbc.gridx = 6;
		wrap.add(btn_CancelMembership, gbc);
		wrap.add(btn_EditMembership, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 11;
		wrap.add(new JLabel("Type: "), gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		wrap.add(field_Type, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 12;
		wrap.add(new JLabel("Plan: "), gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		wrap.add(field_Plan, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 13;
		wrap.add(new JLabel("Cost: "), gbc);
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		wrap.add(field_Cost, gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 3;
		gbc.gridy = 14;
		wrap.add(btn_SaveMember, gbc);
		gbc.gridx = 4;
		wrap.add(btn_CancelMember, gbc);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(wrap);
		field_Type.setEnabled(false);
		field_Cost.setEnabled(false);
		btn_CancelPersonal.setVisible(false);
		btn_SavePersonal.setVisible(false);
		btn_CancelPassword.setVisible(false);
		btn_SavePassword.setVisible(false);
		btn_CancelMembership.setVisible(false);
		btn_SaveMembership.setVisible(false);
	}

	/**Get Methods value in FirstName field
	*  @return a String value of FirstName text */
	public String getfield_FirstNameValue() { return field_FirstName.getText(); }
	/**Get Methods value in LastName field
	*  @return a String value of LastName text  */
	public String getfield_LastNameValue() { return field_LastName.getText(); }
	/**Get Methods value in Email field
	*  @return a String value of Email text  */
	public String getfield_EmailValue() { return field_Email.getText(); }
	/**Get Methods value in Phone field
	*  @return a String value of Phone text  */
	public String getfield_PhoneValue() { return field_Phone.getText(); }
	/**Get Methods value in Address field
	*  @return a String value of Address text  */
	public String getfield_AddressValue() { return field_Address.getText(); }
	/**Get Methods value in City field
	*  @return a String value of City text  */
	public String getfield_CityValue() { return field_City.getText(); }
	/**Get Methods value in State field
	*  @return a State value of selected State  */
	public States getfield_StateValue() { return (States) field_State.getSelectedItem(); }
	/**Get Methods value in Zip field
	*  @return a String value of Zip text  */
	public String getfield_ZipValue() { return field_Zip.getText(); }
	/**Get Methods value in Password1 field
	*  @return a Char value of Password1 text  */
	public char[] getfield_password1Value() { return field_password1.getPassword(); }
	/**Get Methods value in Password2 field
	*  @return a Char value of Password2 text  */
	public char[] getfield_password2Value() { return field_password2.getPassword(); }
	/**Get Methods value in Membership Type field
	*  @return a String value of Membership Type text  */
	public String getfield_TypeValue() { return (String) field_Type.getSelectedItem(); }
	/**Get Methods value in Membership Plan field
	*  @return a String value of Membership Plan text  */
	public String getfield_PlanValue() { return (String) field_Plan.getSelectedItem(); }
	
	/**Set Method that sets a given string value to field FirstName
	*  @postcondition field FirstName will have text set  */
	public void setfield_FirstNameValue(String value) { field_FirstName.setText(value); }
	/**Set Method that sets a given string value to field LastName
	*  @postcondition field LastName will have text set  */
	public void setfield_LastNameValue(String value) { field_LastName.setText(value); }
	/**Set Method that sets a given string value to field Email
	*  @postcondition field Email will have text set  */
	public void setfield_EmailValue(String value) { field_Email.setText(value); }
	/**Set Method that sets a given string value to field Phone
	*  @postcondition field Phone will have text set  */
	public void setfield_PhoneValue(String value) { field_Phone.setText(value); }
	/**Set Method that sets a given string value to field Address
	*  @postcondition field Address will have text set  */
	public void setfield_AddressValue(String value) { field_Address.setText(value); }
	/**Set Method that sets a given string value to field City
	*  @postcondition field City will have text set  */
	public void setfield_CityValue(String value) { field_City.setText(value); }
	/**Set Method that sets a given State value as selected
	*  @postcondition field State will be selected  */
	public void setfield_StateValue(States value) { field_State.setSelectedItem(value); }
	/**Set Method that sets a given string value to field Zip
	*  @postcondition field Zip will have text set  */
	public void setfield_ZipValue(String value) { field_Zip.setText(value); }
	/**Set Method that sets a given string value as selected
	*  @postcondition field Membership Type of value will be selected  */
	public void setfield_TypeValue(String value) { field_Type.setSelectedItem(value); }
	/**Set Method that sets a given string value as selected
	*  @postcondition field Membership Plan of value will be selected  */
	public void setfield_PlanValue(String value) { field_Plan.setSelectedItem(value); }
	/**Set Method that sets a given string value as selected
	*  @postcondition field Membership Cost of value will be selected  */
	public void setfield_CostValue(String value) { field_Cost.setSelectedItem(value); }
	/**Set Method that sets a given index value as selected
	*  @postcondition field Membership Type at index will be selected  */
	public void setfield_TypeValue(int index) { field_Type.setSelectedIndex(index); }
	/**Set Method that sets a given index value as selected
	*  @postcondition field Membership PLan at index will be selected  */
	public void setfield_PlanValue(int index) { field_Plan.setSelectedIndex(index); }
	/**Set Method that sets a given index value as selected
	*  @postcondition field Membership Cost at index will be selected  */
	public void setfield_CostValue(int index) { field_Cost.setSelectedIndex(index); }
	
	/**Add String value to field Type ComboBox
	*  @postcondition field Membership Type will have added string value  */
	public void addfield_TypeValue(String value) { field_Type.addItem(value); }
	/**Add String value to field Plan ComboBox
	*  @postcondition field Membership Plan will have added string value  */
	public void addfield_PlanValue(String value) { field_Plan.addItem(value); }
	/**Add String value to field Cost ComboBox
	*  @postcondition field Membership Cost will have added string value  */
	public void addfield_CostValue(String value) { field_Cost.addItem(value); }

	/**Add action listener to field Membership Plan
	*  @postcondition Event will Execute when action occurs */
	public void setfield_PlanLisneners(ActionListener al) { field_Plan.addActionListener(al); }
	/**Add action listener to Edit Personal info Button
	*  @postcondition Event will Execute when action occurs */
	public void setEditPersonalLisneners(ActionListener al) { btn_EditPersonal.addActionListener(al); }
	/**Add action listener to Save Personal infoButton
	*  @postcondition Event will Execute when action occurs */
	public void setSavePersonalLisneners(ActionListener al) { btn_SavePersonal.addActionListener(al); }
	/**Add action listener to Edit Password Button
	*  @postcondition Event will Execute when action occurs */
	public void setEditPasswordLisneners(ActionListener al) { btn_EditPassword.addActionListener(al); }
	/**Add action listener to Save Password Button
	*  @postcondition Event will Execute when action occurs */
	public void setSavePasswordLisneners(ActionListener al) { btn_SavePassword.addActionListener(al); }
	/**Add action listener to Edit Membership Button
	*  @postcondition Event will Execute when action occurs */
	public void setEditMembershipLisneners(ActionListener al) { btn_EditMembership.addActionListener(al); }
	/**Add action listener to Save Membership Button
	*  @postcondition Event will Execute when action occurs */
	public void setSaveMembershipLisneners(ActionListener al) { btn_SaveMembership.addActionListener(al); }
	/**Add action listener to Cancel Button
	*  @postcondition Event will Execute when action occurs */
	public void setCancelMemberLisneners(ActionListener al) { btn_CancelMember.addActionListener(al); }
	/**Add action listener to Save new member Button
	*  @postcondition Event will Execute when action occurs */
	public void setSaveMemberLisneners(ActionListener al) { btn_SaveMember.addActionListener(al); }
	/**Add action listener to Cancel new member Button
	*  @postcondition Event will Execute when action occurs */
	public void setCancelLisneners(ActionListener al) { 
		btn_CancelPersonal.addActionListener(al);
		btn_CancelPassword.addActionListener(al);
		btn_CancelMembership.addActionListener(al); 
	}
	
	/**Change buttons that are visible to a user for a new user
	*  @postcondition some buttons will be visible and some will be invisible */
	public void newUser() {
		btn_EditPersonal.setVisible(false);
		btn_EditPassword.setVisible(false);
		btn_EditMembership.setVisible(false);
		btn_SaveMember.setVisible(true);
		btn_CancelMember.setVisible(true);
	}
	
	/**Hide buttons that are only needed for new users
	*  @postcondition new user buttons are hidden*/
	public void hideNewUserButtons() {
		btn_SaveMember.setVisible(false);
		btn_CancelMember.setVisible(false);
	}
	
	/**set the setEnabled property for field Membership Plan
	*  @postcondition field Membership Plan will be usable or disabled*/
	public void setfield_PlanEnabled(boolean b) {
		field_Plan.setEnabled(b);
	}
	
	/**Allow Personal information fields to be edited and saved.
	*  @postcondition some feild types will be usable */
	public void enablePersonal() {
		field_FirstName.setEnabled(true);
		field_LastName.setEnabled(true);
		field_Phone.setEnabled(true);
		field_Address.setEnabled(true);
		field_City.setEnabled(true);
		field_State.setEnabled(true);
		field_Zip.setEnabled(true);
		btn_EditPersonal.setVisible(false);
		btn_CancelPersonal.setVisible(true);
		btn_SavePersonal.setVisible(true);
	}
	
	/**Allow Password information fields to be edited and saved.
	*  @postcondition some field types will be usable */
	public void enablePassword() {
		field_password1.setEnabled(true);
		field_password2.setEnabled(true);
		btn_EditPassword.setVisible(false);
		btn_CancelPassword.setVisible(true);
		btn_SavePassword.setVisible(true);
	}
	
	/**Allow Membership information fields to be edited and saved.
	*  @postcondition some field types will be usable */
	public void enableMembership() {
		field_Plan.setEnabled(true);
		btn_EditMembership.setVisible(false);
		btn_CancelMembership.setVisible(true);
		btn_SaveMembership.setVisible(true);
	}
	
	/**Disable use of Membership section
	*  @postcondition Membership Section will be for display only */
	public void disableMembership() {
		field_Plan.setEnabled(false);
		btn_EditMembership.setVisible(false);
		btn_CancelMembership.setVisible(false);
		btn_SaveMembership.setVisible(false);
	}
	
	/**disable use from all field types
	*  @postcondition no fields will be editable */
	public void exitEdit() {
		field_FirstName.setEnabled(false);
		field_LastName.setEnabled(false);
		field_Email.setEnabled(false);
		field_Phone.setEnabled(false);
		field_Address.setEnabled(false);
		field_City.setEnabled(false);
		field_State.setEnabled(false);
		field_Zip.setEnabled(false);
		field_password1.setEnabled(false);
		field_password2.setEnabled(false);
		field_Plan.setEnabled(false);
		btn_EditPersonal.setVisible(true);
		btn_CancelPersonal.setVisible(false);
		btn_SavePersonal.setVisible(false);
		btn_EditMembership.setVisible(true);
		btn_CancelMembership.setVisible(false);
		btn_SaveMembership.setVisible(false);
		btn_EditPassword.setVisible(true);
		btn_CancelPassword.setVisible(false);
		btn_SavePassword.setVisible(false);
	}
}