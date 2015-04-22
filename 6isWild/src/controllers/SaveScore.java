package controllers;

import entities.AbstractLevel;
import entities.Stat;
import entities.Info;
import boundaries.Application;

public class SaveScore {
	Application application;
	AbstractLevel level;
	
	public SaveScore(AbstractLevel level, Application application){
		this.application = application;
		this.level = level;
		Info info = level.getInfo();
		Stat stat = level.getStats();
		if(info.getScore() > stat.getScore())
		{
			stat.setScore(info.getScore());
			if(info.getScore() > info.getStarRequirements()[2]){
				stat.setStars(3);
			}
			else if(info.getScore() > info.getStarRequirements()[1]){
				stat.setStars(2);
			}
			else if(info.getScore() > info.getStarRequirements()[0]){
				stat.setStars(1);
			}
			else{
				return;
			}
		}
	}	
}
