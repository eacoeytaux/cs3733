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

import controllers.LoadBlueprintController;
import controllers.NewBlueprintController;
import controllers.RedoButtonController;
import controllers.SaveBlueprintController;
import controllers.UndoButtonController;
import entities.Blueprint;
import entities.Builder;

/**
 * Application boundary class for the builder
 * @author Hugh Whelan
 * @author Ethan Coeytaux
 */
public class BuilderApplication extends JFrame {
	private static final long serialVersionUID = 1L;

	Builder builder;
	BlueprintDisplay display;

	public BuilderApplication(final Builder builder) {
		this.builder = builder;
		display = new BlueprintDisplay(this.builder);

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
		JMenu edit = new JMenu("Edit");

		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		JMenuItem loadMenuItem = new JMenuItem("Load");
		JMenuItem undoMenuItem = new JMenuItem("undo");
		JMenuItem redoMenuItem = new JMenuItem("redo");

		newMenuItem.addActionListener(new NewBlueprintController(this));
		saveMenuItem.addActionListener(new SaveBlueprintController(this));
		loadMenuItem.addActionListener(new LoadBlueprintController(this));

		undoMenuItem.addActionListener(new UndoButtonController(this.builder));
		redoMenuItem.addActionListener(new RedoButtonController(this.builder));


		file.add(newMenuItem);
		file.add(saveMenuItem);
		file.add(loadMenuItem);
		edit.add(undoMenuItem);
		edit.add(redoMenuItem);
		menubar.add(file);
		menubar.add(edit);

		setJMenuBar(menubar);
		
		setContentPane(display);
		pack();
	}

	/**
	 * saves a board to disk
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
				oos.writeObject(builder.getBlueprint());
				fos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BlueprintDisplay getDisplay() {
		return display;
	}
	
	public void setDisplay(BlueprintDisplay display) {
		this.display = display;
	}
	
	public Builder getParentBuilder() {
		return builder;
	}
}
