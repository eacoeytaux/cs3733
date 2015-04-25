package boundaries;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import entities.Square;

public class BuilderSquareDisplay extends JPanel {
	private static final long serialVersionUID = 1L;

	public static final int pixelSize = 62;

	BuilderBoardDisplay parent;

	AbstractDisplay display;
	Square square;

	public BuilderSquareDisplay(BuilderBoardDisplay parent, Square square) {
		this.parent = parent;
		this.square = square;

		setup();
	}

	public void setup() {
		if (square.isInert()) display = new InertDisplay(null);
		else if (square.isBucket()) display = new BucketDisplay(null);
		else display = new TileDisplay(null, square.getTile());

		this.removeAll();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(display, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(display, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addGap(12))
				);
		setLayout(groupLayout);
	}

	public void changeSquare() {
		square = parent.getNewSquare();
		setup();
	}
}