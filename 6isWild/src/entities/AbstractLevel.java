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
	
	public AbstractLevel(){
	}
	
	public void setScore(int score){
		stats.setScore(score);
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
		//board.fillRandom();
	}
	
}
