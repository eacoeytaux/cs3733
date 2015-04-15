package boundaries;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class MainMenuDisplay extends JPanel {
	public MainMenuDisplay() {
		
		JButton btnNewButton = new JButton("PLAY GAME!");
		
		JButton btnStats = new JButton("STATS!");
		
		JLabel lblSixIsWild = new JLabel("Six is Wild!");
		lblSixIsWild.setFont(new Font("Lucida Grande", Font.PLAIN, 55));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(171, Short.MAX_VALUE)
					.addComponent(lblSixIsWild)
					.addGap(251))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(348)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnStats, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(333))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(158)
					.addComponent(lblSixIsWild)
					.addGap(46)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnStats)
					.addContainerGap(254, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
