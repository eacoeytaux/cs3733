package entities;

import boundaries.BoardDisplay;

public class PuzzleLevel extends AbstractLevel {
	
	
	public PuzzleLevel(Blueprint blueprint){
		super();
		
		this.board = new Board(blueprint.getBoard());
		this.info = new Info(blueprint.getMovesTotal(), 45, blueprint.getSwap(), blueprint.getShuffle(), blueprint.getRemove(), blueprint.getStarRequirements(), blueprint.getMultiplierFrequencies());
		this.info.shuffles = 3;
		this.info.swaps = blueprint.getSwap();
		this.info.removes = blueprint.getRemove();
		this.info.timeTotal = 45;
		this.info.movesTotal = blueprint.getMovesTotal();
		this.info.starRequirements = blueprint.getStarRequirements();
		this.info.valueFrequencies = blueprint.getValueFrequencies();
		this.info.multiplierFrequencies = blueprint.getMultiplierFrequencies();
		
	}
	
	
	
}
