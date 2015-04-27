package entities;

import java.io.Serializable;

public class Blueprint implements Serializable {
	private static final long serialVersionUID = 1L;

	public Square[][] board;
	int levelType;

	int shuffle;

	int swap;

	int remove;

	int movesTotal;
	int[] starRequirements;

	int[] valueFrequencies;

	int[] multiplierFrequencies;

	public Blueprint() {
		board = new Square[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = new Square(new Tile(0, 0), false, false);
			}
		}
		
		//load default values
		levelType = Game.PUZZLE_ID;
		shuffle = 5;
		swap = 5;
		remove = 5;
		movesTotal = 10;
		starRequirements = new int[3];
		starRequirements[0] = 1000;
		starRequirements[1] = 2000;
		starRequirements[2] = 3000;

		valueFrequencies = new int[6];
		valueFrequencies[0] = 50;
		valueFrequencies[1] = 50;
		valueFrequencies[2] = 50;
		valueFrequencies[3] = 50;
		valueFrequencies[4] = 50;
		valueFrequencies[5] = 50;
		
		multiplierFrequencies = new int[3];
		multiplierFrequencies[0] = 50;
		multiplierFrequencies[1] = 50;
		multiplierFrequencies[2] = 50;
	}
	
	public void changeSquare(int row, int col, Square square) {
		getBoard()[row][col] = square;
		System.out.println(square.tile.value);
	}

	@Override
	public String toString() {
		String string = "";
		for (Square squares[] : getBoard()) {
			for (Square square : squares) {
				string += square.toString();
			}
		}
		string += getBoard().toString() + "\nlevelType: " + getLevelType() + ", shuffle: " + getShuffle() + ", swap: " + getSwap()
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
	}
	
	public void setValues(int levelType, int shuffle, int swap, int remove, int movesTotal, int[] starRequirements, int[] valueFrequencies, int[] multiplierFrequencies) {
		this.setLevelType(levelType);
		this.setShuffle(shuffle);
		this.setSwap(swap);
		this.setRemove(remove);
		this.setMovesTotal(movesTotal);
		this.setStarRequirements(starRequirements);
		this.setValueFrequencies(valueFrequencies);
		this.setMultiplierFrequencies(multiplierFrequencies);
	}
	
	public void setBoard(Square[][] board){
		this.board = board;
	}

	public Square[][] getBoard() {
		return board;
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
