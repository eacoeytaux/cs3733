package controllers;

import java.awt.event.MouseEvent;

import entities.Game;
import junit.framework.TestCase;

public class TestSquareController extends TestCase {
	
	Game game;
	
	@Override
	public void setUp(){
		game = new Game();
	}
	
	@Override
	public void tearDown(){
		game.closeGame();
	}
	
	public void testSelect(){/*
		SquareController controller = new SquareController(game.getApplication().getLevelDisplay().getBoardDisplay().getSquareDisplay(0, 0));
		
		MouseEvent me = new MouseEvent(game.getContainer(), MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				fortyThieves.deckView.getX(), fortyThieves.deckView.getY(), 0, false);*/
	}
	
	

}
