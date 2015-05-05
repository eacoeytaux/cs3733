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
	
	public void testReleaseMode() {
		Application app = game.getApplication();
		app.changePanel(app.getSGMDisplay());
		SelectGameModeDisplay sgmDisplay = (SelectGameModeDisplay)app.getCurrentDisplay();
		sgmDisplay.getBtnRelease().doClick();
		
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
		
		assertTrue(lvlDisplay.getLevel().getInfo().getScore() >= 30);

//		assertEquals(5, lvlDisplay.getLevel().getInfo().getRemoves());
//		lvlDisplay.getBtnRemove().doClick();
//		assertEquals(4, lvlDisplay.getLevel().getInfo().getRemoves());
//
//		SquareDisplay sq4 = lvlDisplay.getBoardDisplay().getSquareDisplay(0, 2);
//
//		sq4.getMouseListeners()[0].mouseClicked(new MouseEvent(sq4.getParent(), MouseEvent.MOUSE_CLICKED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		
//		assertEquals(4, lvlDisplay.getBoardDisplay().getSquareDisplay(0, 2).getSquare().getTile().getValue());
//		
//		
//		SquareDisplay sq5 = lvlDisplay.getBoardDisplay().getSquareDisplay(8, 1);
//		SquareDisplay sq6 = lvlDisplay.getBoardDisplay().getSquareDisplay(8, 2);
//		sq5.getMouseListeners()[0].mousePressed(new MouseEvent(sq5.getParent(), MouseEvent.MOUSE_PRESSED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq6.getMouseListeners()[0].mouseEntered(new MouseEvent(sq6.getParent(), MouseEvent.MOUSE_ENTERED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq6.getMouseListeners()[0].mouseReleased(new MouseEvent(sq6.getParent(), MouseEvent.MOUSE_RELEASED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		
//		SquareDisplay sq7 = lvlDisplay.getBoardDisplay().getSquareDisplay(5, 8);
//		SquareDisplay sq8 = lvlDisplay.getBoardDisplay().getSquareDisplay(6, 8);
//		sq7.getMouseListeners()[0].mousePressed(new MouseEvent(sq7.getParent(), MouseEvent.MOUSE_PRESSED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq8.getMouseListeners()[0].mouseEntered(new MouseEvent(sq8.getParent(), MouseEvent.MOUSE_ENTERED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq8.getMouseListeners()[0].mouseReleased(new MouseEvent(sq8.getParent(), MouseEvent.MOUSE_RELEASED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//
//		assertEquals(5, lvlDisplay.getLevel().getInfo().getShuffles());
//		lvlDisplay.getBtnShuffle().doClick();
//		//assertEquals(4, lvlDisplay.getLevel().getInfo().getShuffles());
//		
//		SquareDisplay sq9 = lvlDisplay.getBoardDisplay().getSquareDisplay(4, 4);
//		SquareDisplay sq10 = lvlDisplay.getBoardDisplay().getSquareDisplay(6, 6);
//		
//		int sq9Val = sq9.getSquare().getTile().getValue();
//		int sq10Val = sq10.getSquare().getTile().getValue();
//		
//		lvlDisplay.getBtnSwap().doClick();
//		
//		sq9.getMouseListeners()[0].mouseClicked(new MouseEvent(sq9.getParent(), MouseEvent.MOUSE_CLICKED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq10.getMouseListeners()[0].mouseClicked(new MouseEvent(sq10.getParent(), MouseEvent.MOUSE_CLICKED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		
//		assertEquals(sq9Val, sq10.getSquare().getTile().getValue());
//		assertEquals(sq10Val, sq9.getSquare().getTile().getValue());
//		
//		for (int i = 0; i < 27; i++) {
//			sq1.getMouseListeners()[0].mousePressed(new MouseEvent(sq1.getParent(), MouseEvent.MOUSE_PRESSED, 
//					System.currentTimeMillis(), 0, 0, 0, 0, false));
//			sq2.getMouseListeners()[0].mouseEntered(new MouseEvent(sq2.getParent(), MouseEvent.MOUSE_ENTERED, 
//					System.currentTimeMillis(), 0, 0, 0, 0, false));
//			sq3.getMouseListeners()[0].mouseEntered(new MouseEvent(sq3.getParent(), MouseEvent.MOUSE_ENTERED, 
//					System.currentTimeMillis(), 0, 0, 0, 0, false));
//			sq3.getMouseListeners()[0].mouseReleased(new MouseEvent(sq3.getParent(), MouseEvent.MOUSE_RELEASED, 
//					System.currentTimeMillis(), 0, 0, 0, 0, false));
		}
	

	public void testPuzzleMode() {
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
		
		assertTrue(lvlDisplay.getLevel().getInfo().getScore() >= 30);

//		assertEquals(5, lvlDisplay.getLevel().getInfo().getRemoves());
//		lvlDisplay.getBtnRemove().doClick();
//		assertEquals(4, lvlDisplay.getLevel().getInfo().getRemoves());
//
//		SquareDisplay sq4 = lvlDisplay.getBoardDisplay().getSquareDisplay(0, 2);
//
//		sq4.getMouseListeners()[0].mouseClicked(new MouseEvent(sq4.getParent(), MouseEvent.MOUSE_CLICKED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		
//		assertEquals(4, lvlDisplay.getBoardDisplay().getSquareDisplay(0, 2).getSquare().getTile().getValue());
//		
//		
//		SquareDisplay sq5 = lvlDisplay.getBoardDisplay().getSquareDisplay(8, 1);
//		SquareDisplay sq6 = lvlDisplay.getBoardDisplay().getSquareDisplay(8, 2);
//		sq5.getMouseListeners()[0].mousePressed(new MouseEvent(sq5.getParent(), MouseEvent.MOUSE_PRESSED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq6.getMouseListeners()[0].mouseEntered(new MouseEvent(sq6.getParent(), MouseEvent.MOUSE_ENTERED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq6.getMouseListeners()[0].mouseReleased(new MouseEvent(sq6.getParent(), MouseEvent.MOUSE_RELEASED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		
//		SquareDisplay sq7 = lvlDisplay.getBoardDisplay().getSquareDisplay(5, 8);
//		SquareDisplay sq8 = lvlDisplay.getBoardDisplay().getSquareDisplay(6, 8);
//		sq7.getMouseListeners()[0].mousePressed(new MouseEvent(sq7.getParent(), MouseEvent.MOUSE_PRESSED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq8.getMouseListeners()[0].mouseEntered(new MouseEvent(sq8.getParent(), MouseEvent.MOUSE_ENTERED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq8.getMouseListeners()[0].mouseReleased(new MouseEvent(sq8.getParent(), MouseEvent.MOUSE_RELEASED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//
//		assertEquals(5, lvlDisplay.getLevel().getInfo().getShuffles());
//		lvlDisplay.getBtnShuffle().doClick();
//		//assertEquals(4, lvlDisplay.getLevel().getInfo().getShuffles());
//		
//		SquareDisplay sq9 = lvlDisplay.getBoardDisplay().getSquareDisplay(4, 4);
//		SquareDisplay sq10 = lvlDisplay.getBoardDisplay().getSquareDisplay(6, 6);
//		
//		int sq9Val = sq9.getSquare().getTile().getValue();
//		int sq10Val = sq10.getSquare().getTile().getValue();
//		
//		lvlDisplay.getBtnSwap().doClick();
//		
//		sq9.getMouseListeners()[0].mouseClicked(new MouseEvent(sq9.getParent(), MouseEvent.MOUSE_CLICKED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq10.getMouseListeners()[0].mouseClicked(new MouseEvent(sq10.getParent(), MouseEvent.MOUSE_CLICKED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		
//		assertEquals(sq9Val, sq10.getSquare().getTile().getValue());
//		assertEquals(sq10Val, sq9.getSquare().getTile().getValue());
//		
//		for (int i = 0; i < 22; i++) {
//			sq1.getMouseListeners()[0].mousePressed(new MouseEvent(sq1.getParent(), MouseEvent.MOUSE_PRESSED, 
//					System.currentTimeMillis(), 0, 0, 0, 0, false));
//			sq2.getMouseListeners()[0].mouseEntered(new MouseEvent(sq2.getParent(), MouseEvent.MOUSE_ENTERED, 
//					System.currentTimeMillis(), 0, 0, 0, 0, false));
//			sq3.getMouseListeners()[0].mouseEntered(new MouseEvent(sq3.getParent(), MouseEvent.MOUSE_ENTERED, 
//					System.currentTimeMillis(), 0, 0, 0, 0, false));
//			sq3.getMouseListeners()[0].mouseReleased(new MouseEvent(sq3.getParent(), MouseEvent.MOUSE_RELEASED, 
//					System.currentTimeMillis(), 0, 0, 0, 0, false));
		}
	}
