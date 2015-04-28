package boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import entities.Blueprint;
import entities.Board;

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

		

		splashScreenDisplay.setSplashScreen();
		getContentPane().removeAll();
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
		
		loadMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadBoard();
			}
		});

		file.add(saveMenuItem);
		file.add(loadMenuItem);
		menubar.add(file);

		setJMenuBar(menubar);
		
		setContentPane(display);
		pack();
	}

	/** 
	 * saves the modified blueprint to storage
	 */
	public void saveBoard() {
		display.setValues();

		JFileChooser chooser = new JFileChooser();
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		//chooser.setFileFilter(filter);
		chooser.setSelectedFile(new File("level.txt"));

		try {
			int returnVal = chooser.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(blueprint);
				fos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * sets the current blueprint to blueprint from storage
	 */
	public void loadBoard() {
		JFileChooser chooser = new JFileChooser();
		chooser.setSelectedFile(new File("level.txt"));
		
		try {
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				FileInputStream fis = new FileInputStream(file);
				//InputStreamReader in = new InputStreamReader();
				ObjectInputStream ois = new ObjectInputStream(fis);
				this.blueprint = (Blueprint)ois.readObject();
				fis.close();
				
				display = new BlueprintDisplay(this.blueprint);
				getContentPane().removeAll();
				setContentPane(display);
				pack();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
