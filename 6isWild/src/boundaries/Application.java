package boundaries;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import entities.Game;

public class Application extends JFrame {
	private static final long serialVersionUID = 1L;
	private Game game;
	
	public Application(Game game) {
		super();
		this.game=game;
		SplashScreenDisplay splashScreenDisplay = new SplashScreenDisplay();
		setContentPane(splashScreenDisplay);
		setPreferredSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		splashScreenDisplay.setSplashScreen();
		goToMainMenu();
	}
	
	public void goToMainMenu() {
		getContentPane().removeAll();
		setContentPane(new MainMenuDisplay());
		pack();
	}
}
