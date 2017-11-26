import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Using timer to have the car reappear on the left after it disappears.
 * @author yen_my_huynh 4.22
 */
public class MancalaTester{
	
	static JComboBox marbles;
	static JComboBox style;
	static JButton submit;
	static JFrame start;
	static JLabel choose;
	static JPanel options;
	
	
    public static void main(String[] args){
    	
    	start = new JFrame("Start Mancala");
    	start.setSize(400, 200);
    	start.setLayout(new BorderLayout());
    	marbles = new JComboBox();
    	style = new JComboBox();
    	submit = new JButton("Submit");
    	choose = new JLabel("Please select a style and # of marbles to begin game!");
    	options = new JPanel();
    	
    	
    	//Populate options
    	marbles.addItem("3");
    	marbles.addItem("4");
    	style.addItem("Rectangles");
    	style.addItem("Circles");
    	options.add(style);
    	options.add(marbles);
    	
    	//Register actionListeners for buttons
    	submit.addActionListener(new submission());
    	
    	//Add components to the frame
    	start.add(choose, BorderLayout.NORTH);
    	start.add(options, BorderLayout.CENTER);
    	start.add(submit, BorderLayout.SOUTH);
    	start.setVisible(true);	
    }
    
    
    /** 
     * This class contains the methods pertaining to gameplay for the game and 
     * an action to be performed for the data for a given configuration.
     * 
     */
    static class submission implements ActionListener{
    	
    	/**
    	 *Based on user selection, sets up a new board
    	 *@param e - Action event which occurred
    	 */
		public void actionPerformed (ActionEvent e){
			start.setVisible(false);
	        RectangularStyle rS=new RectangularStyle();
	        CircularStyle cS=new CircularStyle();
	        if(style.getSelectedItem().toString().equals("Rectangles"))
	        {
	        	Board b=new Board(rS);
	        	BoardView bV=new BoardView(b);
		        b.addChangeListener(bV);
		        if(marbles.getSelectedItem().toString().equals("3"))
		        {
		        	b.fillBoard(3);
		        }
		        else
		        {
		        	b.fillBoard(4);
		        }
	        }
	        else
	        {
	        	Board b=new Board(cS);
	        	BoardView bV=new BoardView(b);
		        b.addChangeListener(bV);
		        if(marbles.getSelectedItem().toString().equals("3"))
		        {
		        	b.fillBoard(3);
		        }
		        else
		        {
		        	b.fillBoard(4);
		        }
	        }			
		}
	}
}