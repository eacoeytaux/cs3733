package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.AbstractBuilderMove;
import entities.Builder;

/**
 * handles redoes the last move undone
 * @author Hugh Whelan
 *
 */
public class RedoButtonController implements ActionListener{
	
	Builder builder;

	public RedoButtonController(Builder builder){
		this.builder = builder;
	}
	
	/**
	 * pops move from redo stack, pushes it onto undo stack so it can be undone, then redoes the move
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractBuilderMove popped = builder.popRedo();
		builder.pushMove(popped);
		popped.redo();
		
	}

}
