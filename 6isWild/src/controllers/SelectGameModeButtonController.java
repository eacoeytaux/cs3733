package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.Application;
import boundaries.SelectLevelDisplay;

/**
 * selects the game mode
 * @author 
 *
 */
public class SelectGameModeButtonController implements ActionListener {
	Application application;
	SelectLevelDisplay gameModeDisplay;
	
	public SelectGameModeButtonController(Application application) {
		this.application = application;
	}
	
	/**
	 * prepares and changes next display
	 * @param gameModeDisplay
	 */
	public void setNextDisplay(SelectLevelDisplay gameModeDisplay) {
		this.gameModeDisplay = gameModeDisplay;
	}

	/**
	 * on click, set next display
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		application.changePanel(gameModeDisplay);
	}

}
