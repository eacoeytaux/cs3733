package controllers;

import entities.LightningLevel;
import boundaries.Application;

public class CompleteLightning {
	LightningLevel level;
	Application app;
	
	public CompleteLightning(LightningLevel level, Application app){
		this.level = level;
		this.app = app;
		new SaveScore(level, app);
	}
}
