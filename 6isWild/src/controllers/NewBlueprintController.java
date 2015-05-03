package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.BlueprintDisplay;
import boundaries.BuilderApplication;

/**
 * resets the blueprint in builder to start a new board
 * @author Ethan Coeytaux
 *
 */
public class NewBlueprintController implements ActionListener {
	BuilderApplication application;
	
	public NewBlueprintController(BuilderApplication application) {
		this.application = application;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		application.getParentBuilder().makeNewBlueprint();
		application.setDisplay(new BlueprintDisplay(application.getParentBuilder()));
		application.getContentPane().removeAll();
		application.setContentPane(application.getDisplay());
		application.pack();
	}

}
