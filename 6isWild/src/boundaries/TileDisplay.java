package boundaries;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.LayoutStyle.ComponentPlacement;

public class TileDisplay extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TileDisplay() {
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblX = new JLabel("x2");
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
}
