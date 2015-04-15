package boundaries;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import entities.Model;

public class SquareDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;
	
	TileDisplay tile;

	public SquareDisplay(Model model) {
		super(model);

		tile = new TileDisplay(model);
		setup();
	}

	@Override
	public void setup() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(tile, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(tile, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addContainerGap())
				);
		setLayout(groupLayout);
	}
}
