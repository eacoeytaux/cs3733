package entities;

public class EliminationLevel extends AbstractLevel {
	
	public EliminationLevel(Blueprint blueprint, int id){
		super(blueprint, id);
		
		this.levelType = Game.ELIMINATION_ID;
		if (blueprint.levelType != levelType) super.handleWrongBlueprint();
	}
		

}
