package controllers;

/*******
 * 
 * @author Jon Sawin
 * 
 */

import entities.PuzzleLevel;
import boundaries.Application;

public class CompletePuzzle {
	PuzzleLevel level;
	Application app;
	
	public CompletePuzzle(PuzzleLevel level, Application app){
		this.level = level;
		this.app = app;
		new SaveScore(level, app);
	}
}
