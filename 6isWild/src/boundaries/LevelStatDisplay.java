package boundaries;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.BackController;
import controllers.ResetScoreController;
import entities.Game;
import entities.GlobalStats;
import entities.Model;

/**
 * displays the statistics of a level
 * @author Jon Sawin
 * Ethan Coeytaux
 *
 */
public class LevelStatDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;

	Application application;
	GlobalStats globalStats;
	JButton btnBack;
	JButton btnReset;
	
	public LevelStatDisplay(Model model, Application application) {
		super(model);
		this.application = application;
		this.globalStats = model.getGlobalStats();

		btnBack = new JButton("Back");
		btnReset = new JButton("Reset Progess");
		btnReset.addActionListener(new ResetScoreController(model, this));
		
		//setup();
	}
	



	/**
	 * setup for Level Stat Display
	 */
	@Override
	public void setup() {
		this.removeAll();
		
		JLabel lblStats = new JLabel("LEVEL SCORES!");
		lblStats.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		
		JLabel lblElimination = new JLabel("Elimination");
		
		JLabel lblRelease = new JLabel("Release");
		
		JLabel lblPuzzle = new JLabel("Puzzle");
		
		JLabel lblLightning = new JLabel("Lightning");
		
		JLabel label = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 0).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 0).getStars() + " Stars");
		JLabel label_1 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 1).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 1).getStars() + " Stars");
		JLabel label_2 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 2).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 2).getStars() + " Stars");
		JLabel label_3 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 3).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 3).getStars() + " Stars");
		JLabel label_4 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 4).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 4).getStars() + " Stars");
		JLabel label_5 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 5).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 5).getStars() + " Stars");
		JLabel label_6 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 6).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 6).getStars() + " Stars");
		JLabel label_7 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 7).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 7).getStars() + " Stars");
		JLabel label_8 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 8).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 8).getStars() + " Stars");
		JLabel label_9 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 9).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 9).getStars() + " Stars");
		JLabel label_10 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 10).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 10).getStars() + " Stars");
		JLabel label_11 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 11).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 11).getStars() + " Stars");
		JLabel label_12 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 12).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 12).getStars() + " Stars");
		JLabel label_13 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 13).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 13).getStars() + " Stars");
		JLabel label_14 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 14).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 14).getStars() + " Stars");
		JLabel label_15 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 15).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 15).getStars() + " Stars");
		JLabel label_16 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 16).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 16).getStars() + " Stars");
		JLabel label_17 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 17).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 17).getStars() + " Stars");
		JLabel label_18 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 18).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 18).getStars() + " Stars");
		JLabel label_19 = new JLabel(globalStats.getStats(Game.PUZZLE_ID, 19).getScore() + ", " + globalStats.getStats(Game.PUZZLE_ID, 19).getStars() + " Stars");

		JLabel label_20 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 0).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 0).getStars() + " Stars");
		JLabel label_21 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 1).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 1).getStars() + " Stars");
		JLabel label_22 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 2).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 2).getStars() + " Stars");
		JLabel label_23 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 3).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 3).getStars() + " Stars");
		JLabel label_24 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 4).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 4).getStars() + " Stars");
		JLabel label_25 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 5).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 5).getStars() + " Stars");
		JLabel label_26 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 6).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 6).getStars() + " Stars");
		JLabel label_27 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 7).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 7).getStars() + " Stars");
		JLabel label_28 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 8).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 8).getStars() + " Stars");
		JLabel label_29 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 9).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 9).getStars() + " Stars");
		JLabel label_30 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 10).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 10).getStars() + " Stars");
		JLabel label_31 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 11).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 11).getStars() + " Stars");
		JLabel label_32 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 12).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 12).getStars() + " Stars");
		JLabel label_33 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 13).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 13).getStars() + " Stars");
		JLabel label_34 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 14).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 14).getStars() + " Stars");
		JLabel label_35 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 15).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 15).getStars() + " Stars");
		JLabel label_36 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 16).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 16).getStars() + " Stars");
		JLabel label_37 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 17).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 17).getStars() + " Stars");
		JLabel label_38 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 18).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 18).getStars() + " Stars");
		JLabel label_39 = new JLabel(globalStats.getStats(Game.LIGHTNING_ID, 19).getScore() + ", " + globalStats.getStats(Game.LIGHTNING_ID, 19).getStars() + " Stars");

		JLabel label_40 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 0).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 0).getStars() + " Stars");
		JLabel label_41 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 1).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 1).getStars() + " Stars");
		JLabel label_42 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 2).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 2).getStars() + " Stars");
		JLabel label_43 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 3).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 3).getStars() + " Stars");
		JLabel label_44 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 4).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 4).getStars() + " Stars");
		JLabel label_45 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 5).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 5).getStars() + " Stars");
		JLabel label_46 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 6).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 6).getStars() + " Stars");
		JLabel label_47 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 7).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 7).getStars() + " Stars");
		JLabel label_48 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 8).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 8).getStars() + " Stars");
		JLabel label_49 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 9).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 9).getStars() + " Stars");
		JLabel label_50 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 10).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 10).getStars() + " Stars");
		JLabel label_51 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 11).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 11).getStars() + " Stars");
		JLabel label_52 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 12).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 12).getStars() + " Stars");
		JLabel label_53 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 13).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 13).getStars() + " Stars");
		JLabel label_54 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 14).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 14).getStars() + " Stars");
		JLabel label_55 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 15).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 15).getStars() + " Stars");
		JLabel label_56 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 16).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 16).getStars() + " Stars");
		JLabel label_57 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 17).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 17).getStars() + " Stars");
		JLabel label_58 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 18).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 18).getStars() + " Stars");
		JLabel label_59 = new JLabel(globalStats.getStats(Game.ELIMINATION_ID, 19).getScore() + ", " + globalStats.getStats(Game.ELIMINATION_ID, 19).getStars() + " Stars");

		JLabel label_60 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 0).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 0).getStars() + " Stars");
		JLabel label_61 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 1).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 1).getStars() + " Stars");
		JLabel label_62 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 2).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 2).getStars() + " Stars");
		JLabel label_63 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 3).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 3).getStars() + " Stars");
		JLabel label_64 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 4).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 4).getStars() + " Stars");
		JLabel label_65 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 5).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 5).getStars() + " Stars");
		JLabel label_66 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 6).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 6).getStars() + " Stars");
		JLabel label_67 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 7).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 7).getStars() + " Stars");
		JLabel label_68 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 8).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 8).getStars() + " Stars");
		JLabel label_69 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 9).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 9).getStars() + " Stars");
		JLabel label_70 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 10).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 10).getStars() + " Stars");
		JLabel label_71 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 11).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 11).getStars() + " Stars");
		JLabel label_72 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 12).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 12).getStars() + " Stars");
		JLabel label_73 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 13).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 13).getStars() + " Stars");
		JLabel label_74 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 14).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 14).getStars() + " Stars");
		JLabel label_75 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 15).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 15).getStars() + " Stars");
		JLabel label_76 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 16).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 16).getStars() + " Stars");
		JLabel label_77 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 17).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 17).getStars() + " Stars");
		JLabel label_78 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 18).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 18).getStars() + " Stars");
		JLabel label_79 = new JLabel(globalStats.getStats(Game.RELEASE_ID, 19).getScore() + ", " + globalStats.getStats(Game.RELEASE_ID, 19).getStars() + " Stars");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPuzzle, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLightning, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_21, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_23, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_25, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_26, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_27, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_28, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_29, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_30, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_31, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_32, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_33, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_34, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_35, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_36, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_37, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_38, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_39, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
							.addGap(98)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblElimination)
								.addComponent(label_40, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_41, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_42, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_43, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_44, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_45, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_46, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_47, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_48, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_49, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_50, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_51, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_52, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_53, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_54, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_55, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_56, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_57, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_58, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_59, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
							.addComponent(lblStats)
							.addGap(90)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_79, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_78, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_77, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_76, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_75, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_74, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_73, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_72, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_71, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_70, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_69, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_68, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_67, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_66, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_65, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_64, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_63, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_62, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_61, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRelease, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_60, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
							.addGap(32))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnReset)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(lblStats))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPuzzle)
								.addComponent(lblElimination)
								.addComponent(lblRelease))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(label_20)
								.addComponent(label_40)
								.addComponent(label_60))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(label_21)
								.addComponent(label_41)
								.addComponent(label_61))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(label_22)
								.addComponent(label_42)
								.addComponent(label_62)))
						.addComponent(lblLightning))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(label_23))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(label_24))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(label_25))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6)
								.addComponent(label_26))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_7)
								.addComponent(label_27))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_8)
								.addComponent(label_28))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_9)
								.addComponent(label_29))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_10)
								.addComponent(label_30))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_11)
								.addComponent(label_31))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_12)
								.addComponent(label_32))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_13)
								.addComponent(label_33))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_14)
								.addComponent(label_34))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_15)
								.addComponent(label_35))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_16)
								.addComponent(label_36))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_17)
								.addComponent(label_37))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_18)
								.addComponent(label_38))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_19)
								.addComponent(label_39)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_43)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_44)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_45)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_46)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_47)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_48)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_49)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_50)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_51)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_52)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_53)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_54)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_55)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_56)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_57)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_58)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_59))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_63)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_64)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_65)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_66)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_67)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_68)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_69)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_70)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_71)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_72)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_73)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_74)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_75)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_76)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_77)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_78)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_79)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
}
