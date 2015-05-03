package entities;

public class LightningLevel extends AbstractLevel {

	public LightningLevel(Blueprint blueprint){
		super(blueprint);
		
		this.levelType = Game.LIGHTNING_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
	
	@Override
	public void incrementMoves() {
		return;
	}
}
