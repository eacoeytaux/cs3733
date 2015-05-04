package boundaries;

import javax.swing.JButton;

import entities.Game;
import junit.framework.TestCase;

public class TestStatDisplay extends TestCase {
	Game game;

	@Override
	public void setUp(){
		game = new Game(true);
	}
	
	@Override
	public void tearDown(){
		game.closeGame();
	}
	
	public void testButton(){
		Application application = game.getApplication();
		JButton button = application.mmDisplay.statsButton;
		button.doClick();
		
		assertTrue(application.currentDisplay instanceof LevelStatDisplay );
	}
}
