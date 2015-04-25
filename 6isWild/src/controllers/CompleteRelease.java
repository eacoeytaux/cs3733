package controllers;

import entities.ReleaseLevel;
import boundaries.Application;

public class CompleteRelease {
	ReleaseLevel level;
	Application app;
	
	public CompleteRelease(ReleaseLevel level, Application app){
		this.level = level;
		this.app = app;
		new SaveScore(level, app);
	}
}
