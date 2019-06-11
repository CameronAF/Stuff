package q6_4;

import java.awt.geom.Rectangle2D;

/**
 * @author Cameron Anzola
 * A shape of 4 squares in the corner of an invisible rectangle
 */
public class SelectCorners extends CompoundShape {
	/**
	 * Constructs four small squares in the corners of a big rectangle.
	 * @param x the left of the big rectangle
	 * @param y the top of the big rectangle
	 * @param width the width of the big rectangle
	 * @param height the height of the big rectangle
	 */
	public SelectCorners(int x, int y, double width, double height) {	      
		Rectangle2D.Double upperLeft 
         	= new Rectangle2D.Double(x - 2, y - 2, 4, 4);
	      
		Rectangle2D.Double lowerLeft 
         	= new Rectangle2D.Double(x - 2, y + height - 2, 4, 4);
	      
		Rectangle2D.Double upperRight 
         	= new Rectangle2D.Double(x + width - 2, y - 2, 4, 4);
	      
		Rectangle2D.Double lowerRight 
         	= new Rectangle2D.Double(x + width - 2, y + height - 2, 4, 4);

		add(upperLeft);
		add(lowerLeft);
		add(upperRight);
		add(lowerRight);
	}
}