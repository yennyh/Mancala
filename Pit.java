import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.swing.JComponent;

/** 
 * Models a Pit class to initializes pits on board and marbles within
 * as data changes.
 */

public class Pit extends JComponent{
	
	int marbles;
	int pitIndex;
	int player;
	BoardStyle style;
	
	/**
     * Constructor for pits.
     * @param marbles the chosen number of marbles to start with
     * @param pitIndex the index of each pit
     * @param player the player's turn
     * @param style the chosen board style to start with
     */        
	public Pit (int marbles, int pitIndex, int player, BoardStyle style){
		this.marbles = marbles;
		this.pitIndex = pitIndex;
		this.player = player;
		this.style = style;     
	}
	
	/**
	 * Gets the player's turn.
	 * @return the player's turn
	 */
	public int getPlayer(){
		return player;
	}

	/**
	 * Sets the number of marbles in the current pit.
	 * @param marbles the number of marbles
	 */
	public void setMarbles(int marbles){
		this.marbles = marbles;
	}
	
	/**
	 * Gets the number of marbles in the current pit.
	 * @return the number of marbles
	 */
	public int getMarbles(){
		return marbles;
	}
	
	/**
	 * Gets the index of each pit.
	 * @return the index of each pit
	 */
	public int getIndex(){
		return pitIndex;
	}
	
	/**
	 * Checks if the pit is empty or not.
	 * @return true if the pit is empty, otherwise false
	 */
	public boolean isEmpty() {
		if (marbles > 0){
			return true;
		}
		return false;
	}

	/**
	 * Gets the style of the board.
	 * @return the style of the board
	 */
	public BoardStyle getStyle() {
		return style;
	}

	/**
	 * Gets the style of the pit to draw.
	 * @param style the style of the pit
	 * @return the chose style for the pit
	 */
	public Shape drawHolder(BoardStyle style){
		return style.getPit();
	}
	
	/**
	 * Draws the number of marbles for each pit.
	 *@param g the graphics context
	 */
	public void paintComponent(Graphics g)
	{
        super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(this.drawHolder(style));	
		int shapeWidth=this.drawHolder(style).getBounds().width;
		int x = 0;
		int y = 0;
		int row = shapeWidth/2-5;
		int col = shapeWidth/2-5;
		
		for(int i = 0; i< getMarbles(); i++)
		{
			if( y < shapeWidth)
			{
				g2.drawOval(col,y, 10,10);
				y+= 10;				
			}
			else{
			g2.drawOval(x,row, 10,10);
			x += 10;
			}
		}
	}
}
