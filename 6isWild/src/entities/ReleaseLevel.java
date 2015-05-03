package entities;

public class ReleaseLevel extends AbstractLevel {
	
	public ReleaseLevel(Blueprint blueprint){
		super(blueprint);
		
		this.board = blueprint.board.clone();
	}
		

}
