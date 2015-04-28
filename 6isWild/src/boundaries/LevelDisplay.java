package boundaries;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import controllers.BackController;
import entities.AbstractLevel;
import entities.Board;
import entities.Game;
import entities.Model;

public class LevelDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;
	

	Board board;
	int gameMode;
	int level;
	int score;
	int moves;
	int[] powerUps;
	
	JButton btnBack;
	
	JButton btnSwap;
	JButton btnRemove;
	JButton btnShuffle;
	
	JLabel lblMovesTimeLeft;
	
	public LevelDisplay(Model model, AbstractLevel level) {
		super(model);
		
		this.board = level.getBoard();
		this.gameMode = Game.PUZZLE_ID;
		this.level = level.getLevel();
		this.score = level.getInfo().getScore();
		this.moves = level.getInfo().getMovesTotal() - level.getInfo().getMovesPlayed();
		this.powerUps = new int[]{level.getInfo().getSwaps(), level.getInfo().getShuffles(), level.getInfo().getRemoves()};

		btnBack = new JButton("Back");
		
		setup();
	}
	
	@Override
	public void setup() {
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(200);
		progressBar.setOrientation(SwingConstants.VERTICAL);
		
		lblMovesTimeLeft = new JLabel(((gameMode == Game.LIGHTNING_ID) ? "Time" : "Moves") + " left: ---");
		
		JButton btnNewButton = new JButton("" + powerUps[0]);
		
		JButton btnShuffle = new JButton("" + powerUps[1]);
		
		JButton btnRemove = new JButton("" + powerUps[2]);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Game Mode/Level #");
		
		BoardDisplay panel = new BoardDisplay(model, this.board);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
										.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblMovesTimeLeft)
											.addComponent(btnNewButton))))
								.addComponent(lblNewLabel_1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addGap(755))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(progressBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMovesTimeLeft)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnShuffle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemove)
					.addPreferredGap(ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		setLayout(groupLayout);
	}
	
	public void setBackController(BackController c) {
		btnBack.addActionListener(c);
	}
}
