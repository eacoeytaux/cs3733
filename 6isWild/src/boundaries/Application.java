package boundaries;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import entities.Game;

public class Application extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Game game;
	
	public Application(Game game) {
		this.game = game;
		SplashScreenDisplay splashScreenDisplay = new SplashScreenDisplay();
		setContentPane(splashScreenDisplay);
		setPreferredSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		splashScreenDisplay.setSplashScreen();
		getContentPane().removeAll();
		setContentPane(new MainMenuDisplay());
		pack();
	}
}
