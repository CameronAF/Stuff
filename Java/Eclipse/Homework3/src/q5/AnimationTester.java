package q5;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;

/**
 * This program implements an animation that moves
 * a car shape.
 */
public class AnimationTester {
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 400;
	private static final int CAR_WIDTH = 100;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		//make a list of 4 cars on different y axis
		LinkedList<MoveableShape> shapes = new LinkedList<MoveableShape>();
		shapes.add(new CarShape(0, 0, CAR_WIDTH));
		shapes.add(new CarShape(0, 100, CAR_WIDTH));
		shapes.add(new CarShape(0, 200, CAR_WIDTH));
	    shapes.add(new CarShape(0, 300, CAR_WIDTH));
	 
	    ShapeIcon icon = new ShapeIcon(shapes, ICON_WIDTH, ICON_HEIGHT);
	
	    final JLabel label = new JLabel(icon);
	    frame.setLayout(new FlowLayout());
	    frame.add(label);
	
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	
	    final int DELAY = 100;
	    // Milliseconds between timer ticks
	    Timer t = new Timer(DELAY, new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		// loop though list to translate each shape
	    		for(MoveableShape s: shapes)
	    		{
		    		s.translate(1, 0);
		    		label.repaint();
	    		}
	    	}
	    });
	    t.start();
    }
}
