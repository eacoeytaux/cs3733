package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.Builder;
import entities.IBuilderMove;

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
		IBuilderMove popped = builder.popMove();
		builder.pushRedo(popped);
		popped.undo();
	}

}
