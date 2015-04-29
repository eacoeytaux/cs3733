package entities;

import boundaries.BuilderSquareDisplay;

/**
 * represents a change made of a sqaure's tile values
 * @author Hugh Whelan
 *
 */
public class SquareBuilderMove extends AbstractBuilderMove{
	BuilderSquareDisplay squareDisplay;
	Square oldSquare;
	Square newSquare;
	
	public SquareBuilderMove(BuilderSquareDisplay square){
		//builder 
		this.squareDisplay = square;
		this.oldSquare = square.getCopySquare();
	}
	
	public void doMove(){
		newSquare = squareDisplay.changeSquare();
		this.squareDisplay.getParentDisplay().getParentDisplay().getBuilder().pushMove(this);
		
	}
	
	public void undo(){
		squareDisplay.changeSquare(oldSquare);
	}
	
	public void redo(){
		squareDisplay.changeSquare(newSquare);
	}

}
