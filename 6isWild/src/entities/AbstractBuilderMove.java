package entities;

import boundaries.BlueprintDisplay;

/**
 * abstract class for all moves in builder
 * @author Hugh Whelan
 *
 */
public class AbstractBuilderMove {
	
	/**
	 * performs the move
	 */
	public void doMove(){
	}
	
	/**
	 * undoes last move done or redone
	 */
	public void undo(){
	}
	
	/**
	 * redoes the last move done or undone
	 */
	public void redo(){
		
	}

}
