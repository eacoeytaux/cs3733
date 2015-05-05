package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.Application;
import boundaries.SelectGameModeDisplay;

/**
 * brings the user to the level select screen 
 * @author Ethan Coeytaux
 *
 */
public class PlayGameButtonController implements ActionListener {
	Application application;
	SelectGameModeDisplay sgmDisplay;
	
	public PlayGameButtonController(Application application, SelectGameModeDisplay sgmDisplay) {
		this.application = application;
		this.sgmDisplay = sgmDisplay;
	}
	
	/**
	 * brings the user to the level select screen 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		application.changePanel(sgmDisplay);
	}
}


