package model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
/**
 * Class LoginView that extends JPanel 
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class ButtonEditor extends DefaultCellEditor {
	protected JButton button;
	private String label;
	private boolean isPushed;
	private String[] items;
	private int index;
  
	/**
	 * Constructor for class LoginView
	 * @postcondition a instance of LoginView would have been initialized
	 */
	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
	}
  
	public Component getTableCellEditorComponent(JTable table, Object value,
                   	boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else{
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value ==null) ? "" : value.toString();
		isPushed = true;
		items = new String[column];
		index = row;
		for (int i = 0; i < column; i++) {
			items[i] = table.getModel().getValueAt(row, i).toString();
		}
		return button;
	} 

	public Object getCellEditorValue() {
		isPushed = false;
		return new String( label ) ;
	}
  
	/**
	 * add action listener to the button
	 * @param al is an ActionListener to be added to the button
	 * @postcondition button will have an action listener
	 */
	public void addListener(ActionListener al) {
		button.addActionListener(al);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}
	
	/**
	 * get the items in the row of the button
	 * @return Items of row that button is part of
	 */
	public String[] getItems() {
		return items;
	}
	
	/**
	 * get the row index of the button in the table
	 * @return index of row that button is part of
	 */
	public int getIndex() {
		return index;
	}
  
	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}
  
	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}