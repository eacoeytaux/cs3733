package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.Application;
import boundaries.SelectGameModeDisplay;

public class PlayGameButtonController implements ActionListener {
	Application application;
	SelectGameModeDisplay sgmDisplay;
	
	public PlayGameButtonController(Application application, SelectGameModeDisplay sgmDisplay) {
		this.application = application;
		this.sgmDisplay = sgmDisplay;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		application.changePanel(sgmDisplay);
	}
}


