package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import boundaries.LevelDisplay;
import boundaries.SquareDisplay;
import entities.Model;
import entities.Square;

/**
 * handles swap tiles move
 * @author Ethan Coeytaux
 *
 */
public class SwapController implements MouseListener {
	SquareDisplay squareDisplay;
	Square square;
	Model model;

	public SwapController(SquareDisplay squareDisplay, Model model) {
		this.squareDisplay = squareDisplay;
		this.square = squareDisplay.getSquare();
		this.model = model;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int numSquaresSelected = this.square.getParentBoard().getNumberOfSelected();
		if (numSquaresSelected == 0) {
			this.square.select();
			this.squareDisplay.setup();
		} else if (numSquaresSelected == 1) {
			if (isValid()) {
				square.getParentBoard().swapMove = false;

				//swap squares;
				Square otherSquare = square.getParentBoard().getSelected().get(0);
				SquareDisplay otherDisplay = squareDisplay.getParentBoardDisplay().getSquareDisplay(otherSquare.getIIndex(), otherSquare.getJIndex());

				Square tempSquare = otherSquare.clone();

				otherSquare.copyValues(square);
				square.copyValues(tempSquare);

				square.getParentBoard().deselectAll();
				otherDisplay.changeTile();
				otherDisplay.setup();
				squareDisplay.changeTile();
				squareDisplay.setup();
			}
		} else {
			//TODO print warning
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isValid() {
		return true;
	}
}
