package q4;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
* Class Circle that implements a Icon 
* @author Cameron Anzola
* @class COP5339 001
* @data 2/18/2018
*/
public class Circle implements Icon {
	private int size;
	private Color color;

	/**
	*  Constructor for class Circle
	*  @precondition none
	*  @postcondition a instance of Circle would have been intialized
	*/
	public Circle(int aSize)
	{
	    size = aSize;
	    color = Color.RED;
	}
	
	/**
	*  get the width of an instance of Circle
	*  @precondition none
	*  @return width of an instance of Circle
	*/
	public int getIconWidth()
	{
	    return size;
	}
	
	/**
	*  get the height of an instance of Circle
	*  @precondition none
	*  @return height of an instance of Circle
	*/
	public int getIconHeight()
	{
	    return size;
	}
	
	/**
	*  set the color of an instance of circle to the color given 
	*  @precondition an instance of circle exist and a color is given
	*  @postcondition the fill color of circle will be changed to the color given
	*/
	public void setColor(Color c)
	{
	    this.color = c;
	}
	
	/**
	*  redraws the icon circle
	*  @precondition none
	*  @postcondition circle will be redrawn
	*/
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
	    Graphics2D g2 = (Graphics2D) g;
	    Ellipse2D.Double planet = new Ellipse2D.Double(x, y,
	         size, size);
	    g2.setColor(color);
	    g2.fill(planet);
	}
}
