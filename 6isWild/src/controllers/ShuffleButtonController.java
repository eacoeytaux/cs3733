package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import boundaries.BoardDisplay;
import boundaries.LevelDisplay;
import entities.AbstractLevel;
import entities.Game;

/**
 * shuffles board when called upon
 * @author Ethan Coeytaux
 *
 */
public class ShuffleButtonController implements ActionListener {
	JButton shuffleButton;
	LevelDisplay levelDisplay;
	AbstractLevel level;

	public ShuffleButtonController(JButton shuffleButton, LevelDisplay levelDisplay) {
		this.shuffleButton = shuffleButton;
		this.levelDisplay = levelDisplay;
		this.level = levelDisplay.getLevel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (level.getInfo().getShuffles() <= 0) return;
		
		levelDisplay.getLevel().getInfo().decrementShuffles();
		shuffleButton.setText("Shuffles: " + levelDisplay.getLevel().getInfo().getShuffles());
		levelDisplay.getLevel().getBoard().shuffleBoard();

		BoardDisplay boardDisplay = levelDisplay.getBoardDisplay();

		if (level.getLevelType() == Game.RELEASE_ID) level.getBoard().checkBoard();
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				boardDisplay.updateTile(i, j);
			}
		}

		levelDisplay.setup();
	}

	public boolean isValid() {
		return true; //TODO check to make sure there are shuffle moves left
	}
}
