package boundaries;

import javax.swing.JButton;

public class LevelDisplay implements IDisplay {
	BoardDisplay board;
	String gameMode;
	int level;
	int score;
	int moves;
	int[] powerUps;
	JButton swapButton;
	JButton removeButton;
	JButton shuffleButton;
}
