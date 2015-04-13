package controllers;

import entities.AbstractLevel;
import boundaries.LevelDisplay;

public class IncreaseScore {
	AbstractLevel level;
	LevelDisplay levelDisplay;
	
	public IncreaseScore(AbstractLevel level, LevelDisplay levelDisplay){
		this.level = level;
		this.levelDisplay = levelDisplay;
	}
}
