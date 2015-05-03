package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;

import boundaries.BlueprintDisplay;
import boundaries.BuilderApplication;
import entities.Blueprint;

/**
 * loads a selected blueprint into the builder to edit
 * @author Ethan Coeytaux
 *
 */
public class LoadBlueprintController implements ActionListener {
	
	BuilderApplication application;

	public LoadBlueprintController(BuilderApplication application) {
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.setSelectedFile(new File("level.txt"));

		try {
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				FileInputStream fis = new FileInputStream(file);
				//InputStreamReader in = new InputStreamReader();
				ObjectInputStream ois = new ObjectInputStream(fis);
				Blueprint newBlueprint = (Blueprint)ois.readObject();
				fis.close();

				application.getParentBuilder().setBlueprint(newBlueprint);
				application.setDisplay(new BlueprintDisplay(application.getParentBuilder()));
				application.getContentPane().removeAll();
				application.setContentPane(application.getDisplay());
				application.pack();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
