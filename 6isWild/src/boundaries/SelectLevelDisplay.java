package boundaries;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.BackController;
import controllers.SelectLevelButtonController;
import entities.Game;
import entities.Model;

/**
 * displays select level display menu
 * @author Ethan Coeytaux
 *
 */
public class SelectLevelDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;

	Application application;
	int gameMode;

	String modeName;

	JButton btnBack;


	JButton btnLvl[] = new JButton[20];

	public SelectLevelDisplay(Model model, Application application, int gameMode) {
		super(model);
		this.application = application;
		this.gameMode = gameMode;

		btnBack = new JButton("Back");

		switch (gameMode) {
		case Game.PUZZLE_ID:
			modeName = "Puzzle Mode";
			break;
		case Game.LIGHTNING_ID:
			modeName = "Lightning Mode";
			break;
		case Game.ELIMINATION_ID:
			modeName = "Elimination Mode";
			break;
		case Game.RELEASE_ID:
			modeName = "Release Mode";
			break;
		default:
			modeName = "??? Mode";
			break;
		}

		btnLvl[0] = new JButton("1");
		btnLvl[1] = new JButton("2");
		btnLvl[2] = new JButton("3");
		btnLvl[3] = new JButton("4");
		btnLvl[4] = new JButton("5");
		btnLvl[5] = new JButton("6");
		btnLvl[6] = new JButton("7");
		btnLvl[7] = new JButton("8");
		btnLvl[8] = new JButton("9");
		btnLvl[9] = new JButton("10");
		btnLvl[10] = new JButton("11");
		btnLvl[11] = new JButton("12");
		btnLvl[12] = new JButton("13");
		btnLvl[13] = new JButton("14");
		btnLvl[14] = new JButton("15");
		btnLvl[15] = new JButton("16");
		btnLvl[16] = new JButton("17");
		btnLvl[17] = new JButton("18");
		btnLvl[18] = new JButton("19");
		btnLvl[19] = new JButton("20");

		for (int i = 1; i < 20; i++) {
			if (!model.getGlobalStats().levelCompleted(gameMode, i - 1)) btnLvl[i].setEnabled(false);
		}

		initControllers();

	}

	/**
	 * initialize level display, then adds a back button and  adds action listener to that back button
	 */
	public void initControllers() {
		for (int i = 0; i < 1; i++) {
			LevelDisplay lvlDisplay = new LevelDisplay(model, model.getLevel(gameMode, i));
			lvlDisplay.setBackController(new BackController(application, this));
			btnLvl[i].addActionListener(new SelectLevelButtonController(model, application, lvlDisplay));

		}
	}

	/**
	 * setup for select Level Display
	 */
	@Override
	public void setup() {
		JLabel lblSelectALevel = new JLabel("SELECT A LEVEL!");
		lblSelectALevel.setFont(new Font("Lucida Grande", Font.PLAIN, 45));

		JLabel lblGameMode = new JLabel(modeName);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap(216, Short.MAX_VALUE)
						.addComponent(lblSelectALevel)
						.addGap(231))
						.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap(434, Short.MAX_VALUE)
								.addComponent(lblGameMode)
								.addGap(366))
								.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnBack)
										.addContainerGap(719, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
												.addGap(116)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(btnLvl[15], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(btnLvl[16], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(btnLvl[17], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(btnLvl[18], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(btnLvl[19], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(btnLvl[10], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(btnLvl[11], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(btnLvl[12], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(btnLvl[13], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(btnLvl[14], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(btnLvl[5], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																				.addGap(18)
																				.addComponent(btnLvl[6], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																				.addGap(18)
																				.addComponent(btnLvl[7], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																				.addGap(18)
																				.addComponent(btnLvl[8], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																				.addGap(18)
																				.addComponent(btnLvl[9], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
																				.addGroup(groupLayout.createSequentialGroup()
																						.addComponent(btnLvl[0], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																						.addGap(18)
																						.addComponent(btnLvl[1], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																						.addGap(18)
																						.addComponent(btnLvl[2], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																						.addGap(18)
																						.addComponent(btnLvl[3], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
																						.addGap(18)
																						.addComponent(btnLvl[4], GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
																						.addContainerGap(152, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGap(44)
						.addComponent(lblGameMode)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSelectALevel)
						.addGap(45)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLvl[0], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLvl[1], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLvl[2], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLvl[3], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLvl[4], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnLvl[5], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLvl[6], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLvl[7], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLvl[8], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLvl[9], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnLvl[10], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnLvl[11], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnLvl[12], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnLvl[13], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnLvl[14], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnLvl[15], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnLvl[16], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnLvl[17], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnLvl[18], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
														.addComponent(btnLvl[19], GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
														.addContainerGap(99, Short.MAX_VALUE))
				);
		setLayout(groupLayout);
	}

	/**
	 *  adds action listener to back button
	 * @param c controller back button
	 */
	public void setBackController(BackController c) {
		btnBack.addActionListener(c);
	}

	public void setButtonControllers() {
	}
	
	/**
	 * 
	 * @param index
	 * @return button for selected level
	 */
	public JButton getBtnLvl(int index) {
		return btnLvl[index];
	}
}
