package entities;

/**
 * type of level
 * @author Hugh Whelan
 * @author Ethan Coeytaux
 */

public class EliminationLevel extends AbstractLevel {
	
	public EliminationLevel(Blueprint blueprint, int id){
		super(blueprint, id);
		
		this.levelType = Game.ELIMINATION_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
		

}
