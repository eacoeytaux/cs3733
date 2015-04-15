package boundaries;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.BackController;
import controllers.SelectPuzzleLevelButtonController;
import entities.Game;
import entities.Model;
import entities.PuzzleLevel;

public class SelectLevelDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;
	
	Application application;
	int gameMode;
	
	String modeName;
	
	JButton btnBack;
	
	
	JButton btnLvl[] = new JButton[4];
	
	public SelectLevelDisplay(Model model, Application application, int gameMode) {
		super(model);
		this.application = application;
		this.gameMode = gameMode;

		btnBack = new JButton("Back");
		btnLvl[0] = new JButton("1");
		
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
		
		initControllers();
	}
	
	public void initControllers() {
		for (int i = 0; i < 1; i++) {
			LevelDisplay lvlDisplay = new LevelDisplay(model, gameMode);
			lvlDisplay.setBackController(new BackController(application, this));
			btnLvl[i].addActionListener(new SelectPuzzleLevelButtonController(model, application, lvlDisplay));
		}
	}
	
	@Override
	public void setup() {
		JButton button = new JButton("2");
		button.setEnabled(false);
		
		JButton button_2 = new JButton("3");
		button_2.setEnabled(false);
		
		JButton button_3 = new JButton("4");
		button_3.setEnabled(false);
		
		JLabel lblSelectALevel = new JLabel("SELECT A LEVEL!");
		lblSelectALevel.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		
		JLabel lblGameMode = new JLabel(modeName);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(216, Short.MAX_VALUE)
					.addComponent(lblSelectALevel)
					.addGap(231))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(361, Short.MAX_VALUE)
					.addComponent(lblGameMode)
					.addGap(366))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(116)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLvl[0], GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
					.addGap(103)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack)
					.addContainerGap(719, Short.MAX_VALUE))
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
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLvl[0], GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void setBackController(BackController c) {
		btnBack.addActionListener(c);
	}
	
	public void setButtonControllers() {
	}
}