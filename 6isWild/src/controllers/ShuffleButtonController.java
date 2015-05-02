package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.BoardDisplay;
import boundaries.LevelDisplay;
import entities.AbstractLevel;

public class ShuffleButtonController implements ActionListener {
	LevelDisplay levelDisplay;

	public ShuffleButtonController(LevelDisplay levelDisplay) {
		this.levelDisplay = levelDisplay;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!isValid()) return;

		levelDisplay.getLevel().getBoard().shuffleBoard();

		BoardDisplay boardDisplay = levelDisplay.getBoardDisplay();

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
