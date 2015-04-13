package controllers;

import boundaries.LevelDisplay;
import entities.AbstractLevel;

public class MakeMove {
	LevelDisplay levelScreen;
	AbstractLevel level;

	public MakeMove(AbstractLevel level, LevelDisplay levelScreen){
		this.level=level;
		this.levelScreen = levelScreen;
	}
}
