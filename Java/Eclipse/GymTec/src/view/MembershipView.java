package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
import model.ButtonEditor;
import model.ButtonRenderer;

/**
* Class MembershipView that extends JPanel 
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class MembershipView extends JPanel {
	private DefaultTableModel model = new DefaultTableModel();
	private JTable tbl_MembershipOptions;
	private ButtonEditor BE = new ButtonEditor(new JCheckBox());
	
	/**
	*  Constructor for class MembershipView
	*  @postcondition a instance of MembershipView would have been initialized with blank table
	*/
	public MembershipView() {
		drawTable();
	}
	
	/**Fills table will given list of Objects and header
	*  @postcondition Table in JPanel will be populated and redrawn */
	public void fillTable(Object[][] list, Object[] header) {
		model = new DefaultTableModel();
		for (int i = 0; i < header.length; i++ ) {
			model.addColumn(header[i]);
		}
		for (int i = 0; i < list.length; i++ ) {
			model.addRow(list[i]);
		}
		String[] blank = new String[header.length];
		for (int i = 0; i < header.length-1; i++ ) {
			blank[i] = "[BLANK]";
		}
		blank[header.length-1] = "Save";
		model.addRow(blank);
		drawTable();
		addButtons();
	}
	
	/**Draw the table with buttons
	*  @postcondition table will be drawn*/
	private void drawTable() {
		this.removeAll();
		tbl_MembershipOptions = new JTable(model);
		TableColumnModel cModel = tbl_MembershipOptions.getColumnModel();
		boolean found = false;
		for (int index = 0; index < cModel.getColumnCount(); index++) {
		    if (cModel.getColumn(index).getIdentifier().equals("Action")) {
		        found = true;
		        break;
		    }            
		}
		if (found) {
			addButtons();
		}
		JScrollPane scroll_MembershipOptions = new JScrollPane(tbl_MembershipOptions);
		JPanel wrap = new JPanel();
		wrap.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		wrap.add(new JLabel("Membership Options"), gbc);
		gbc.gridy = 2;
		wrap.add(scroll_MembershipOptions, gbc);
		JScrollPane scroll_wrap = new JScrollPane(wrap);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(scroll_wrap);
	}
	
	/**Add buttons to the table cell "Action"
	*  @postcondition buttons will be in the table*/
	public void addButtons() {
		tbl_MembershipOptions.getColumn("Action").setCellRenderer(new ButtonRenderer());
		tbl_MembershipOptions.getColumn("Action").setCellEditor(BE);
	}
	
	/**Add action listener to the cell Buttons
	*  @postcondition Event will Execute when button is pressed */
	public void addButtonsListener(ActionListener al) {
		BE.addListener(al);
	}
	
	/**Get row associated with button
	*  @return a String value of Row  */
	public String[] getBtnItems() {
		return BE.getItems();
	}
	
	/**Get the index of the row associated with button
	*  @return a index of row  */
	public int getBtnIndex() {
		return BE.getIndex();
	}
}
