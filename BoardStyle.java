import java.awt.Shape;

/** 
 * This interface contains the methods pertaining to functionality for game display
 * 
 */

public interface BoardStyle {
    /**
     * Returns the shape of the pit to use according to the specifications
     * of the class implementing this interface.
     * @return a Shape object of the pit
     */
	public Shape getPit();
    /**
     * Returns the shape of the mancala to use according to the specifications
     * of the class implementing this interface.
     * @return a Shape object of the mancala
     */
	public Shape getMancala(Player p);

}