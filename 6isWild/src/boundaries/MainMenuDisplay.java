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
import entities.Model;

/**
 * displays the main menu
 *
 * @author Ethan Coeytaux
 *
 */
public class MainMenuDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;
	
	Application application;

	JButton playGameButton;
	JButton statsButton;

	public MainMenuDisplay(Model model, Application application) {
		super(model);
		this.application = application;

		playGameButton = new JButton("PLAY GAME");

		statsButton = new JButton("STATS");
		
		setup();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try { //load images
			BufferedImage background = ImageIO.read(getClass().getResourceAsStream("/TitleScreen.png"));
			g.drawImage(background, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * sets up display of main menu
	 */
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

	/**
	 * adds Action listener to play game button
	 * @param c play game button controller
	 */
	public void setPlayGameButtonController(PlayGameButtonController c) {
		playGameButton.addActionListener(c);
	}

	/**
	 * adds Action Listener to stats Button
	 * @param c Stats button Controller
	 */
	public void setStatsButtonController(StatsButtonController c) {
		statsButton.addActionListener(c);
	}
}
