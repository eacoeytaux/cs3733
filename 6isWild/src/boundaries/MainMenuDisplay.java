package boundaries;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import controllers.PlayGameButtonController;
import controllers.StatsButtonController;

public class MainMenuDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;
	
	Application application;
	BufferedImage background;

	JButton playGameButton;
	JButton statsButton;

	public MainMenuDisplay(Application application) {
		this.application = application;
		this.background = null;

		playGameButton = new JButton("PLAY GAME");

		statsButton = new JButton("STATS");
		
		setup();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try { //load images
			background = ImageIO.read(getClass().getResourceAsStream("/TitleScreen.png"));
			g.drawImage(background, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setup() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(303)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(statsButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(playGameButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(333))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(300)
					.addComponent(playGameButton)
					.addGap(50)
					.addComponent(statsButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
