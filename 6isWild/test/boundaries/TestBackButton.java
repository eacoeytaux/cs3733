package boundaries;


import javax.swing.JButton;

import junit.framework.TestCase;
import entities.Game;

public class TestBackButton extends TestCase {

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
		//JButton button = game.getApplication().lsDisplay.btnBack;
		//button.doClick();
	}
	
	
	

}
