package entities;

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
