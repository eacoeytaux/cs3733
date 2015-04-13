package controllers;

import entities.PuzzleLevel;
import boundaries.Application;

public class CompletePuzzle {
	PuzzleLevel level;
	Application app;
	
	public CompletePuzzle(PuzzleLevel level, Application app){
		this.level = level;
		this.app = app;
	}
}
