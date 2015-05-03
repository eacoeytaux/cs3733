package entities;

import java.io.File;
import java.util.Scanner;

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
		this.levelType = blueprint.getLevelType();
		
		this.blueprint = blueprint;

		this.board = blueprint.getBoardClone();
		this.info = new Info(blueprint.movesTotal, blueprint.swap, blueprint.shuffle, blueprint.remove, blueprint.starRequirements, blueprint.valueFrequencies, blueprint.multiplierFrequencies);
		
		this.stats = new Stat(0, 0);
		initializeStats();
	}
	
	public void initializeStats(){
		File file = new File("res/Scores.txt");

		try
		{
			System.out.println("aylmao");
			Scanner s = new Scanner(file);
			System.out.println("initialized scanner");
			while(s.hasNextLine())
			{
				if(s.nextInt() == this.getLevelType() && s.nextInt() == this.getLevel()) this.stats = new Stat(s.nextInt(), s.nextInt());
				s.nextLine();
			}
			s.close();
		}
		catch (Exception e)
		{
			System.out.println("problem reading save file");
		}
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
