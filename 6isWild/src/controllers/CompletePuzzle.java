package controllers;

/*******
 * 
 * @author Jon Sawin
 * 
 */

import entities.PuzzleLevel;

public class CompletePuzzle {
	PuzzleLevel level;
	
	public CompletePuzzle(PuzzleLevel level){
		System.out.println("called Puzzlelvl");
		this.level = level;
		new SaveScore(level);
	}
}
