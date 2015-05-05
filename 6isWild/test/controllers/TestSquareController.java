package controllers;

import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import boundaries.Application;
import boundaries.LevelDisplay;
import boundaries.SelectGameModeDisplay;
import boundaries.SelectLevelDisplay;
import boundaries.SquareDisplay;
import entities.Game;

/**
 * 
 * @author Ethan Coeytaux
 *
 */
public class TestSquareController extends TestCase {

	Game game;

	@Override
	public void setUp(){
		game = new Game(true);
	}

	@Override
	public void tearDown(){
		game.closeGame();
	}
}
