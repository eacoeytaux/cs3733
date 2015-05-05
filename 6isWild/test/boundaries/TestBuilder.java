package boundaries;

import junit.framework.TestCase;
import entities.Builder;
import entities.IBuilderMove;
import entities.SquareBuilderMove;

public class TestBuilder extends TestCase {
	Builder builder;
	
	@Override
	public void setUp() {
		builder = new Builder(true);
	}
	
	@Override
	public void tearDown() {
		builder.closeBuilder();
	}
	
	public void testSimple() {
		builder.getBuilderApplication().getDisplay().getBoardDisplay().getSquareDisplay(0, 0).changeSquare();
		
		assertTrue(builder.getBuilderApplication().getDisplay().getBoardDisplay().getSquareDisplay(0, 0).getSquare().isInert());
		
		builder.getBuilderApplication().getDisplay().tileTypeComboBox.setSelectedIndex(3);
		builder.getBuilderApplication().getDisplay().getBoardDisplay().getSquareDisplay(0, 1).changeSquare();

		assertEquals(2, builder.getBuilderApplication().getDisplay().getBoardDisplay().getSquareDisplay(0, 1).getSquare().getTile().getValue());

		BuilderSquareDisplay bsq1 = builder.getBuilderApplication().getDisplay().getBoardDisplay().getSquareDisplay(0, 0);
		IBuilderMove move = new SquareBuilderMove(bsq1);
		move.doMove();
		
		builder.pushRedo(move);	
	}
}
