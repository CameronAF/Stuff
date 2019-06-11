package q4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
* Main Class that makes GUI
* @author Cameron Anzola
* @class COP5339 001
* @data 2/18/2018
*/
public class  Main {
	private final static String[] colorstr = new String[]{"GREEN", "BLUE", "RED"};
	private final static Color[] colors = new Color[]{Color.GREEN, Color.BLUE, Color.RED};
	private static JLabel label = new JLabel();
	
	/**
	*  Main method, creates GUI
	*  @precondition none
	*  @postcondition program will have executed
	*/
	public static void main(String[] args) {
		// Make Frame
		JFrame frame = new JFrame("Cicle Play");
		frame.setVisible(true);
		frame.setSize(400,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Make Circle and containers
		Circle icon = new Circle(50);
		label.setIcon(icon);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    JPanel panel = new JPanel();
	    // Add containers to grid and frame
		JPanel containerPanel = new JPanel(new GridLayout(2, 1));
		containerPanel.add(label);
		containerPanel.add(panel);
		frame.add(containerPanel, BorderLayout.NORTH);
		// Make Buttons
		JButton[] btn = new JButton[3];
		for (int i=0; i<3; i++) {
		    btn[i] = createButton(i,  colorstr[i]);
		    panel.add(btn[i]);
		}
	}
	
	/**
	*  Create a button and sets text and event listener on index.
	*  event listener changes the color of circle on click 
	*  button created is either Red, Green, or blue
	*  @precondition none 
	*  @return a instance of button with a listener that changes the color of circle
	*/
	private static JButton createButton(int index, String cs) {
		final Color c = colors[index];
		JButton btn = new JButton(cs);
		btn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   ((Circle) label.getIcon()).setColor(c);
				   label.repaint();
			   }
			});
		return btn;		
	}
}
