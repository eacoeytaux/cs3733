package entities;

import java.util.Stack;

import boundaries.BuilderApplication;

/**
 * top level builder class
 * @author Ethan Coeytaux
 * @author Hugh Whelan
 *
 */
public class Builder {
	Blueprint blueprint;
	BuilderApplication builderApplication;
	Stack<IBuilderMove> moveStack = new Stack<IBuilderMove>(); //stack of moves performed
	Stack<IBuilderMove> redoStack = new Stack<IBuilderMove>(); //stack of moves undone.  used for redo
	
	
	public Builder(boolean skipSplashScreen) {
		makeNewBlueprint();
		
		builderApplication = new BuilderApplication(this, skipSplashScreen);
	}
	
	/**
	 * creates new blueprint when blueprint needs to be reset
	 */
	public void makeNewBlueprint() {
		Square[][] squareArray = new Square[9][9];
		Board newBoard = new Board(squareArray, new int[]{1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1});

		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				squareArray[i][j] = new Square(new Tile(0, 0), false, false, newBoard, i, j);
			}
		}
		
		newBoard.setSquares(squareArray);

		blueprint = new Blueprint(newBoard);

	}

	public static void main(String[] args) {
		new Builder(false);
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
		if(newBlueprint == null){
			System.out.println("Builder::setBlueprint - Cannot accept null input");
			return;
		}
		this.blueprint = newBlueprint;
	}
	
	/**
	 * pushes move onto move stack
	 * @return AbstractBuilderMove added to stack
	 */
	public void pushMove(IBuilderMove move){
		moveStack.push(move);
		redoStack.clear();
		builderApplication.setUndoEnabled(true);
		builderApplication.setRedoEnabled(false);
	}
	
	/**
	 * pops the top move off the move stack
	 * @return AbstractBuilderMove from top of stack
	 */
	public IBuilderMove popMove(){
		builderApplication.setRedoEnabled(true);
		if (moveStack.size() <= 1) builderApplication.setUndoEnabled(false);
		return moveStack.pop();
	}
	
	/**
	 * pushes a move onto redo stack
	 * @return AbstractBuilderMove added to stack
	 */
	public IBuilderMove pushRedo(IBuilderMove move){
		if (redoStack.size() <= 1) builderApplication.setRedoEnabled(true);
		return redoStack.push(move);
	}
	
	/**
	 * pops the top move off the redo stack
	 * @return AbstractBuilderMove from top of stack
	 */
	public IBuilderMove popRedo(){
		return redoStack.pop();
	}
	
	public Blueprint getBlueprint(){
		return this.blueprint;
	}
}
