package view;

import javax.swing.JOptionPane;

/**
* Static class MessageBox 
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class MessageBox {
	
	/**
	*  make popup message box with selected information
	*  @postcondition a popup box will be displaced 
	*/
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
