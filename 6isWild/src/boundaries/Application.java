package boundaries;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Game;

public class Application extends JFrame {
	private static final long serialVersionUID = 1L;

	Game game;

	MainMenuDisplay mmDisplay;
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
	}

	private void changePanel(JPanel newPanel) {
		getContentPane().removeAll();
		setContentPane(sgmDisplay);
		pack();
	}

	public void switchToGameTypeSelect() {
		changePanel(sgmDisplay);
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
