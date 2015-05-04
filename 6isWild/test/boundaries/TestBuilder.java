package boundaries;

import junit.framework.TestCase;
import entities.Builder;

public class TestBuilder extends TestCase {
	Builder builder;
	
	@Override
	public void setUp() {
		builder = new Builder();
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
	}
}
