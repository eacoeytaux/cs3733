package entities;

/**
 * type of level
 * @author Hugh Whelan
 * @author Ethan Coeytaux
 */
public class LightningLevel extends AbstractLevel {

	public LightningLevel(Blueprint blueprint, int id){
		super(blueprint, id);
		
		this.levelType = Game.LIGHTNING_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
	
	@Override
	public void incrementMoves() {
		return;
	}
}
