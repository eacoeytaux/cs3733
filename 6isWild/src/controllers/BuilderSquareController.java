package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entities.SquareBuilderMove;
import boundaries.BuilderSquareDisplay;

/**
 * handles mouse events on squares in the builder
 * @author Ethan Coeytaux
 *
 */
public class BuilderSquareController implements MouseListener {
	BuilderSquareDisplay parent;
	
	public BuilderSquareController(BuilderSquareDisplay parent) {
		this.parent = parent;
	}

	/**
	 * changes clicked square to match that of indicated type
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		SquareBuilderMove move = new SquareBuilderMove(parent);
		move.doMove();
	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}
}
