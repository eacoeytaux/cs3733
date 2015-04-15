package boundaries;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TileDisplay extends JPanel {
	public TileDisplay() {
		
		JLabel label = new JLabel("1");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JLabel lblX = new JLabel("x2");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblX)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(label)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblX)
					.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addComponent(label)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
