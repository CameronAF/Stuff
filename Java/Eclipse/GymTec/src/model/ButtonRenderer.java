package model;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
  
/**
 * Class ButtonRenderer that extends JButton and implements TableCellRenderer  
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {
  
	/**
	 * Constructor for class ButtonRenderer
	 * @postcondition a instance of ButtonRenderer would have been initialized
	 */
	public ButtonRenderer() {
		setOpaque(true);
	}
   
	public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else{
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		setText( (value ==null) ? "" : value.toString() );
		return this;
	}
}