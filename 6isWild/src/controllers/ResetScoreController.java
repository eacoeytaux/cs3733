package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import boundaries.LevelStatDisplay;
import entities.AbstractLevel;
import entities.Model;
import entities.Stat;

/**
 * Resets the players save file to make all levels 0 points and zero stars
 * @author Jon Sawin 
 */

public class ResetScoreController implements ActionListener{
	Model model;
	LevelStatDisplay display;
	
	public ResetScoreController(Model model, LevelStatDisplay display)
	{
		this.model = model;
		this.display = display;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<AbstractLevel> levels = model.getLevels();
		for(AbstractLevel level : levels)
		{
			try {
				System.out.println("resetting high scores for level " + level.getLevelType() + " " + level.getLevel());
				BufferedReader file = new BufferedReader(new FileReader("res/Scores.txt"));
				String input = "";
				String line;

				while ((line = file.readLine()) != null) input += line + '\n';

				file.close();

				System.out.println(input);

				input = input.replace(level.getLevelType() + " " + level.getLevel() + " " + level.getStats().getScore() + " " + level.getStats().getStars(), level.getLevelType() + " " + level.getLevel() + " " + 0 + " " + 0);
				model.getGlobalStats().setStats(new Stat(0,0), level.getLevelType(), level.getLevel(), true);
				System.out.println("----------------------------------"  + '\n' + input);

				FileOutputStream fileOut = new FileOutputStream("res/Scores.txt");
				fileOut.write(input.getBytes());
				fileOut.close();

			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		
		display.setup();
	}

}
