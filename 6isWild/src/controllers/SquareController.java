package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;

import entities.AbstractLevel;
import entities.Board;
import entities.Square;
import entities.SquareBuilderMove;
import entities.Model;
import boundaries.BoardDisplay;
import boundaries.BuilderSquareDisplay;
import boundaries.SquareDisplay;

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
	 * try to select on mouse click
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (board.swapMove) swapControl.mouseClicked(e);
		else if (board.removeMove) removeControl.mouseClicked(e);
		else moveControl.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (board.swapMove) swapControl.mousePressed(e);
		else if (board.removeMove) removeControl.mousePressed(e);
		else moveControl.mousePressed(e);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (board.swapMove) swapControl.mouseReleased(e);
		else if (board.removeMove) removeControl.mouseReleased(e);
		else moveControl.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (board.swapMove) swapControl.mouseEntered(e);
		else if (board.removeMove) removeControl.mouseEntered(e);
		else moveControl.mouseEntered(e);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (board.swapMove) swapControl.mouseExited(e);
		else if (board.removeMove) removeControl.mouseExited(e);
		else moveControl.mouseExited(e);

	}
}

