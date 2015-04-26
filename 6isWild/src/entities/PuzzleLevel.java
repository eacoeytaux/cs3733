package entities;

import boundaries.BoardDisplay;

public class PuzzleLevel extends AbstractLevel {
	
	
	public PuzzleLevel(Blueprint blueprint){
		super();
		
		this.board = new Board(blueprint.board);
		this.info = new Info(blueprint.movesTotal, blueprint.timeTotal, blueprint.swap, blueprint.shuffle, blueprint.remove, blueprint.starRequirements, blueprint.multiplierFrequencies);
		this.info.shuffles = 3;
		this.info.swaps = blueprint.swap;
		this.info.removes = blueprint.remove;
		this.info.timeTotal = blueprint.timeTotal;
		this.info.movesTotal = blueprint.movesTotal;
		this.info.starRequirements = blueprint.starRequirements;
		this.info.valueFrequencies = blueprint.valueFrequencies;
		this.info.multiplierFrequencies = blueprint.multiplierFrequencies;
		
	}
	
	
	
}
