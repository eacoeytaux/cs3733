package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Blueprint implements Serializable {
	private static final long serialVersionUID = 1L;

	int levelType;

	int shuffle;

	int swap;

	int remove;

	int movesTotal;
	int[] starRequirements;

	int[] valueFrequencies;

	int[] multiplierFrequencies;
	
	Board board;

	public Blueprint(int levelType, int shuffle, int swap, int remove, int movesTotal, int[] starRequirements, int[] valueFrequencies, int[] multiplierFrequencies, Board board) {
		this.levelType = Game.PUZZLE_ID;
		this.shuffle = 5;
		this.swap = 5;
		this.remove = 5;
		this.movesTotal = 10;
		this.starRequirements = new int[3];
		this.starRequirements[0] = 1000;
		this.starRequirements[1] = 2000;
		this.starRequirements[2] = 3000;

		this.valueFrequencies = new int[6];
		this.valueFrequencies[0] = 50;
		this.valueFrequencies[1] = 50;
		this.valueFrequencies[2] = 50;
		this.valueFrequencies[3] = 50;
		this.valueFrequencies[4] = 50;
		this.valueFrequencies[5] = 50;
		
		this.multiplierFrequencies = new int[3];
		this.multiplierFrequencies[0] = 50;
		this.multiplierFrequencies[1] = 50;
		this.multiplierFrequencies[2] = 50;
		
		Square[][] squares = new Square[9][9];
		for(int i = 0; i < 9; i++){
			for( int j = 0; j < 9; j++){
				squares[i][j] = new Square(new Tile(i, j), false, false);
			}
		}
		Board newBoard = new Board(squares, this);
		
		this.board = newBoard;
	}
	
	public void setValues(int levelType, int shuffle, int swap, int remove, int movesTotal, int[] starRequirements, int[] valueFrequencies, int[] multiplierFrequencies){
		this.levelType = levelType;
		this.shuffle = shuffle;
		this.swap = swap;
		this.remove = remove;
		this.movesTotal = movesTotal;
		this.starRequirements = starRequirements;
		this.valueFrequencies = valueFrequencies;
		this.multiplierFrequencies = multiplierFrequencies;
	}
	
	public void changeSquare(int row, int col, Square square) {
		this.board.setSquare(row, col, square);
	}

	/**
	 * converts a blueprint to a String
	 */
	
	/*
	@Override
	public String toString() {
		String string = "";
		for (Square squares[] : getBoardSquares()) {
			for (Square square : squares) {
				string += square.toString();
			}
		}
		string += getBoardSquares().toString() + "\nlevelType: " + getLevelType() + ", shuffle: " + getShuffle() + ", swap: " + getSwap()
				+ ", remove: " + getRemove() + ", movesTotal: " + getMovesTotal();
		for (int i = 0; i < getStarRequirements().length; i++) {
			string += ", starReq" + i + ": " + getStarRequirements()[i];
		}
		for (int i = 0; i < getValueFrequencies().length; i++) {
			string += ", valueFreq" + i + ": " + getValueFrequencies()[i];
		}
		for (int i = 0; i < getMultiplierFrequencies().length; i++) {
			string += ", multiplierReq" + i + ": " + getMultiplierFrequencies()[i];
		}
		return string;
	}*/
	

	
	
	public Board getBoard() {
		return this.board;
	}
	
	public Board getBoardClone(){
		Board newBoard = new Board(this.board.board, this);
		newBoard.selectedSquares = new ArrayList<Square>();
		return newBoard;
	}

	public int getLevelType() {
		return levelType;
	}

	public void setLevelType(int levelType) {
		this.levelType = levelType;
	}

	public int getMovesTotal() {
		return movesTotal;
	}

	public void setMovesTotal(int movesTotal) {
		this.movesTotal = movesTotal;
	}

	public int[] getStarRequirements() {
		return starRequirements;
	}

	public void setStarRequirements(int[] starRequirements) {
		this.starRequirements = starRequirements;
	}

	public int getShuffle() {
		return shuffle;
	}

	public void setShuffle(int shuffle) {
		this.shuffle = shuffle;
	}

	public int getSwap() {
		return swap;
	}

	public void setSwap(int swap) {
		this.swap = swap;
	}

	public int getRemove() {
		return remove;
	}

	public void setRemove(int remove) {
		this.remove = remove;
	}

	public int[] getValueFrequencies() {
		return valueFrequencies;
	}

	public void setValueFrequencies(int[] valueFrequencies) {
		this.valueFrequencies = valueFrequencies;
	}

	public int[] getMultiplierFrequencies() {
		return multiplierFrequencies;
	}

	public void setMultiplierFrequencies(int[] multiplierFrequencies) {
		this.multiplierFrequencies = multiplierFrequencies;
	}
}
