package boundaries;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import entities.Model;

public class BuilderApplication extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Model model;

	public BuilderApplication(Model model) {
		this.model = model;
		
		setBackground(new Color(0x006600));
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
		setContentPane(new BlueprintDisplay(model));
		pack();
	}
}
