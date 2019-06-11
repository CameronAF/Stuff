package q5_3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Class View that extends JFrame. 
 * Starts program with Main
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/19/2018
 */
public class View extends JFrame {
	// private attributes
    private Textfield textField1;
    private Textfield textField2;
    private Textfield textField3;
    private Rectangle icon1;
    private Rectangle icon2;
    private Rectangle icon3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
  
    /**
	*  Constructor for class View.
	*  @precondition none
	*  @postcondition a instance of View would have been initialized and GUI is shown
	*/
	public View() {
        // first panel
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        textField1 = new Textfield(100);
        textField2 = new Textfield(75);
        textField3 = new Textfield(50);
        panel1.add(textField1);
        panel1.add(Box.createRigidArea(new Dimension(0,15)));
        panel1.add(textField2);
        panel1.add(Box.createRigidArea(new Dimension(0,15)));
        panel1.add(textField3);
        
        // second panel
        JPanel barPanel = new JPanel();
        barPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.weightx = 2;
        gridConstraints.weighty = 2;
        gridConstraints.insets = new Insets(15,0,15,15);
        gridConstraints.fill = GridBagConstraints.BOTH;
        icon1 = new Rectangle(Double.parseDouble(textField1.getText()), Color.RED);
        icon2 = new Rectangle(Double.parseDouble(textField2.getText()), Color.YELLOW);
        icon3 = new Rectangle(Double.parseDouble(textField3.getText()), Color.BLUE);
        label1 = new JLabel(icon1, JLabel.LEFT);
        label2 = new JLabel(icon2, JLabel.LEFT);
        label3 = new JLabel(icon3, JLabel.LEFT);
        label1.setBackground(Color.BLACK);
        label1.setOpaque(true);
        label2.setBackground(Color.BLACK);
        label2.setOpaque(true);
        label3.setBackground(Color.BLACK);
        label3.setOpaque(true);
        barPanel.add(label1, gridConstraints);
        gridConstraints.gridy = 2;
        barPanel.add(label2, gridConstraints);
        gridConstraints.gridy = 3;
        barPanel.add(label3, gridConstraints);
        
        // setup frame (this)
        JPanel containerPanel = new JPanel(new BorderLayout(1, 2));
        containerPanel.add(panel1, BorderLayout.LINE_START);
        containerPanel.add(barPanel);
        this.setTitle("Test vertical alignement");
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
	public void addListener(KeyListener KL) {
		textField1.addObserver(icon1);
		textField1.addKeyListener(KL);
		textField2.addObserver(icon2);
		textField2.addKeyListener(KL);
		textField2.addObserver(icon3);
		textField3.addKeyListener(KL);
    }
	
	/**
	*  Repaint labels
	*  @precondition none
	*  @postcondition Rectangles will be resized
	*/
	public void repaint() {
		label1.repaint();
		label2.repaint();
		label3.repaint();
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
