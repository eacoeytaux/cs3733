package boundaries;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import controllers.BackController;
import entities.Model;

public class LevelDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;
	
	BoardDisplay board;
	String gameMode;
	int level;
	int score;
	int moves;
	int[] powerUps;
	
	JButton btnBack;
	
	JButton btnSwap;
	JButton btnRemove;
	JButton btnShuffle;
	
	public LevelDisplay(Model model) {
		super(model);
		
		btnBack = new JButton("Back");
		
		setup();
	}
	
	@Override
	public void setup() {
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblMovesLeftX = new JLabel("Moves left: x");
		
		JButton btnNewButton = new JButton("Swap (1)");
		
		JButton btnShuffle = new JButton("Shuffle (1)");
		
		JButton btnRemove = new JButton("Remove (1)");
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Game Mode/Level #");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(644)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnShuffle, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblMovesLeftX)
									.addComponent(btnNewButton))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)))
					.addGap(800))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMovesLeftX)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShuffle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemove)
							.addPreferredGap(ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	public void setBackController(BackController c) {
		btnBack.addActionListener(c);
	}
}
