package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SelectNullLevelButtonController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Sorry, this level doesn't exist yet...", "Okay", JOptionPane.PLAIN_MESSAGE);
	}

}
