package boundaries;


import java.awt.Window;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import boundaries.LevelStatDisplay;
import entities.Game;
import junit.framework.TestCase;

public class TestBackButton extends TestCase {

	Game game;

	@Override
	public void setUp(){
		game = new Game();
	}
	
	@Override
	public void tearDown(){
		game.closeGame();
	}
	
	public void testButton(){
		JButton button = game.getApplication().lsDisplay.btnBack;
		button.doClick();
		
		/*
		MouseEvent me = new MouseEvent(game.getApplication(), MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				lsDisplay.getX(), lsDisplay.getY(), 0, false);
		

		lsDisplay.getMouseManager().handleMouseEvent(me);*/
		
		
	}
	
	
	

}
