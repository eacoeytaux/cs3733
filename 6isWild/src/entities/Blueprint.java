package entities;

import java.io.Serializable;

public class Blueprint implements Serializable {
	private static final long serialVersionUID = 1L;

	Square[][] board;
	int levelType, shuffle, swap, remove, movesTotal;
	int[] starRequirements, valueFrequencies, multiplierFrequencies;

	public Blueprint() {
		board = new Square[9][9];
	}
	
	public void changeSquare(int row, int col, Square square) {
		board[row][col] = square;
		System.out.println(square.tile.value);
	}

	@Override
	public String toString() {
		String string = "";
		for (Square squares[] : board) {
			for (Square square : squares) {
				string += square.toString();
			}
		}
		string += board.toString() + "\nlevelType: " + levelType + ", shuffle: " + shuffle + ", swap: " + swap
				+ ", remove: " + remove + ", movesTotal: " + movesTotal;
		for (int i = 0; i < starRequirements.length; i++) {
			string += ", starReq" + i + ": " + starRequirements[i];
		}
		for (int i = 0; i < valueFrequencies.length; i++) {
			string += ", valueFreq" + i + ": " + valueFrequencies[i];
		}
		for (int i = 0; i < multiplierFrequencies.length; i++) {
			string += ", multiplierReq" + i + ": " + multiplierFrequencies[i];
		}
		return string;
	}
	
	public void setValues(int levelType, int shuffle, int swap, int remove, int movesTotal, int[] starRequirements, int[] valueFrequencies, int[] multiplierFrequencies) {
		this.levelType = levelType;
		this.shuffle = shuffle;
		this.swap = swap;
		this.remove = remove;
		this.movesTotal = movesTotal;
		this.starRequirements = starRequirements;
		this.valueFrequencies = valueFrequencies;
		this.multiplierFrequencies = multiplierFrequencies;
	}
	
	public void setBoard(Square[][] board){
		this.board = board;
	}
}
