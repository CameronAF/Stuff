package q6_3;

import java.awt.*;
import java.awt.geom.*;

/**
 * A scene shape that is composed of multiple geometric shapes.
 */
public abstract class CompoundShape extends SelectableShape {
   public CompoundShape() {
      path = new GeneralPath();
   }

   protected void add(Shape s) {
      path.append(s, false);
   }

   public boolean contains(Point2D aPoint) {
      return path.contains(aPoint);
   }

   public void translate(int dx, int dy) {
      path.transform(
            AffineTransform.getTranslateInstance(dx, dy));
   }

   /**
    * @author Cameron Anzola
    * Get the Bounds of items Path
    * @return A Rectangle of objects path
    */
   public Rectangle getPathBounds() {
      return path.getBounds();
   }
   
   public void draw(Graphics2D g2) {
      g2.draw(path);
   }
   
   private GeneralPath path;
}