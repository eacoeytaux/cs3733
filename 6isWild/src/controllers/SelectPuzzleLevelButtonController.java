package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.Application;
import boundaries.LevelDisplay;
import entities.Model;

/**
 * 
 * @author 
 *
 */
public class SelectPuzzleLevelButtonController implements ActionListener {
	Model model;
	Application application;
	LevelDisplay lvlDisplay;
	
	public SelectPuzzleLevelButtonController(Model model, Application application, LevelDisplay lvlDisplay) {
		this.model = model;
		this.application = application;
		this.lvlDisplay = lvlDisplay;
	}

	/**
	 * on click reinitialize board and update panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		lvlDisplay.reinitBoard();
		application.changePanel(lvlDisplay);
	}

}
