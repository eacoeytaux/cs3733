package boundaries;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import controllers.BackController;
import controllers.RemoveButtonController;
import controllers.ShuffleButtonController;
import controllers.SwapButtonController;
import entities.AbstractLevel;
import entities.Board;
import entities.Game;
import entities.Model;

/**
 * displays a level, which contains all other display needed for playing a level
 * @author Hugh Whelan
 * @author Ethan Coeytaux
 *
 */
public class LevelDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;

	AbstractLevel level;
	Board board;
	int gameMode;
	int levelNum;
	int moves;
	int[] powerUps;
	BoardDisplay panel;

	JButton btnBack;

	JButton btnSwap;
	JButton btnRemove;
	JButton btnShuffle;

	JLabel lblMovesTimeLeft;
	JLabel lblScore;

	JLabel lblGameMode;

	public LevelDisplay(Model model, AbstractLevel level) {
		super(model);

		this.level = level;
		this.board = level.getBoard();
		this.gameMode = level.getLevelType();
		this.levelNum = level.getLevel();
		this.moves = level.getInfo().getMovesTotal() - level.getInfo().getMovesPlayed();
		this.powerUps = new int[]{level.getInfo().getSwaps(), level.getInfo().getShuffles(), level.getInfo().getRemoves()};

		btnBack = new JButton("Back");
		lblMovesTimeLeft = new JLabel("moves/time left: ");
		btnSwap = new JButton("Swaps: " + powerUps[0]);
		btnShuffle = new JButton("Shuffles: " + powerUps[1]);
		btnRemove = new JButton("Removes: " + powerUps[2]);
		lblGameMode = new JLabel("Game Mode/Level #");
		int score = 0;//level.getStats().getScore(); //TODO uncomment and change back
		lblScore = new JLabel("Score: " + score);

		initControllers();
		setup();
	}

	/**
	 * sets up display of Level
	 */
	@Override
	public void setup() {
		this.removeAll();

		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(200);
		progressBar.setOrientation(SwingConstants.VERTICAL);

		

		if(panel ==null){
			panel = new BoardDisplay(model, this.board, this);
		}

		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addGap(34)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(btnSwap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(btnShuffle, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
																		.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																						.addComponent(lblScore)
																						.addComponent(lblMovesTimeLeft))
																						.addGap(5))))
																						.addComponent(lblGameMode)))
																						.addGroup(groupLayout.createSequentialGroup()
																								.addGap(106)
																								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
																								.addGap(755))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(12)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(progressBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
								.addContainerGap(29, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblGameMode)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblMovesTimeLeft)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnSwap)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnShuffle)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnRemove)
										.addGap(130)
										.addComponent(lblScore)
										.addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
										.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addGap(15))
				);
		setLayout(groupLayout);
	}

	/**
	 * adds an action listener to back button
	 * @param c controller for back button
	 */
	public void setBackController(BackController c) {
		btnBack.addActionListener(c);
	}

	/**
	 * reinitializes the board from the corresponding blueprint
	 */
	public void reinitBoard() {
		//level.resetBoard();
		this.board = level.getBoard();
		this.board.fillRandom();
		panel.setup();
	}

	/**
	 * adds an action listener to make move button
	 * @param c controller for back button
	 */

	public BoardDisplay getBoardDisplay(){
		return this.panel;
	}

	public AbstractLevel getLevel(){
		return this.level;
	}

	/**
	 * displays message to indicate time is up
	 */
	public void endCountdown() {
		System.out.println("out of time!!!");
	}

	/**
	 * begins timer for lightening levels
	 */
	public void startCountdown() {
		Thread timerThread = new Thread() {
			@Override
			public void run() {
				while (moves > 0) {
					try {
						Thread.sleep(1000);
						moves--;
						System.out.println("time remaining: " + moves);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				endCountdown();
			}
		};

		timerThread.start();
	}
	
	public void initControllers() {
		btnSwap.addActionListener(new SwapButtonController(level));
		btnRemove.addActionListener(new RemoveButtonController(level));
		btnShuffle.addActionListener(new ShuffleButtonController(this));
	}
	
	public void startLevel() {
		if (gameMode == Game.LIGHTNING_ID) startCountdown();
	}
}
