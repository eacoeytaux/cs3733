package entities;

import boundaries.Application;
import junit.framework.TestCase;

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
	}

}
