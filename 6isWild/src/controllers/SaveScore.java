package controllers;

import entities.AbstractLevel;
import entities.Model;
import entities.Stat;
import entities.Info;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * saves score when level is complete
 * @author Jon Sawin
 *
 */
public class SaveScore {
	AbstractLevel level;
	Model model;

	/**
	 * saves scores and updates stars
	 * @param level
	 * @param application
	 */
	public SaveScore(AbstractLevel level, Model model){
		this.model = model;
		System.out.println("called savescore");
		this.level = level;
		recordScore();        
	}

	public void recordScore()
	{
		Boolean hasSetScore = false;
		Info info = level.getInfo();
		Stat stat = level.getStats();
		int oldHighScore = stat.getScore();
		int oldHighStars = stat.getStars();
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
			try {
				System.out.println("writing high score");
				BufferedReader file = new BufferedReader(new FileReader("res/Scores.txt"));
				String input = "";
				String line;

				while ((line = file.readLine()) != null) input += line + '\n';

				file.close();

				System.out.println(input);
				


				if(input.contains(level.getLevelType() + " " + level.getLevel())) 
				{
					input = input.replace(level.getLevelType() + " " + level.getLevel() + " " + oldHighScore + " " + oldHighStars, level.getLevelType() + " " + level.getLevel() + " " + stat.getScore() + " " + stat.getStars());
				}

				System.out.println("----------------------------------"  + '\n' + input);
				
				FileOutputStream fileOut = new FileOutputStream("res/Scores.txt");
				fileOut.write(input.getBytes());
				if(!input.contains(level.getLevelType() + " " + level.getLevel())) 
				{
					fileOut.write((level.getLevelType() + " " + level.getLevel() + " " + stat.getScore() + " " + stat.getStars() + "\n").getBytes());
				}
				fileOut.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.getGlobalStats().setStats(stat, level.getLevelType(), level.getLevel(), false);
		}
	}	
}
