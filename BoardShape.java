import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/**
 * Models a MarbleShape class that draws marbles and moves them.
 * @author yen_my_huynh
 *
 */
public class BoardShape implements MoveableShape {
	private int x;
	private int y;
	private int width;
	private int height;
	
	/**
	   Constructs a car item.
	   @param x the left of the bounding rectangle
	   @param y the top of the bounding rectangle
	   @param width the width of the bounding rectangle
	*/
	public BoardShape(int x, int y, int width, int height)
	{
	   this.x = x;
	   this.y = y;
	   this.width = width;
	   this.height = height;
	}

	/**
	 * Moves the car, reappear on the left-hand side 
	 * after it disappears from the frame.
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public void move() {
		if (x == 0){
			x = 0;
		}
		else{
			x++;
		}
	}

	/**
	 * Draws the car shape.
	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2) {
		double mancalaWidth = 50;
	    double mancalaHeight = 240;
	    double holeWidth = 60;
	    double holeHeight = 85;
		RoundRectangle2D.Double board = new RoundRectangle2D.Double(x + 10, y + width / 5, width, height, 40, 40);
		RoundRectangle2D.Double mancalaA = new RoundRectangle2D.Double(x + 20, height/2 + y, mancalaWidth, mancalaHeight, 50, 50);
		RoundRectangle2D.Double mancalaB = new RoundRectangle2D.Double(x + width-50, height/2 + y, mancalaWidth, mancalaHeight, 50, 50);
		
		Ellipse2D.Double holeB1 = new Ellipse2D.Double(x + mancalaWidth + 30, y + width / 4, holeWidth, holeHeight);
		Ellipse2D.Double holeB2 = new Ellipse2D.Double(x + holeWidth * 2 + 40, y + width / 4, holeWidth, holeHeight);
		Ellipse2D.Double holeB3 = new Ellipse2D.Double(x + holeWidth * 3 + 60, y + width / 4, holeWidth, holeHeight);
		Ellipse2D.Double holeB4 = new Ellipse2D.Double(x + holeWidth * 4 + 80, y + width / 4, holeWidth, holeHeight);
		Ellipse2D.Double holeB5 = new Ellipse2D.Double(x + holeWidth * 5 + 100, y + width / 4, holeWidth, holeHeight);
		Ellipse2D.Double holeB6 = new Ellipse2D.Double(x + holeWidth * 6 + 120, y + width / 4, holeWidth, holeHeight);

		Ellipse2D.Double holeA1 = new Ellipse2D.Double(x + mancalaWidth + 30, y + width / 2, holeWidth, holeHeight);
		Ellipse2D.Double holeA2 = new Ellipse2D.Double(x + holeWidth * 2 + 40, y + width / 2, holeWidth, holeHeight);
		Ellipse2D.Double holeA3 = new Ellipse2D.Double(x + holeWidth * 3 + 60, y + width / 2, holeWidth, holeHeight);
		Ellipse2D.Double holeA4 = new Ellipse2D.Double(x + holeWidth * 4 + 80, y + width / 2, holeWidth, holeHeight);
		Ellipse2D.Double holeA5 = new Ellipse2D.Double(x + holeWidth * 5 + 100, y + width / 2, holeWidth, holeHeight);
		Ellipse2D.Double holeA6 = new Ellipse2D.Double(x + holeWidth * 6 + 120, y + width / 2, holeWidth, holeHeight);
		
	      g2.draw(board);
	      g2.draw(mancalaA);
	      g2.draw(mancalaB);
	      g2.draw(holeA1);
	      g2.draw(holeA2);
	      g2.draw(holeA3);
	      g2.draw(holeA4);
	      g2.draw(holeA5);
	      g2.draw(holeA6);

	      g2.draw(holeB1);
	      g2.draw(holeB2);
	      g2.draw(holeB3);
	      g2.draw(holeB4);
	      g2.draw(holeB5);
	      g2.draw(holeB6);
	}
}
