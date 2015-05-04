package boundaries;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import entities.Model;

/**
 * Display of an inert tile
 * @author Ethan Coeytaux
 *
 */
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
		
		setBackground(Color.BLACK);

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
