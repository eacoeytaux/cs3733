package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import boundaries.BuilderApplication;

/**
 * saves the current blueprint in builder
 * @author Ethan Coeytaux
 *
 */
public class SaveBlueprintController implements ActionListener {
	BuilderApplication application;

	public SaveBlueprintController(BuilderApplication application) {
		this.application = application;
	}

	/**
	 * saves the blueprint
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		application.getDisplay().setValues();

		JFileChooser chooser = new JFileChooser();
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		//chooser.setFileFilter(filter);
		chooser.setSelectedFile(new File("level.txt"));
		chooser.setCurrentDirectory(new File("./bin/levels/"));

		try {
			int returnVal = chooser.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile());
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(application.getParentBuilder().getBlueprint());
				fos.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
