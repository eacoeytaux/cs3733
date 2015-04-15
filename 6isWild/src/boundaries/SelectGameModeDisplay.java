package boundaries;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.BackController;
import controllers.SelectGameModeButtonController;
import entities.Game;
import entities.Model;

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

		btnLightning = new JButton("LIGHTNING");
		btnElimination = new JButton("ELIMINATION");
		btnPuzzle = new JButton("PUZZLE");
		btnRelease = new JButton("RELEASE");
		btnBack = new JButton("Back");

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
												.addGap(146)
												.addComponent(btnLightning)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btnElimination, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
												.addGap(12)
												.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
												.addContainerGap(158, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGap(207)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLightning, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnElimination, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
								.addGap(19))
				);
		setLayout(groupLayout);
	}

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
