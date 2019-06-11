package q5_4;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
* Class Circle that implements a Icon 
* @author Cameron Anzola
* @class COP5339 001
* @data 2/18/2018
*/
public class Circle extends Component implements Icon, Observer {
	private int size;
	private int red;
	private int green;
	private int blue;

	/**
	*  Constructor for class Circle
	*  @precondition none
	*  @postcondition a instance of Circle would have been initialized
	*/
	public Circle(int aSize, int r, int g, int b) {
	    this.size = aSize;
	    this.red = r;
	    this.green = g;
	    this.blue = b;
	}
	
	/**
	*  get the width of an instance of Circle
	*  @precondition none
	*  @return width of an instance of Circle
	*/
	public int getIconWidth() {
	    return size;
	}
	
	/**
	*  get the height of an instance of Circle
	*  @precondition none
	*  @return height of an instance of Circle
	*/
	public int getIconHeight() {
	    return size;
	}
	
	/**
	*  Update the color of an instance of circle to the color given 
	*  @precondition an instance of circle exist and a color is given
	*  @postcondition the fill color of circle will be changed to the color given
	*/
	//@Override
	public void update(String color, int value) {
		if (color == "Red") {
			this.red = value;
		}
		else if (color == "Green") {
			this.green = value;
		}
		else if (color == "Blue") {
			this.blue = value;
		}
	}
	
	/**
	*  redraws the icon circle
	*  @precondition none
	*  @postcondition circle will be redrawn
	*/
	public void paintIcon(Component c, Graphics g, int x, int y) {
	    Graphics2D g2 = (Graphics2D) g;
	    Ellipse2D.Double planet = new Ellipse2D.Double(x, y,
	         size, size);
	    g2.setColor(new Color(this.red,this.green,this.blue));
	    g2.fill(planet);
	}
}