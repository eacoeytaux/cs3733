package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.Application;
import boundaries.SelectLevelDisplay;

public class SelectGameModeButtonController implements ActionListener {
	Application application;
	SelectLevelDisplay gameModeDisplay;
	
	public SelectGameModeButtonController(Application application) {
		this.application = application;
	}
	
	public void setNextDisplay(SelectLevelDisplay gameModeDisplay) {
		this.gameModeDisplay = gameModeDisplay;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ha");
		application.changePanel(gameModeDisplay);
	}

}
