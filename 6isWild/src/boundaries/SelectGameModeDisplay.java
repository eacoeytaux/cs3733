package boundaries;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.BackController;
import controllers.SelectGameModeButtonController;
import entities.Game;

public class SelectGameModeDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;

	Application application;

	SelectLevelDisplay puzzleLevelDisplay;
	SelectLevelDisplay lightningLevelDisplay;
	SelectLevelDisplay eliminationLevelDisplay;
	SelectLevelDisplay releaseLevelDisplay;
	
	JButton btnPuzzle;
	JButton btnLightning;
	JButton btnElimination;
	JButton btnRelease;
	
	JButton btnBack;
	
	public SelectGameModeDisplay(Application application) {
		this.application = application;
		
		btnLightning = new JButton("LIGHTNING");
		btnElimination = new JButton("ELIMINATION");
		btnPuzzle = new JButton("PUZZLE");
		btnRelease = new JButton("RELEASE");
		btnBack = new JButton("Back");
		
		setup();
	}
	
	@Override
	public void setup() {
		JLabel lblSelectAGame = new JLabel("SELECT A GAME MODE");
		lblSelectAGame.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(147)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSelectAGame)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnLightning)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnElimination, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(lblSelectAGame)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnElimination, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLightning, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
					.addGap(90))
		);
		setLayout(groupLayout);
	}
	
	public void initBoundaries() { //TODO pass level data
		puzzleLevelDisplay = new SelectLevelDisplay(application, Game.PUZZLE_ID);
		puzzleLevelDisplay.setBackController(new BackController(application, this));
		
		lightningLevelDisplay = new SelectLevelDisplay(application, Game.LIGHTNING_ID);
		lightningLevelDisplay.setBackController(new BackController(application, this));
		
		eliminationLevelDisplay = new SelectLevelDisplay(application, Game.ELIMINATION_ID);
		eliminationLevelDisplay.setBackController(new BackController(application, this));
		
		releaseLevelDisplay = new SelectLevelDisplay(application, Game.RELEASE_ID);
		releaseLevelDisplay.setBackController(new BackController(application, this));
	}
	
	public void setBackController(BackController c) {
		btnBack.addActionListener(c);
	}
	
	public void setPuzzleButtonController(SelectGameModeButtonController c) {
		c.setNextDisplay(puzzleLevelDisplay);
		btnPuzzle.addActionListener(c);
	}
	
	public void setLightningButtonController(SelectGameModeButtonController c) {
		c.setNextDisplay(lightningLevelDisplay);
		btnLightning.addActionListener(c);
	}
	
	public void setEliminationButtonController(SelectGameModeButtonController c) {
		c.setNextDisplay(eliminationLevelDisplay);
		btnElimination.addActionListener(c);
	}
	
	public void setReleaseButtonController(SelectGameModeButtonController c) {
		c.setNextDisplay(releaseLevelDisplay);
		btnRelease.addActionListener(c);
	}
}
