package boundaries;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import entities.Model;

public class InertDisplay extends TileDisplay {
	private static final long serialVersionUID = 1L;

	public InertDisplay(Model model) {
		super(model, null);

		setup();
	}

	/**
	 * sets up display of inert Tile
	 */
	@Override
	public void setup() {

		JLabel lblNewLabel = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(22)
						.addComponent(lblNewLabel)
						.addContainerGap(413, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(14)
						.addComponent(lblNewLabel)
						.addContainerGap(256, Short.MAX_VALUE))
				);
		setLayout(groupLayout);

	}
}
