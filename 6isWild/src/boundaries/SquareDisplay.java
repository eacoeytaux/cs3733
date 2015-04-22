package boundaries;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import entities.Model;
import entities.Square;

public class SquareDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;
	
	public static final int pixelSize = 62;
	
	TileDisplay tileDisplay;
	Square square;

	public SquareDisplay(Model model, Square square) {
		super(model);
		this.square = square;

		tileDisplay = new TileDisplay(model, square.getTile());
	
		setup();
	}

	@Override
	public void setup() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tileDisplay, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tileDisplay, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addGap(12))
		);
		setLayout(groupLayout);
	}
}
