package entities;

import boundaries.BoardDisplay;

/**
 * Puzzle levels have no extension to the AbstractLevel Class.  Puzzle levels are constructed from a blueprint
 * @author Hugh Whelan
 *
 */
public class PuzzleLevel extends AbstractLevel {
	
	
	public PuzzleLevel(Blueprint blueprint){
		super(blueprint);
		
		this.levelType = Game.PUZZLE_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
	
	
	
}
