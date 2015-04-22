package controllers;

import boundaries.LevelDisplay;
import entities.AbstractLevel;
import entities.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeMove implements ActionListener {
	LevelDisplay levelScreen;
	AbstractLevel level;

	public MakeMove(AbstractLevel level, LevelDisplay levelScreen){
		this.level=level;
		this.levelScreen = levelScreen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	private void removeTile(){
		
	}
	
}
