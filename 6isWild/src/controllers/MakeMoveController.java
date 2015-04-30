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
		System.out.println("deselecting");
	
		if(this.level.getBoard().validMove()){
			System.out.println("its valid");
			for( Square square : this.level.getBoard().getSelected()){
					square.remove(this.level);
			}
		}
		
		System.out.println("---------top left tile:" + this.level.getBoard().getSquare(0, 0).getTile().getValue());
		
		this.level.getBoard().deselectAll();
		//this.levelScreen.getBoardDisplay().setupSquares();
		
	}
	
	
}