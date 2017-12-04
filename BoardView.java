import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Models a Board class to view the state of the board.
 */

public class BoardView implements ChangeListener {
	private final Board board;
	private ArrayList<Pit> pits;
	final JTextField playerTurn;

	/**
	 * Constructor for Board - creates and updates the board.
	 * @param b the board to be view
	 */
	public BoardView(Board b) {
		board = b;
		pits = b.getData();
		JFrame frame = new JFrame("Mancala Game");
		frame.setSize(1200, 600);
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.undo();
			}
		});
		final JPanel grid = new JPanel(new GridLayout(0, 8));
		JPanel leftGrid = new JPanel(new BorderLayout());
		leftGrid.add(b.getMancala(2), BorderLayout.CENTER);
		leftGrid.add(new JLabel(" Player 1's Mancala", SwingConstants.LEFT), BorderLayout.NORTH);
		grid.add(leftGrid);
		for (int i = 0; i < 6; i++) {
			JPanel ingrid = new JPanel(new GridLayout(2, 0));
			final Pit toppit = pits.get(12 - i);
			final Pit botpit = pits.get(i);
			ingrid.add(toppit);// or some other empty component
			ingrid.add(botpit);
			toppit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e); // To change body of generated
											// methods, choose Tools |
											// Templates.
					board.choosePit(toppit);
				}
			});
			botpit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e); // To change body of generated
											// methods, choose Tools |
											// Templates.
					board.choosePit(botpit);
				}
			});
			grid.add(ingrid);
		}
		JPanel rightGrid = new JPanel(new BorderLayout());
		rightGrid.add(b.getMancala(1), BorderLayout.CENTER);
		rightGrid.add(new JLabel(" Player 2's Mancala", SwingConstants.LEFT), BorderLayout.NORTH);
		grid.add(rightGrid);
		frame.add(undoButton, BorderLayout.NORTH);
		frame.add(grid, BorderLayout.CENTER);
		playerTurn = new JTextField(board.getPlayer());
		playerTurn.setHorizontalAlignment(JTextField.CENTER);
		frame.add(playerTurn, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Repaints the state of the board as data changes.
	 * @param e the change event
	 */
	public void stateChanged(ChangeEvent e) {
		pits = board.getData();
		for (Pit pit : pits) {
			pit.repaint();
		}
		playerTurn.setText(String.valueOf(board.getPlayer()));
		if (board.gameOver()) {
			String score = "Final score: Player 1: " + pits.get(6).getMarbles();
			score += ", Player 2: " + pits.get(13).getMarbles() + ". ";
			if (pits.get(6).getMarbles() > pits.get(13).getMarbles())
				playerTurn.setText(score + "Player 1 Wins!");
			else if (pits.get(6).getMarbles() < pits.get(13).getMarbles())
				playerTurn.setText(score + "Player 2 Wins!");
			else
				playerTurn.setText(score + "Draw!");
		}
	}
}
