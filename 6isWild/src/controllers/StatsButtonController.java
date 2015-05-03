package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.Application;
import boundaries.LevelStatDisplay;

/**
 * handles click on stats button in main menu
 * @author 
 *
 */
public class StatsButtonController implements ActionListener {
	Application application;
	LevelStatDisplay lsDisplay;
	
	public StatsButtonController(Application application, LevelStatDisplay lsDisplay) {
		this.application = application;
		this.lsDisplay = lsDisplay;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		application.changePanel(lsDisplay);
	}
}
	
