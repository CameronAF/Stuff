package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableModel;

/**
* Class ServicesView that extends JPanel 
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class ServicesView extends JPanel {
	private static final String[] myServicesHeader = {"Service","Type","Time", "Day","Action"};
	private static final String[] allClassesHeader = {"Name","Instructor","Time","Day","Action"};
	private static final Object[][] empty = {{"","","","",""}};
	private JTable tbl_MyServices;
	private JTable tbl_AllClasses;
	
	/**
	*  Constructor for class ServicesView
	*  @postcondition a instance of ServicesView would have been initialized with blank table
	*/
	public ServicesView() {
		tbl_MyServices = new JTable(empty, myServicesHeader);
		tbl_AllClasses = new JTable(empty, allClassesHeader);
		JScrollPane scroll_myServices = new JScrollPane(tbl_MyServices);
		JScrollPane scroll_AllClasses = new JScrollPane(tbl_AllClasses);
		JPanel wrap = new JPanel();
		wrap.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		wrap.add(new JLabel("My Services"), gbc);
		gbc.gridy = 2;
		wrap.add(scroll_myServices, gbc);
		gbc.gridy = 3;
		wrap.add(new JLabel("All Services"), gbc);
		gbc.gridy = 4;
		wrap.add(scroll_AllClasses, gbc);
		JScrollPane scroll_wrap = new JScrollPane(wrap);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(scroll_wrap);
	}
}