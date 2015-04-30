package entities;

import java.util.Stack;

import boundaries.Application;
import boundaries.BuilderApplication;

/**
 * 
 * @author Hugh Whelan
 *
 */
public class Builder {
	Blueprint blueprint;
	BuilderApplication builderApplication;
	Stack<AbstractBuilderMove> moveStack = new Stack(); //stack of moves performed
	Stack<AbstractBuilderMove> redoStack = new Stack(); //stack of moves undone.  used for redo
	
	
	public Builder() {
		Square[][] squareArray = new Square[9][9];
		Board newBoard = new Board(blueprint);

		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				squareArray[i][j] = new Square(new Tile(i+1,j+1), false, false, newBoard, i, j);
			}
		}
		
		newBoard.setSquares(squareArray);

		blueprint = new Blueprint(Game.PUZZLE_ID, 5, 4, 3, 40, new int[]{2,2,2}, new int[]{20,20,20,20,20}, new int[]{30, 30, 40}, newBoard = new Board(squareArray, blueprint) );
		builderApplication = new BuilderApplication(this);
	}

	public static void main(String[] args) {
		new Builder();
	}
	
	/**
	 * disposes of builder when closed
	 */
	public void closeBuilder() {
		builderApplication.dispose();
	}
	
	/**
	 * gets builderApplication
	 * @return
	 */
	public BuilderApplication getBuilderApplication() {
		return builderApplication;
	}
	
	public void setBlueprint(Blueprint newBlueprint){
		this.blueprint = newBlueprint;
	}
	
	/**
	 * pushes move onto move stack
	 * @return AbstractBuilderMove added to stack
	 */
	public void pushMove(AbstractBuilderMove move){
		moveStack.push(move);
	}
	
	/**
	 * pops the top move off the move stack
	 * @return AbstractBuilderMove from top of stack
	 */
	public AbstractBuilderMove popMove(){
		return moveStack.pop();
	}
	
	/**
	 * pushes a move onto redo stack
	 * @return AbstractBuilderMove added to stack
	 */
	public AbstractBuilderMove pushRedo(AbstractBuilderMove move){
		return redoStack.push(move);
	}
	
	/**
	 * pops the top move off the redo stack
	 * @return AbstractBuilderMove from top of stack
	 */
	public AbstractBuilderMove popRedo(){
		return redoStack.pop();
	}
	
	public Blueprint getBlueprint(){
		return this.blueprint;
	}
}
