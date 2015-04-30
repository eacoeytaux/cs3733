package controllers;

import boundaries.Application;
import boundaries.LevelDisplay;
import entities.AbstractLevel;
import entities.Board;
import entities.Square;

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
	
		if(this.level.getBoard().validMove()){
			
			for( int i = 0; i < 9; i++){
				for( int j = 0; j < 9; j++){
					if (level.getBoard().getSquare(i, j).isSelected()) level.getBoard().getSquare(i, j).remove(this.level);
				}
			}
		}
		
		this.level.getBoard().deselectAll();
		//this.levelScreen.getBoardDisplay().setupSquares();
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				levelScreen.getBoardDisplay().updateTile(i, j);
			}
		}
	}
	
	
}