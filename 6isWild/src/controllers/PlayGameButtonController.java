package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import boundaries.Application;
import entities.Game;

public class PlayGameButtonController implements ActionListener {
	Application application;

	public PlayGameButtonController(Application application){
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		application.switchToGameTypeSelect();
	}
}

