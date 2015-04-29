package controllers;

import boundaries.Application;
import boundaries.LevelDisplay;
import entities.AbstractLevel;
import entities.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Hugh Whelan
 *
 */
public class MakeMoveController implements ActionListener {
	LevelDisplay levelScreen;
	AbstractLevel level;

	public MakeMoveController(AbstractLevel level, LevelDisplay levelScreen){
		this.level=level;
		this.levelScreen = levelScreen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("deselecting");
	
		if(this.level.getBoard().validMove()){//valid move
			//call remove() on all bottom squares and de
		}
		
		this.level.getBoard().deselectAll();
		this.levelScreen.getBoardDisplay().setupSquares();
	}
	
	private void removeTile(){
		
	}
	
}