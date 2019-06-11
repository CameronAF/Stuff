package q5_3;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Class Rectangle that extends Component implements a Icon and Observer
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/24/2018
 */
public class Rectangle extends Component implements Icon, Observer {
	// private attributes
	private double ratio;
	private Color color;

	/**
	*  Constructor for class Rectangle
	*  @precondition none
	*  @postcondition a instance of Rectangle would have been initialized
	*/
	public Rectangle(double percentRatio, Color c) {
		this.ratio = (percentRatio/100);
		this.color = c;
	}
	
	/**
	*  Get the width of an instance of Rectangle
	*  @precondition none
	*  @return width of an instance of Rectangle
	*/
	public int getIconWidth() {
	    return this.getWidth();
	}
	
	/**
	*  get the height of an instance of Rectangle
	*  @precondition none
	*  @return height of an instance of Rectangle
	*/
	public int getIconHeight() {
	    return this.getHeight();
	}
	
	/**
	*  Update the ratio of Rectangle.
	*  @precondition none
	*  @postcondition circle Ratio is changed to a value between 0 and 1
	*/
	//@Override
	public void update(double percentRatio) {
		if (percentRatio < 100)
			this.ratio = (percentRatio/100);
		else
			this.ratio = 1;
	}
	
	/**
	*  Redraws the icon Rectangle 
	*  @precondition none
	*  @postcondition circle will be redrawn
	*/
	public void paintIcon(Component c, Graphics g, int x, int y) {
	    Graphics2D g2 = (Graphics2D) g;
	    Rectangle2D.Double rec = new Rectangle2D.Double(0, 0,
                (this.ratio*c.getWidth()),
                c.getHeight());
	    g2.setColor(this.color);
	    g2.fill(rec);
	    g2.draw(rec);
	}
}
