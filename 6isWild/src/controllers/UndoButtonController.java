package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.AbstractBuilderMove;
import entities.Builder;

/**
 * handles undoes the last move made or redone
 * @author Hugh Whelan
 *
 */
public class UndoButtonController implements ActionListener{
	
	Builder builder;

	public UndoButtonController(Builder builder){
		this.builder = builder;
	}
	
	/**
	 * pops move from move stack, pushes it onto redo stack so it can be redone, then undoes the move
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractBuilderMove popped = builder.popMove();
		builder.pushRedo(popped);
		popped.undo();
	}

}
