package boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import entities.Blueprint;

public class BuilderApplication extends JFrame {
	private static final long serialVersionUID = 1L;

	Blueprint blueprint;
	BlueprintDisplay display;

	public BuilderApplication(Blueprint blueprint) {
		this.blueprint = blueprint;
		display = new BlueprintDisplay(this.blueprint);

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

		saveMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveBoard();
			}

		});

		file.add(saveMenuItem);
		file.add(loadMenuItem);
		menubar.add(file);

		setJMenuBar(menubar);

		splashScreenDisplay.setSplashScreen();
		getContentPane().removeAll();
		setContentPane(display);
		pack();
	}

	public void saveBoard() {
		display.save();

		try {
			FileOutputStream f_out = new FileOutputStream("level.ser");
			ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
			obj_out.writeObject(blueprint);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
