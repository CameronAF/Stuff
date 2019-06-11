package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Class LoginView that extends JPanel 
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class LoginView extends JPanel{
	private JTextField field_Username = new JTextField("Username", 15);
	private JPasswordField field_Password = new JPasswordField();
	private JButton btn_LogIn = new JButton("Log In"); 
	private JButton btn_SignUp = new JButton("Sign Up"); 

	/**
	 * Constructor for class LoginView
	 * @postcondition a instance of LoginView would have been initialized
	 */
	public LoginView() {
		JLabel text_Username = new JLabel("Username: ");
		JLabel text_Passward = new JLabel("Passward: ");
		JPanel pnl_Text = new JPanel();
		pnl_Text.setLayout(new BoxLayout(pnl_Text, BoxLayout.Y_AXIS));
		JPanel pnl_Input = new JPanel();
		pnl_Input.setLayout(new BoxLayout(pnl_Input, BoxLayout.Y_AXIS));
		JPanel pnl_LoginStuff = new JPanel();
		JPanel pnl_Buttons = new JPanel();
		
		pnl_Text.add(text_Username);
		pnl_Text.add(text_Passward);
		pnl_Input.add(field_Username);
		pnl_Input.add(field_Password);
		pnl_Buttons.add(btn_LogIn);
		pnl_Buttons.add(btn_SignUp);
		pnl_LoginStuff.add(pnl_Text);
		pnl_LoginStuff.add(pnl_Input);
		this.setLayout(new GridBagLayout());
		this.add(pnl_LoginStuff);
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridy = 2;
		this.add(pnl_Buttons, gridConstraints);
	}
	
	/**Add action listener to Login Button
	 * @param al ActionListener to be added to button
	 * @postcondition Event will Execute when button is pressed */
	public void add_btn_LogInAction (ActionListener al) {
		btn_LogIn.addActionListener(al);
	}
	
	/**Add action listener to SignUp Button
	 * @param al ActionListener to be added to button
	 * @postcondition Event will Execute when button is pressed */
	public void add_btn_SignUpAction (ActionListener al) {
		btn_SignUp.addActionListener(al);
	}
	
	/**Get Methods value in Username field
	 * @return a String value of Username text  */
	public String getUsername() {
		return field_Username.getText();
	}
	
	/**Get Methods value in Password field
	 * @return a char value of Password text  */
	public char[] getPassword() {
		return field_Password.getPassword();
	}
}
