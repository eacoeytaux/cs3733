package controllers;

/**
 * 
 * @author Jon Sawin
 * 
 */

import entities.EliminationLevel;
import controllers.SaveScore;


public class CompleteElimination {
	EliminationLevel level;
	
	public CompleteElimination(EliminationLevel level){
		this.level = level;
		//new SaveScore(level);
	}
}
