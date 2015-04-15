package entities;

public abstract class AbstractLevel {
	int level;
	Board board;
	Stat stats;
	boolean[][] emptyTiles;
	
	public AbstractLevel(){
		
	}

	public Stat getStats(){
		return this.stats;
	}
	
	public void updateStats(){
		
	}
	
	public void addBoard(){
		
	}
}
