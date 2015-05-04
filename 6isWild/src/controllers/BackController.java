package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.AbstractDisplay;
import boundaries.Application;

/**
 * handles clicks on back button
 * @author Ethan Coeytaux
 *
 */
public class BackController implements ActionListener {
	Application application;
	AbstractDisplay previousDisplay;
	
	public BackController(Application application, AbstractDisplay previousPanel) {
		this.application = application;
		this.previousDisplay = previousPanel;
	}

	/**
	 * when clicked, return to previous display
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		application.changePanel(previousDisplay);
	}
}
