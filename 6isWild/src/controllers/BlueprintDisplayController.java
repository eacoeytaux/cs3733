package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import boundaries.BlueprintDisplay;
import boundaries.SquareDisplay;

public class BlueprintDisplayController implements MouseListener {
	BlueprintDisplay parent;
	
	public BlueprintDisplayController(BlueprintDisplay parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		parent.changeSquare(e.getX() / SquareDisplay.pixelSize, e.getY() / SquareDisplay.pixelSize);
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

}
