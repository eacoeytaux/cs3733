package entities;

import junit.framework.TestCase;
import boundaries.Application;

public class TestBoard extends TestCase {
	
	Board b;
	@Override
	public void setUp(){
		Square[][] squares = new Square[9][9];
		int[] vf, mf;
		vf = new int[2];
		mf = new int[2];
		b = new Board(squares, vf, mf);
		
	}
	
	@Override
	public void tearDown(){
	}
	
	public void testBoard(){
		Model m = new Model();
		Application app = new Application(m, false);
		
//		sq1.getMouseListeners()[0].mousePressed(new MouseEvent(sq1.getParent(), MouseEvent.MOUSE_PRESSED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq2.getMouseListeners()[0].mouseEntered(new MouseEvent(sq2.getParent(), MouseEvent.MOUSE_ENTERED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq3.getMouseListeners()[0].mouseEntered(new MouseEvent(sq3.getParent(), MouseEvent.MOUSE_ENTERED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
//		sq3.getMouseListeners()[0].mouseReleased(new MouseEvent(sq3.getParent(), MouseEvent.MOUSE_RELEASED, 
//				System.currentTimeMillis(), 0, 0, 0, 0, false));
	}

}
