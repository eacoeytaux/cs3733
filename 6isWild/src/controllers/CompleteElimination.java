package controllers;

import entities.EliminationLevel;
import boundaries.Application;
import controllers.SaveScore;


public class CompleteElimination {
	EliminationLevel level;
	Application app;
	
	public CompleteElimination(EliminationLevel level, Application app){
		this.level = level;
		this.app = app;
		new SaveScore(level, app);
	}
}
