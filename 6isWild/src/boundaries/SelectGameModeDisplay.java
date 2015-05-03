package boundaries;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.BackController;
import controllers.SelectGameModeButtonController;
import entities.Game;
import entities.Model;

/**
 * displays game mode selection menu
 * @author Hugh
 *
 */
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

	public SelectGameModeDisplay(Model model, Application application) {
		super(model);
		this.application = application;
		btnPuzzle = new JButton("");
		btnLightning = new JButton("");
		btnElimination = new JButton("");
		btnRelease = new JButton("");
		btnBack = new JButton("Back");
		
		try { //load images
			BufferedImage puzzle = ImageIO.read(getClass().getResourceAsStream("/PuzzleButton.png"));
			btnPuzzle.setIcon(new ImageIcon(puzzle));
			BufferedImage lightning = ImageIO.read(getClass().getResourceAsStream("/LightningButton.png"));
			btnLightning.setIcon(new ImageIcon(lightning));
			BufferedImage elimination = ImageIO.read(getClass().getResourceAsStream("/EliminationButton.png"));
			btnElimination.setIcon(new ImageIcon(elimination));
			BufferedImage release = ImageIO.read(getClass().getResourceAsStream("/ReleaseButton.png"));
			btnRelease.setIcon(new ImageIcon(release));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setup();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try { //load images
			BufferedImage background = ImageIO.read(getClass().getResourceAsStream("/LevelSelectScreen.png"));
			g.drawImage(background, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * sets up Select game mode display
	 */
	@Override
	public void setup() {
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLightning, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnElimination, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(189)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnElimination, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLightning, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		setLayout(groupLayout);
	}

	/**
	 * creates level select menu display for all game modes, then sets back button controllers for the menus
	 */
	public void initBoundaries() { //TODO pass level data
		puzzleLevelDisplay = new SelectLevelDisplay(model, application, Game.PUZZLE_ID);
		puzzleLevelDisplay.setBackController(new BackController(application, this));

		lightningLevelDisplay = new SelectLevelDisplay(model, application, Game.LIGHTNING_ID);
		lightningLevelDisplay.setBackController(new BackController(application, this));

		eliminationLevelDisplay = new SelectLevelDisplay(model, application, Game.ELIMINATION_ID);
		eliminationLevelDisplay.setBackController(new BackController(application, this));

		releaseLevelDisplay = new SelectLevelDisplay(model, application, Game.RELEASE_ID);
		releaseLevelDisplay.setBackController(new BackController(application, this));
	}

	/**
	 * adds an action listener to back button
	 * @param c controller for back button
	 */
	public void setBackController(BackController c) {
		btnBack.addActionListener(c);
	}

	/**
	 * sets next display to be this game mode's level select, and adds action listener to this game modes button in select game mode menu
	 * @param c controller for select Game mode button
	 */
	public void setPuzzleButtonController(SelectGameModeButtonController c) {
		c.setNextDisplay(puzzleLevelDisplay);
		btnPuzzle.addActionListener(c);
	}

	/**
	 * sets next display to be this game mode's level select, and adds action listener to this game modes button in select game mode menu
	 * @param c controller for select Game mode button
	 */
	public void setLightningButtonController(SelectGameModeButtonController c) {
		c.setNextDisplay(lightningLevelDisplay);
		btnLightning.addActionListener(c);
	}

	/**
	 * sets next display to be this game mode's level select, and adds action listener to this game modes button in select game mode menu
	 * @param c controller for select Game mode button
	 */
	public void setEliminationButtonController(SelectGameModeButtonController c) {
		c.setNextDisplay(eliminationLevelDisplay);
		btnElimination.addActionListener(c);
	}

	/**
	 * sets next display to be this game mode's level select, and adds action listener to this game modes button in select game mode menu
	 * @param c controller for select Game mode button
	 */
	public void setReleaseButtonController(SelectGameModeButtonController c) {
		c.setNextDisplay(releaseLevelDisplay);
		btnRelease.addActionListener(c);
	}
}
