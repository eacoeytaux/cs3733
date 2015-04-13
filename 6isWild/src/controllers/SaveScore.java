package controllers;

import entities.Stat;
import boundaries.Application;

public class SaveScore {
	Stat stat;
	Application application;
	
	public SaveScore(Stat stat, Application application){
		this.stat = stat;
		this.application = application;
	}
}
