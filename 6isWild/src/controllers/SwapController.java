package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import boundaries.BoardDisplay;
import boundaries.SquareDisplay;
import entities.Game;
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
			square.getParentBoard().swapMove = false;

			//swap squares;
			Square otherSquare = square.getParentBoard().getSelected().get(0);
			
			square.getParentBoard().swapSquares(square.getIIndex(), square.getJIndex(), otherSquare.getIIndex(), otherSquare.getJIndex());

			square.getParentBoard().deselectAll();
			
			if (squareDisplay.getParentBoardDisplay().getParentLevelDisplay().getLevel().getLevelType() == Game.RELEASE_ID) square.getParentBoard().checkBoard();

			BoardDisplay boardDisplay = squareDisplay.getParentBoardDisplay();
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					boardDisplay.updateTile(i, j);
				}
			}
			
			squareDisplay.getParentBoardDisplay().setup();
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
