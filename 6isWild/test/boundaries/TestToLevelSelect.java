package boundaries;

import javax.swing.JButton;

import entities.Game;
import junit.framework.TestCase;

public class TestToLevelSelect extends TestCase {
	Game game;

	@Override
	public void setUp(){
		game = new Game(true);
	}
	
	@Override
	public void tearDown(){
		game.closeGame();
	}
	
	public void testToLevelSelect(){
		//JButton button = game.getApplication().sgmDisplay.btnPuzzle;
		//button.doClick();
	}
}
