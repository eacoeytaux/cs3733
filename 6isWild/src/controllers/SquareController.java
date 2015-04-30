package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import entities.Square;
import entities.SquareBuilderMove;
import boundaries.BuilderSquareDisplay;
import boundaries.SquareDisplay;

public class SquareController implements MouseListener {
	SquareDisplay squareDisplay;
	Square square;
	
	
	public SquareController(SquareDisplay squareDisplay) {
		this.squareDisplay = squareDisplay;
		this.square = squareDisplay.getSquare();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(isValid(squareDisplay, square)){
			this.square.select();
			this.squareDisplay.setup();
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
	
	/**
	 * if there are none selected or the selected square is adjacent to a selected square, return true
	 * @param squareDisplay
	 * @param square
	 * @return boolean
	 */
	public boolean isValid(SquareDisplay squareDisplay, Square square){
		//if (square.getParentBoard().getNumberOfSelected() >= 6) return false; //uncomment to prevent user from selected more than 6 tiles
		if (square.isInert() || square.isBucket()) return false;
		
		boolean downSelected;
		boolean upSelected;
		boolean leftSelected;
		boolean rightSelected;

		
		if(this.square.getIIndex() <= 0 && this.square.getJIndex() <= 0){
			downSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()+1, this.square.getJIndex()).isSelected();
			rightSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()+1).isSelected();
			
			return ((this.square.getParentBoard().getNumberOfSelected() == 0) || rightSelected || downSelected);
		}else if(this.square.getIIndex() >= 8 && this.square.getJIndex() >= 8){
			upSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()-1, this.square.getJIndex()).isSelected();
			leftSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()-1).isSelected();
			
			return ((this.square.getParentBoard().getNumberOfSelected() == 0) || leftSelected || upSelected);
		}else if(this.square.getIIndex() <= 0 && this.square.getJIndex() >= 8){
			downSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()+1, this.square.getJIndex()).isSelected();
			leftSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()-1).isSelected();
			
			return ((this.square.getParentBoard().getNumberOfSelected() == 0) || leftSelected || downSelected);
		
		}else if(this.square.getIIndex() >= 8 && this.square.getJIndex() <= 0){
			upSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()-1, this.square.getJIndex()).isSelected();
			rightSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()+1).isSelected();
			
			return ((this.square.getParentBoard().getNumberOfSelected() == 0) || rightSelected || upSelected);
		
		}else if( this.square.getIIndex() <= 0){
			downSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()+1, this.square.getJIndex()).isSelected();
			leftSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()-1).isSelected();
			rightSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()+1).isSelected();
			
			return ((this.square.getParentBoard().getNumberOfSelected() == 0) || rightSelected || leftSelected || downSelected);
		}else if(this.square.getJIndex() <= 0){
			downSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()+1, this.square.getJIndex()).isSelected();
			upSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()-1, this.square.getJIndex()).isSelected();
			rightSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()+1).isSelected();
			
			return ((this.square.getParentBoard().getNumberOfSelected() == 0) || rightSelected || downSelected || upSelected);
			
		}else if(this.square.getIIndex() >= 8){
			upSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()-1, this.square.getJIndex()).isSelected();
			leftSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()-1).isSelected();
			rightSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()+1).isSelected();
			
			return ((this.square.getParentBoard().getNumberOfSelected() == 0) || rightSelected || leftSelected || upSelected);
		}else if(this.square.getJIndex() >= 8){
			downSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()+1, this.square.getJIndex()).isSelected();
			upSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()-1, this.square.getJIndex()).isSelected();
			leftSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()-1).isSelected();
			
			return ((this.square.getParentBoard().getNumberOfSelected() == 0) || leftSelected || downSelected || upSelected);
		}else{
			downSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()+1, this.square.getJIndex()).isSelected();
			upSelected = this.square.getParentBoard().getSquare(this.square.getIIndex()-1, this.square.getJIndex()).isSelected();
			leftSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()-1).isSelected();
			rightSelected = this.square.getParentBoard().getSquare(this.square.getIIndex(), this.square.getJIndex()+1).isSelected();

			return ((this.square.getParentBoard().getNumberOfSelected() == 0) || rightSelected || leftSelected || downSelected || upSelected);
		}
	}
}
