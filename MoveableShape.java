import java.awt.*;

/**
 * Models a MoveableShape interface:
 * A shape that can be moved around.
 * 4.22
 * @author yen_my_huynh
 */

public interface MoveableShape {
	/**
	 * Draws the shape.
	 * @param g2 the graphics context
	 */
	void draw(Graphics2D g2);
	
	/**
	 * Moves the shape.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	void move();
}
