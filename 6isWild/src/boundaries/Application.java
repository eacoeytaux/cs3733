package boundaries;

import java.awt.Dimension;

import javax.swing.JFrame;

import controllers.BackController;
import controllers.PlayGameButtonController;
import controllers.SelectGameModeButtonController;
import controllers.StatsButtonController;
import entities.Game;

public class Application extends JFrame {
	private static final long serialVersionUID = 1L;

	Game game;

	MainMenuDisplay mmDisplay;
	LevelStatDisplay lsDisplay;
	SelectGameModeDisplay sgmDisplay;
	SelectLevelDisplay puzzle_slDisplay;
	SelectLevelDisplay lightning_slDisplay;
	SelectLevelDisplay elimination_slDisplay;
	SelectLevelDisplay release_slDisplay;
	LevelDisplay lDisplay;
	StatsDisplay sDisplay;

	public Application(Game game) {
		super();
		this.game = game;
		init();
		SplashScreenDisplay splashScreenDisplay = new SplashScreenDisplay();
		setContentPane(splashScreenDisplay);
		setPreferredSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		splashScreenDisplay.setSplashScreen();
		getContentPane().removeAll();
		setContentPane(mmDisplay);
		pack();
	}

	private void init() {
		mmDisplay = new MainMenuDisplay(this);
		lsDisplay = new LevelStatDisplay(this);
		sgmDisplay = new SelectGameModeDisplay(this);
		sgmDisplay.initBoundaries();
		initControllers();
	}

	private void initControllers() {
		mmDisplay.setPlayGameButtonController(new PlayGameButtonController(this, sgmDisplay));
		mmDisplay.setStatsButtonController(new StatsButtonController(this, lsDisplay));
		
		lsDisplay.setBackController(new BackController(this, mmDisplay));

		sgmDisplay.setBackController(new BackController(this, mmDisplay));
		sgmDisplay.setPuzzleButtonController(new SelectGameModeButtonController(this));
		sgmDisplay.setLightningButtonController(new SelectGameModeButtonController(this));
		sgmDisplay.setEliminationButtonController(new SelectGameModeButtonController(this));
		sgmDisplay.setReleaseButtonController(new SelectGameModeButtonController(this));
	}

	public void changePanel(AbstractDisplay newPanel) {
		if (newPanel != null) {
			getContentPane().removeAll();
			setContentPane(newPanel);
			newPanel.setup();
			pack();
		} else {
			System.out.println("ERROR: attempted to change to null panel");
			//TODO print error
		}
	}

	public void switchToLevelSelect(int gameType) {
		switch (gameType) {
		case Game.PUZZLE_ID:
			changePanel(puzzle_slDisplay);
			break;
		case Game.LIGHTNING_ID:
			changePanel(lightning_slDisplay);
			break;
		case Game.ELIMINATION_ID:
			changePanel(elimination_slDisplay);
			break;
		case Game.RELEASE_ID:
			changePanel(release_slDisplay);
			break;
		}
	}

	public void switchToLevel(int gameType, int levelNum) {
		/*switch (gameType) {
		case Game.PUZZLE_ID:
			changePanel(puzzle_slDisplay);
			break;
		case Game.LIGHTNING_ID:
			changePanel(lightning_slDisplay);
			break;
		case Game.ELIMINATION_ID:
			changePanel(elimination_slDisplay);
			break;
		case Game.RELEASE_ID:
			changePanel(release_slDisplay);
			break;
		}*/
	}
}
