package boundaries;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.PlayGameButtonController;
import controllers.StatsButtonController;

public class MainMenuDisplay extends JPanel {
	Application application;
	JButton playGameButton;
	JButton statsButton;
	
	public MainMenuDisplay(Application applicatione) {
		this.application = application;
		
		playGameButton = new JButton("PLAY GAME!");
		
		statsButton = new JButton("STATS!");
		
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
						.addComponent(statsButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(playGameButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(333))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(158)
					.addComponent(lblSixIsWild)
					.addGap(46)
					.addComponent(playGameButton)
					.addGap(18)
					.addComponent(statsButton)
					.addContainerGap(254, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void setPlayGameButtonController(PlayGameButtonController c) {
		playGameButton.addActionListener(c);
	}
	
	public void setStatsButtonController(StatsButtonController c) {
		statsButton.addActionListener(c);
	}
}
