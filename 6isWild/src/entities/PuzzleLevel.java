package entities;

import boundaries.BoardDisplay;

/**
 * Puzzle levels have no extension to the AbstractLevel Class.  Puzzle levels are constructed from a blueprint
 * @author Hugh Whelan
 *
 */
public class PuzzleLevel extends AbstractLevel {
	
	
	public PuzzleLevel(Blueprint blueprint){
		super();
		
		this.board = new Board(blueprint);
		this.blueprint = blueprint;
		this.board = blueprint.board.clone();
		this.info = new Info(blueprint.movesTotal, 45, blueprint.swap, blueprint.shuffle, blueprint.remove, blueprint.starRequirements, blueprint.multiplierFrequencies);
		this.info.shuffles = blueprint.shuffle;
		this.info.swaps = blueprint.swap;
		this.info.removes = blueprint.remove;
		this.info.timeTotal = 45;
		this.info.movesTotal = blueprint.getMovesTotal();
		this.info.starRequirements = blueprint.getStarRequirements();
		this.info.valueFrequencies = blueprint.getValueFrequencies();
		this.info.multiplierFrequencies = blueprint.getMultiplierFrequencies();
		
	}
	
	
	
}
