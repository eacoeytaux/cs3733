package controllers;

/*******
 * 
 * @author Jon Sawin
 * 
 */

import entities.AbstractLevel;
import entities.Stat;
import entities.Info;
import boundaries.Application;

/**
 * saves score when level is complete
 * @author 
 *
 */
public class SaveScore {
	Application application;
	AbstractLevel level;
	
	/**
	 * saves scores and updates stars
	 * @param level
	 * @param application
	 */
	public SaveScore(AbstractLevel level, Application application){
		this.application = application;
		this.level = level;
		Info info = level.getInfo();
		Stat stat = level.getStats();
		if(info.getScore() > stat.getScore())  //if the score from the completed level is higher than the recorded high score
		{
			System.out.println("New High score");
			stat.setScore(info.getScore());   //assign the level's score as the new high score
			
			/*
			 * Check how many stars the player has earned, and assign that in the stats
			 */
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
