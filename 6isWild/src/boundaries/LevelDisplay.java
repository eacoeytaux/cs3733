package boundaries;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import controllers.BackController;
import controllers.RemoveButtonController;
import controllers.SaveScore;
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

	Thread timerThread;
	boolean timerRunning;

	AbstractLevel level;
	Board board;
	int gameMode;
	int levelNum;
	int moves;
	BoardDisplay panel;
	int score;

	JButton btnBack;

	JButton btnSwap;
	JButton btnRemove;
	JButton btnShuffle;

	JLabel lblMovesTimeLeft;
	JLabel lblScore;

	JLabel lblGameMode;
	JLabel lblMoves;
	JLabel lblStars;

	public LevelDisplay(Model model, AbstractLevel level) {
		super(model);

		this.level = level;
		this.board = level.getBoard();
		this.gameMode = level.getLevelType();
		this.levelNum = level.getLevel();
		this.moves = level.getInfo().getMovesTotal() - level.getInfo().getMovesPlayed();
		this.moves = level.getInfo().getMovesTotal() - level.getInfo().getMovesPlayed();

		btnBack = new JButton("Back");
		lblMovesTimeLeft = new JLabel("");
		btnSwap = new JButton("Swaps: " + level.getInfo().getSwaps());
		btnShuffle = new JButton("Shuffles: " + level.getInfo().getShuffles());
		btnRemove = new JButton("Removes: " + level.getInfo().getRemoves());
		lblGameMode = new JLabel("");

		initControllers();
		setup();
	}

	/**
	 * sets up display of Level
	 */
	@Override
	public void setup() {
		this.removeAll();

		//this.moves = level.getInfo().getMovesTotal() - level.getInfo().getMovesPlayed();
		//this.powerUps = new int[]{level.getInfo().getSwaps(), level.getInfo().getShuffles(), level.getInfo().getRemoves()};


		btnSwap.setText("Swaps: " + level.getInfo().getSwaps());
		btnShuffle.setText("Shuffles: " + level.getInfo().getShuffles());
		btnRemove.setText("Removes: " + level.getInfo().getRemoves());
		
		score = level.getInfo().getScore();	
		lblScore = new JLabel("Score: " + score);

		moves = level.getInfo().getMovesTotal() - level.getInfo().getMovesPlayed();

		if (gameMode == Game.LIGHTNING_ID) {
			lblMoves = new JLabel("Time: " + moves);
		} else {
			lblMoves = new JLabel("Moves: " + moves);
		}


		int stars = 0;
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(200);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		int[] starReqs = level.getStarRequirements();
		if (score < starReqs[0]) {
			progressBar.setValue((int)((((float)score/(float)starReqs[0]) * 200f)));
		} else if (score < starReqs[1]) {
			progressBar.setValue((int)((((float)score - (float)starReqs[0])/((float)starReqs[1] - (float)starReqs[0]) * 200f)));
			stars = 1;
		} else if (score < starReqs[2]) {
			progressBar.setValue((int)((((float)score - (float)starReqs[1])/((float)starReqs[2] - (float)starReqs[1]) * 200f)));
			stars = 2;
		} else {
			progressBar.setValue(200);
			stars = 3;
		}

		if (panel == null){
			panel = new BoardDisplay(model, this.board, this);
		}

		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		lblMoves.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		lblStars = new JLabel("Stars: " + stars);
		lblStars.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

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
																		.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 96, Short.MAX_VALUE))
																		.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																						.addComponent(lblScore)
																						.addComponent(lblMovesTimeLeft)
																						.addComponent(lblMoves)
																						.addComponent(lblStars, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
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
								.addContainerGap(28, Short.MAX_VALUE))
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
										.addGap(93)
										.addComponent(lblStars, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblScore)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblMoves)
										.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
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
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timerRunning = false;
			}
		});
	}

	/**
	 * reinitializes the board from the corresponding blueprint
	 */
	public void reinitBoard() {
		level.resetBoard();
		this.board = level.getBoard();
		this.board.fillRandom();
		refreshBoardDisplay();
		setup();
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
	public void endCountdown(boolean showDisplay) {
		timerRunning = false;
		if (showDisplay){ 
			gameOver(true);
		}
	}

	/**
	 * begins timer for lightening levels
	 */
	public void startCountdown() {
		timerRunning = true;
		timerThread = new Thread() {
			@Override
			public void run() {
				while (timerRunning && (moves > 0)) {
					try {
						Thread.sleep(1000);
						level.getInfo().incrementMoves();
						moves = level.getInfo().getMovesTotal() - level.getInfo().getMovesPlayed();
						lblMoves.setText("Time: " + moves);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (moves <= 0) endCountdown(true);
			}
		};

		timerThread.start();
	}

	/**
	 * initializes controllers for powerup buttons
	 */
	public void initControllers() {
		btnSwap.addActionListener(new SwapButtonController(btnSwap, level));
		btnRemove.addActionListener(new RemoveButtonController(btnRemove, level));
		btnShuffle.addActionListener(new ShuffleButtonController(btnShuffle, this));
	}

	/**
	 * begins the countdown if the gamemode is lightning
	 */
	public void startLevel() {
		if (gameMode == Game.LIGHTNING_ID) startCountdown();
	}

	/**
	 * refreshes the entire board display
	 */
	public void refreshBoardDisplay() {
		panel = new BoardDisplay(model, this.board, this);
	}


	/**
	 * displays a message at the end of a level indicating how well you did in the level
	 * @param requirementsMet boolean indicating whether or not gamemode specific rewuirements have been met
	 */
	public void gameOver(boolean requirementsMet) {
		String message;

		if (!requirementsMet) {
			message = "You failed to meet the level requirements";
		} else if (score < level.getStarRequirements()[0]) {
			message = "You didn't get any stars.";
		} else {
			new SaveScore(model.getCurrentLevel(), model);

			if (score < level.getStarRequirements()[1]) {
				message = "You got 1 star!";
			} else if (score < level.getStarRequirements()[2]) {
				message = "You got 2 starts!!";
			} else message = "You got 3 stars!!!";
		}

		JOptionPane.showMessageDialog(null, message, "Game Over", JOptionPane.PLAIN_MESSAGE);

		btnBack.doClick();
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public JButton getBtnShuffle() {
		return btnShuffle;
	}

	public JButton getBtnSwap() {
		return btnSwap;
	}
}
