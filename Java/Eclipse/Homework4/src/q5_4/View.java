package q5_4;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import q5_4.Controller.SliderListener;

/**
 * Class View that extends JFrame. 
 * Starts program with Main
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/25/2018
 */
public class View extends JFrame {
	// private attributes
    private Slider slider1;
    private Slider slider2;
    private Slider slider3;
    private Circle icon1;
    private JLabel label1;
  
    /**
	*  Constructor for class View.
	*  @precondition none
	*  @postcondition a instance of View would have been initialized and GUI is shown
	*/
	public View() {
        // slider panel (panel 2)
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        slider1 = new Slider("Red");
        slider2 = new Slider("Green");
        slider3 = new Slider("Blue");
        panel2.add(slider1);
        panel2.add(Box.createRigidArea(new Dimension(0,15)));
        panel2.add(slider2);
        panel2.add(Box.createRigidArea(new Dimension(0,15)));
        panel2.add(slider3);
        
        // circle panel (panel 1)
        JPanel panel1 = new JPanel();
        icon1 = new Circle(50, slider1.getValue(), slider2.getValue(), slider3.getValue());
        label1 = new JLabel(icon1, JLabel.CENTER);
        panel1.add(label1);
        
        // setup frame (this)
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        containerPanel.add(panel1);
        containerPanel.add(Box.createRigidArea(new Dimension(0,15)));
        containerPanel.add(panel2);
        this.setTitle("Test Circle Sliders");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(containerPanel);
        this.setSize(350, 273);
        this.setVisible(true);
	}
	
	/**
	*  Add Listeners and observers to objects
	*  @precondition Objects initialized
	*  @postcondition User interaction fully implemented
	*/
	public void addListener(SliderListener SL) {
		slider1.addObserver(icon1);
		slider1.addChangeListener(SL);
		slider2.addObserver(icon1);
		slider2.addChangeListener(SL);
		slider3.addObserver(icon1);
		slider3.addChangeListener(SL);
    }
	
	/**
	*  Repaint labels
	*  @precondition none
	*  @postcondition Circle will be recolored
	*/
	public void repaint() {
		label1.repaint();
	}
	
	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args) {  
		Controller control = new Controller(new View());
	}
}