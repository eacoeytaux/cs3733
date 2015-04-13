package controllers;

import boundaries.LevelDisplay;
import entities.AbstractLevel;
import entities.Square;

public class ShuffleButtonController {
	AbstractLevel level;
	LevelDisplay levelDisplay;
	Square square1;
	Square square2;
	
	public ShuffleButtonController(AbstractLevel level, LevelDisplay levelDisplay, Square square1, Square square2) {
		this.level = level;
		this.levelDisplay = levelDisplay;
		this.square1 = square1;
		this.square2 = square2;
	}
}
