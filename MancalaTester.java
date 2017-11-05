import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Using timer to have the car reappear on the left after it disappears.
 * @author yen_my_huynh 4.22
 */
public class MancalaTester {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 800;
	private static final int BOARD_WIDTH = 600;
	private static final int BOARD_HEIGHT = 300;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		final MoveableShape shape = new BoardShape(0, 0, BOARD_WIDTH, BOARD_HEIGHT);
		ShapeIcon icon = new ShapeIcon(shape, FRAME_WIDTH, FRAME_HEIGHT);
		final JLabel label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		final int DELAY = 10;
		// Milliseconds between timer ticks
		Timer t = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//shape.move();
				label.repaint();
			}
		});
		t.start();
	}
}
