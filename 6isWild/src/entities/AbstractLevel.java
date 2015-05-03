package entities;

/**
 * Abstract class for all levels
 * @author Hugh Whelan
 *
 */
public abstract class AbstractLevel {
	int levelType;
	int levelNum;
	Blueprint blueprint;
	Board board;
	Stat stats;
	Info info;
	boolean[][] emptyTiles;
	
	public AbstractLevel(Blueprint blueprint) {
		this.blueprint = blueprint;

		this.board = blueprint.getBoardClone();
		this.info = new Info(blueprint.movesTotal, blueprint.swap, blueprint.shuffle, blueprint.remove, blueprint.starRequirements, blueprint.valueFrequencies, blueprint.multiplierFrequencies);
		
		this.stats = new Stat(0, 0);
	}
	
	public void increaseScore(int score){
		info.increaseScore(score);
	}
	
	public int getLevelType() {
		return levelType;
	}
	
	public int getLevel(){
		return this.levelNum;
	}

	public Board getBoard(){
		return this.board;
	}

	public Stat getStats(){
		return this.stats;
	}
	
	public Info getInfo(){
		return this.info;
	}
	
	public void updateStats(){
		
	}
	
	public void addBoard(){
		
	}
	
	public void resetBoard() {
		this.board = blueprint.board.clone();
		this.info = new Info(blueprint.movesTotal, blueprint.swap, blueprint.shuffle, blueprint.remove, blueprint.starRequirements, blueprint.valueFrequencies, blueprint.multiplierFrequencies);
		
		//board.fillRandom();
		
	}
	
	public void incrementMoves() {
		info.incrementMoves();
	}
	
	public int[] getStarRequirements() {
		return blueprint.starRequirements;
	}
	
	public void handleWrongBlueprint() {
		//TODO print error
	}
	
}
