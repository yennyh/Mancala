import java.awt.*;

import javax.swing.Icon;

/**
 * An icon that contains a Moveable shape.
 */
public class ShapeIcon implements Icon {
	private int width;
	private int height;
	private MoveableShape shape;

	/**
	 * Constructs a MoveableShape with a unique shape, width, height.
	 * @param shape the shape
	 * @param width the width of the shape
	 * @param height the height of the shape
	 */
	public ShapeIcon(MoveableShape shape, int width, int height) {
		this.shape = shape;
		this.width = width;
		this.height = height;
	}

	/**
	 * Gets the icon's width.
	 * @return the icon's width
	 */
	public int getIconWidth() {
		return width;
	}

	/**
	 * Gets the icon's height.
	 * @return the icon's height
	 */
	public int getIconHeight() {
		return height;
	}

	/**
	 * Paints the icon.
	 * @param c the component
	 * @param g graphics context
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);
	}
}
