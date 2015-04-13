package controllers;

import boundaries.Application;
import entities.Game;

public class MouseListenerController {
	Application application;
	Game game;
	
	public MouseListenerController(Application application, Game game) {
		this.application = application;
		this.game = game;
	}
}
