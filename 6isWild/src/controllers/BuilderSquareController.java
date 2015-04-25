package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import boundaries.BuilderSquareDisplay;

public class BuilderSquareController implements MouseListener {
	BuilderSquareDisplay parent;
	
	public BuilderSquareController(BuilderSquareDisplay parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		parent.changeSquare();
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
