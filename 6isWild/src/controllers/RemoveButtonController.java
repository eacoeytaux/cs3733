package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.AbstractLevel;

public class RemoveButtonController implements ActionListener {
	AbstractLevel level;
	
	public RemoveButtonController(AbstractLevel level) {
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("remove clicked");
		level.getBoard().removeMove = true;
	}
}
