package q6_4;

import java.awt.*;
import java.awt.geom.*;

/**
 * A shape that manages its selection state.
 */
public abstract class SelectableShape implements SceneShape {
	public void setSelected(boolean b) {
		selected = b;
	}

	public boolean isSelected() {
		return selected;
	}

	/**
	 * @author Cameron Anzola
     * Adds Blue Square with adorners to selected item
     * @param g2 the graphics context
     */
	public void drawSelection(Graphics2D g2) {
		// Add blue rectangle with dash borders
		Rectangle rec = getPathBounds();
		Rectangle2D.Double box 
        = new Rectangle2D.Double(rec.x - 3, rec.y - 3, rec.getWidth() + 6, rec.getHeight() + 6);
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1,
		        new float[] { 5, 2 }, 0));
		g2.setColor(Color.BLUE);
		g2.draw(box);
		// Add blue adorners
		SelectCorners adorners = new SelectCorners(rec.x - 4, rec.y - 4, rec.getWidth() + 8, rec.getHeight() + 8);
		g2.setStroke(new BasicStroke(4));
		adorners.draw(g2);
		// reset basic stroke and color
		g2.setStroke(new BasicStroke(1));
		g2.setColor(Color.BLACK);
	}

	private boolean selected;
}