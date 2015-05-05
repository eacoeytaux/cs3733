package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import boundaries.SquareDisplay;
import entities.Board;
import entities.Model;
import entities.Square;

/**
 * handles mouse events on a square
 * @author Hugh Whelan
 *
 */
public class SquareController implements MouseListener {
	Board board;
	SquareDisplay squareDisplay;
	Square square;
	Model model;

	MoveController moveControl;
	SwapController swapControl;
	RemoveController removeControl;


	public SquareController(SquareDisplay squareDisplay, Model model) {
		this.board = squareDisplay.getParentBoardDisplay().getBoard();
		this.squareDisplay = squareDisplay;
		this.square = squareDisplay.getSquare();
		this.model = model;

		moveControl = new MoveController(squareDisplay, model);
		swapControl = new SwapController(squareDisplay, model);
		removeControl = new RemoveController(squareDisplay, model);
	}

	/**
	 * determines whether to do a powerup or a regular move
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (board.swapMove) swapControl.mouseClicked(e);
		else if (board.removeMove) removeControl.mouseClicked(e);
		else moveControl.mouseClicked(e);
	}

	/**
	 * determines whether to do a powerup or a regular move
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (board.swapMove) swapControl.mousePressed(e);
		else if (board.removeMove) removeControl.mousePressed(e);
		else moveControl.mousePressed(e);

	}

	/**
	 * determines whether to do a powerup or a regular move
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (board.swapMove) swapControl.mouseReleased(e);
		else if (board.removeMove) removeControl.mouseReleased(e);
		else moveControl.mouseReleased(e);
	}

	/**
	 * determines whether to do a powerup or a regular move
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		if (board.swapMove) swapControl.mouseEntered(e);
		else if (board.removeMove) removeControl.mouseEntered(e);
		else moveControl.mouseEntered(e);

	}
	
	/**
	 * determines whether to do a powerup or a regular move
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		if (board.swapMove) swapControl.mouseExited(e);
		else if (board.removeMove) removeControl.mouseExited(e);
		else moveControl.mouseExited(e);

	}
}

