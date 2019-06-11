package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
* Class Menu that extends JPanel 
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class Menu extends JPanel{
	private JButton btn_Logout = new JButton("Log Out");
	private JButton btn_Account = new JButton("Account");
	private JButton btn_Services = new JButton("Services");
	private JButton btn_Membership = new JButton("Membership");
	private JButton btn_Members = new JButton("Members");
	
	/**
	*  Constructor for class Menu
	*  @postcondition a instance of Menu would have been initialized
	*/
	public Menu() {
		JPanel wrap = new JPanel();
		wrap.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		wrap.add(btn_Logout, gbc);
		gbc.gridy = 2;
		wrap.add(btn_Account, gbc);
		gbc.gridy = 3;
		wrap.add(btn_Services, gbc);
		gbc.gridy = 4;
		wrap.add(btn_Membership, gbc);
		gbc.gridy = 5;
		wrap.add(btn_Members, gbc);
		this.add(wrap);
	}
	
	/**Add action listener to Logout Button
	*  @postcondition Event will Execute when button is pressed */
	public void setLogoutLisneners(ActionListener al) { btn_Logout.addActionListener(al); }
	/**Add action listener to Account Button
	*  @postcondition Event will Execute when button is pressed */
	public void setAccountLisneners(ActionListener al) { btn_Account.addActionListener(al); }
	/**Add action listener to Services Button
	*  @postcondition Event will Execute when button is pressed */
	public void setServicesLisneners(ActionListener al) { btn_Services.addActionListener(al); }
	/**Add action listener to Membership Button
	*  @postcondition Event will Execute when button is pressed */
	public void setMembershipLisneners(ActionListener al) { btn_Membership.addActionListener(al); }
	/**Add action listener to Members Button
	*  @postcondition Event will Execute when button is pressed */
	public void setMembersLisneners(ActionListener al) { btn_Members.addActionListener(al); }
	
	/**hide buttons that are to be seen my managers
	*  @postcondition hides some buttons */
	public void hideManagerButtons() {
		btn_Membership.setVisible(false);
		btn_Members.setVisible(false);
	}
}