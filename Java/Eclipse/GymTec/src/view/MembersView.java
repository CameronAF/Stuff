package view;

import java.awt.*;
import javax.swing.*;

/**
* Class MembersView that extends JPanel 
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class MembersView extends JPanel {
	private static final String[] allMembersHeader = {"Type","Plan", "Cost","Action"};
	private static final Object[][] empty = {{"","","",""}};
	private JTable tbl_Members;
	
	/**
	*  Constructor for class MembersView
	*  @postcondition a instance of MembersView would have been initialized with blank table
	*/
	public MembersView() {
		tbl_Members = new JTable(empty, allMembersHeader);
		JScrollPane scroll_Members = new JScrollPane(tbl_Members);
		JPanel wrap = new JPanel();
		wrap.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		wrap.add(new JLabel("Members"), gbc);
		gbc.gridy = 2;
		wrap.add(scroll_Members, gbc);
		JScrollPane scroll_wrap = new JScrollPane(wrap);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(scroll_wrap);
	}
}
