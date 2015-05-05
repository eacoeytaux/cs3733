package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entities.AbstractLevel;

/**
 * lets board know to look for swap move
 * @author Ethan Coeytaux
 *
 */
public class SwapButtonController implements ActionListener {
	JButton swapButton;
	AbstractLevel level;
	
	public SwapButtonController(JButton swapButton, AbstractLevel level) {
		this.swapButton = swapButton;
		this.level = level;
	}

	/**
	 * sets the swap boolean to true to indicate that next move is a swap move
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(level.getInfo().getSwaps() <= 0) return;
		
		level.getInfo().decrementSwaps();
		swapButton.setText("Swaps: " + level.getInfo().getSwaps());
		
		level.getBoard().swapMove = true;
		level.getBoard().removeMove = false;
	}

}
