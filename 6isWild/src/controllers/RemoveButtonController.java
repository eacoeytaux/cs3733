package controllers;

import boundaries.LevelDisplay;
import entities.AbstractLevel;

public class RemoveButtonController {
	AbstractLevel level;
	LevelDisplay levelDisplay;
	
	public RemoveButtonController(AbstractLevel level, LevelDisplay levelDisplay) {
		this.level = level;
		this.levelDisplay = levelDisplay;
	}
}
