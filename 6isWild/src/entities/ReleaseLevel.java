package entities;


/**
 * type of level
 * @author Hugh Whelan
 * @author Ethan Coeytaux
 * @author Jon Sawin
 */
public class ReleaseLevel extends AbstractLevel {
	
	public ReleaseLevel(Blueprint blueprint, int id){
		super(blueprint, id);

		this.levelType = Game.RELEASE_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
		

}
