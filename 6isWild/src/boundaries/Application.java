package boundaries;

import java.awt.Dimension;

import javax.swing.JFrame;

import controllers.BackController;
import controllers.PlayGameButtonController;
import controllers.SelectGameModeButtonController;
import controllers.StatsButtonController;
import entities.Game;
import entities.Model;

/**
 * The game model, which contains all displays
 * @author
 *
 */
public class Application extends JFrame {
	private static final long serialVersionUID = 1L;

	Model model;
	
	AbstractDisplay currentDisplay;

	MainMenuDisplay mmDisplay;
	LevelStatDisplay lsDisplay;
	SelectGameModeDisplay sgmDisplay;
	SelectLevelDisplay puzzle_slDisplay;
	SelectLevelDisplay lightning_slDisplay;
	SelectLevelDisplay elimination_slDisplay;
	SelectLevelDisplay release_slDisplay;
	LevelDisplay lDisplay;
	StatsDisplay sDisplay;

	public Application(Model model) {
		super();
		this.model = model;
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
		changePanel(mmDisplay);
	}

	/**
	 * initializes all menu displays, then initializes controllers for these menus
	 */
	private void init() {
		mmDisplay = new MainMenuDisplay(model, this);
		lsDisplay = new LevelStatDisplay(model, this);
		sgmDisplay = new SelectGameModeDisplay(model, this);
		sgmDisplay.initBoundaries();
		initControllers();
	}

	/**
	 * initializes controllers for menus. this includes button controllers
	 */
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

	/**
	 * Changes what is being displayed on the screen.
	 * @param nextDisplay the next Display to be displayed
	 */
	public void changePanel(AbstractDisplay nextDisplay) {
		if (nextDisplay != null) {
			getContentPane().removeAll();
			setContentPane(nextDisplay);
			nextDisplay.setup();
			currentDisplay = nextDisplay;
			pack();
		} else {
			System.out.println("ERROR: attempted to change to null display");
			//TODO print error
		}
	}

	/**
	 * changes the display to selectLevelDisplay corresponding to the game mode chosen
	 * @param gameType game mode chosen
	 */
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
	
	public LevelStatDisplay getLSDisplay(){
		return this.lsDisplay;
	}
	
	public LevelDisplay getLevelDisplay(){
		return this.lDisplay;
	}
}
