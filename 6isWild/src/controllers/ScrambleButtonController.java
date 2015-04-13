package controllers;

import boundaries.LevelDisplay;
import entities.AbstractLevel;

public class ScrambleButtonController {
	AbstractLevel level;
	LevelDisplay levelDisplay;
	
	public ScrambleButtonController(AbstractLevel level, LevelDisplay levelDisplay) {
		this.level = level;
		this.levelDisplay = levelDisplay;
	}
}
