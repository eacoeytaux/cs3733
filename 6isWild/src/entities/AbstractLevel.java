package entities;

/**
 * Abstract class for all levels
 * @author Hugh Whelan
 *
 */
public abstract class AbstractLevel {
	int levelType;
	int level;
	Blueprint blueprint;
	Board board;
	Stat stats;
	Info info;
	boolean[][] emptyTiles;
	
	public AbstractLevel(){
	}
	
	public int getLevel(){
		return this.level;
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
		this.board = new Board(blueprint.board.clone(), blueprint);
		board.fillRandom();
	}
	
}
