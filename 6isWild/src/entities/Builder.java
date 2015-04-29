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
		blueprint = new Blueprint();
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
