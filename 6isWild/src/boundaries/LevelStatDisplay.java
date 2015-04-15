package boundaries;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.BackController;

public class LevelStatDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;

	Application application;
	
	JButton btnBack;
	
	public LevelStatDisplay(Application application) {
		this.application = application;

		btnBack = new JButton("Back");
		
		setup();
	}

	@Override
	public void setup() {
		
		JLabel lblStats = new JLabel("LEVEL SCORES!");
		lblStats.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		
		JLabel lblElimination = new JLabel("Elimination");
		
		JLabel lblRelease = new JLabel("Release");
		
		JLabel lblPuzzle = new JLabel("Puzzle");
		
		JLabel lblLightning = new JLabel("Lightning");
		
		JLabel lblScoreHere = new JLabel("score here");
		
		JLabel label = new JLabel("score here");
		
		JLabel label_1 = new JLabel("score here");
		
		JLabel label_2 = new JLabel("score here");
		
		JLabel label_3 = new JLabel("score here");
		
		JLabel label_4 = new JLabel("score here");
		
		JLabel label_5 = new JLabel("score here");
		
		JLabel label_6 = new JLabel("score here");
		
		JLabel label_7 = new JLabel("score here");
		
		JLabel label_8 = new JLabel("score here");
		
		JLabel label_9 = new JLabel("score here");
		
		JLabel label_10 = new JLabel("score here");
		
		JLabel label_11 = new JLabel("score here");
		
		JLabel label_12 = new JLabel("score here");
		
		JLabel label_13 = new JLabel("score here");
		
		JLabel label_14 = new JLabel("score here");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(233)
									.addComponent(lblStats)
									.addGap(66))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(119)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblElimination)
										.addComponent(lblScoreHere)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
									.addGap(91)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPuzzle, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
									.addGap(50)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack)
					.addGap(73)
					.addComponent(lblStats)
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElimination)
						.addComponent(lblLightning)
						.addComponent(lblRelease)
						.addComponent(lblPuzzle))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblScoreHere)
						.addComponent(label_3)
						.addComponent(label_7)
						.addComponent(label_11))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_4)
						.addComponent(label_8)
						.addComponent(label_12))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_5)
						.addComponent(label_9)
						.addComponent(label_13))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(label_6)
						.addComponent(label_10)
						.addComponent(label_14))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void setBackController(BackController c) {
		btnBack.addActionListener(c);
	}
}