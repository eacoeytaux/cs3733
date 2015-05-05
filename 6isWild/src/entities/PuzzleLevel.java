package entities;


/**
 * Type of level
 * @author Hugh Whelan
 * @author Jon Sawin
 *
 */
public class PuzzleLevel extends AbstractLevel {
	
	
	public PuzzleLevel(Blueprint blueprint, int id){
		super(blueprint, id);
		
		this.levelType = Game.PUZZLE_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
	
	
	
}
