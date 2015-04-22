package boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import entities.Model;

public class BuilderApplication extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Model model;

	public BuilderApplication(Model model) {
		this.model = model;
		
		setBackground(new Color(0x006600));
		SplashScreenDisplay splashScreenDisplay = new SplashScreenDisplay();
		setContentPane(splashScreenDisplay);
		setPreferredSize(new Dimension(800, 620));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");

        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem loadMenuItem = new JMenuItem("Load");

        file.add(saveMenuItem);
        file.add(loadMenuItem);
        menubar.add(file);

        setJMenuBar(menubar);
		
		splashScreenDisplay.setSplashScreen();
		getContentPane().removeAll();
		setContentPane(new BlueprintDisplay(model));
		pack();
	}
}
