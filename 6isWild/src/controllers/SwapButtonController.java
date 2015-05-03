package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entities.AbstractLevel;

public class SwapButtonController implements ActionListener {
	AbstractLevel level;
	
	public SwapButtonController(AbstractLevel level) {
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(level.getInfo().getSwaps() <= 0) return;
			
		level.getBoard().swapMove = true;
		level.getInfo().decrementSwaps();
	}

}
