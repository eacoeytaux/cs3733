package entities;

public class ReleaseLevel extends AbstractLevel {
	
	public ReleaseLevel(Blueprint blueprint){
		super(blueprint);

		this.levelType = Game.RELEASE_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
		

}
