package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import entities.AbstractLevel;
import entities.Model;

public class ResetScoreController implements ActionListener{
	Model model;
	ResetScoreController(Model model)
	{
		this.model = model;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<AbstractLevel> levels = model.getLevels();
		for(AbstractLevel level : levels)
		{
			try {
				System.out.println("resetting high scores");
				BufferedReader file = new BufferedReader(new FileReader("res/Scores.txt"));
				String input = "";
				String line;

				while ((line = file.readLine()) != null) input += line + '\n';

				file.close();

				System.out.println(input);

				input = input.replace(level.getLevelType() + " " + level.getLevel() + " " + level.getStats().getScore() + " " + level.getStats().getStars(), level.getLevelType() + " " + level.getLevel() + " " + 0 + " " + 0);

				System.out.println("----------------------------------"  + '\n' + input);

				FileOutputStream fileOut = new FileOutputStream("res/Scores.txt");
				fileOut.write(input.getBytes());
				fileOut.close();

			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
	}

}
