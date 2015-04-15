package controllers;

import boundaries.LevelDisplay;
import entities.AbstractLevel; 
import entities.Stat;
import entities.Game;

public class PlayGameButtonController {
	String type;
	int n;
	Game game;
	AbstractLevel level;
	
	public PlayGameButtonController(String type, int n, Game game){
		this.level = requestLevel();
		this.game = game;
			if(isValid()){
				
		}
	}
	
	private boolean isValid(){
		Stat sample = level.getStats();
		return sample.getStars() < 1;
	}
	
	private AbstractLevel requestLevel(){
		return level;
		
	}
	
}
		

