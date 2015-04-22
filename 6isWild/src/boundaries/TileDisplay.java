package boundaries;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import entities.Model;
import entities.Tile;

public class TileDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;
	
	Tile tile;

	public TileDisplay(Model model, Tile tile) {
		super(model);
		this.tile = tile;
		
		JLabel lblNewLabel = new JLabel("" + tile.getValue());
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblX = new JLabel("x" + tile.getMultiplier());
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblX)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblX)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(lblNewLabel)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	}
}
