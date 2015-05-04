package entities;

public class ReleaseLevel extends AbstractLevel {
	
	public ReleaseLevel(Blueprint blueprint, int id){
		super(blueprint, id);

		this.levelType = Game.RELEASE_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
		

}
