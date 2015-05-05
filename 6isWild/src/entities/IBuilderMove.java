package entities;


/**
 * abstract class for all moves in builder
 * @author Hugh Whelan
 *
 */
public interface IBuilderMove {
	
	/**
	 * performs the move
	 */
	public abstract void doMove();
	
	/**
	 * undoes last move done or redone
	 */
	public abstract void undo();
	
	/**
	 * redoes the last move done or undone
	 */
	public abstract void redo();

}
