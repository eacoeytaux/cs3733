package entities;

public class EliminationLevel extends AbstractLevel {
	
	public EliminationLevel(Blueprint blueprint){
		super(blueprint);
		
		this.levelType = Game.ELIMINATION_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
		

}
