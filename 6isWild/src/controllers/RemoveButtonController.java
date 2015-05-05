package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entities.AbstractLevel;

/**
 * Lets board know to look for a remove move
 * @author Ethan Coeytaux
 * 
 */
public class RemoveButtonController implements ActionListener {
	JButton removeButton;
	AbstractLevel level;
	
	public RemoveButtonController(JButton removeButton, AbstractLevel level) {
		this.removeButton = removeButton;
		this.level = level;
	}

	/**
	 * sets the remove boolean to true to allow next square selected to be removed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (level.getInfo().getRemoves() <= 0) return;
			
		level.getInfo().decrementRemoves();
		removeButton.setText("Removes: " + level.getInfo().getRemoves());
		
		level.getBoard().removeMove = true;
		level.getBoard().swapMove = false;
		
	}
}
