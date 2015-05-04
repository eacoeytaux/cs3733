package entities;


/**
 * Puzzle levels have no extension to the AbstractLevel Class.  Puzzle levels are constructed from a blueprint
 * @author Hugh Whelan
 *
 */
public class PuzzleLevel extends AbstractLevel {
	
	
	public PuzzleLevel(Blueprint blueprint, int id){
		super(blueprint, id);
		
		this.levelType = Game.PUZZLE_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
	
	
	
}
