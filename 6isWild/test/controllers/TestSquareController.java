package controllers;

import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import boundaries.Application;
import boundaries.LevelDisplay;
import boundaries.SelectGameModeDisplay;
import boundaries.SelectLevelDisplay;
import boundaries.SquareDisplay;
import entities.Game;

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
	
	public void testSelect(){
		Application app = game.getApplication();
		app.changePanel(app.getSGMDisplay());
		SelectGameModeDisplay sgmDisplay = (SelectGameModeDisplay)app.getCurrentDisplay();
		sgmDisplay.getBtnPuzzle().doClick();
		
		SelectLevelDisplay selectLvlDisplay = (SelectLevelDisplay)app.getCurrentDisplay();
		selectLvlDisplay.getBtnLvl(0).doClick();
		
		LevelDisplay lvlDisplay = (LevelDisplay)app.getCurrentDisplay();
		
		SquareDisplay sq1 = lvlDisplay.getBoardDisplay().getSquareDisplay(0, 0);
		SquareDisplay sq2 = lvlDisplay.getBoardDisplay().getSquareDisplay(1, 0);
		SquareDisplay sq3 = lvlDisplay.getBoardDisplay().getSquareDisplay(2, 0);
		
		sq1.getMouseListeners()[0].mousePressed(new MouseEvent(sq1.getParent(), MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 0, 0, 0, false));
		sq2.getMouseListeners()[0].mouseEntered(new MouseEvent(sq2.getParent(), MouseEvent.MOUSE_ENTERED, 
				System.currentTimeMillis(), 0, 0, 0, 0, false));
		sq3.getMouseListeners()[0].mouseEntered(new MouseEvent(sq3.getParent(), MouseEvent.MOUSE_ENTERED, 
				System.currentTimeMillis(), 0, 0, 0, 0, false));
		sq3.getMouseListeners()[0].mouseReleased(new MouseEvent(sq3.getParent(), MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 0, 0, 0, false));
		
		System.out.println(lvlDisplay.getLevel().getInfo().getScore());
	}
	
	

}
