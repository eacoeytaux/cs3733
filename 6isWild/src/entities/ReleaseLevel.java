package entities;

public class ReleaseLevel extends AbstractLevel {
	
	public ReleaseLevel(Blueprint blueprint){
		super();
		
		this.board = new Board(blueprint.board.clone().board);
		this.info = new Info(blueprint.movesTotal, 45, blueprint.swap, blueprint.shuffle, blueprint.remove, blueprint.starRequirements, blueprint.multiplierFrequencies);
		this.info.shuffles = blueprint.shuffle;
		this.info.swaps = blueprint.swap;
		this.info.removes = blueprint.remove;
		this.info.timeTotal = 45;
		this.info.movesTotal = blueprint.movesTotal;
		this.info.starRequirements = blueprint.starRequirements;
		this.info.valueFrequencies = blueprint.valueFrequencies;
		this.info.multiplierFrequencies = blueprint.multiplierFrequencies;
	}
		

}
