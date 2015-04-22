package entities;

import java.io.Serializable;

public class Blueprint implements Serializable {
	private static final long serialVersionUID = 1L;

	Square[][] board;
	int levelType, shuffle, swap, remove, timeTotal, movesTotal, multiplierFreq;
	int[] starRequirements, valueFrequencies;

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
				+ ", remove: " + remove + ", timeTotal: " + timeTotal + ", movesTotal: " + "multiplierFreq: "
				+ multiplierFreq;
		for (int i = 0; i < starRequirements.length; i++) {
			string += ", starReq" + i + ": " + starRequirements[i];
		}
		for (int i = 0; i < valueFrequencies.length; i++) {
			string += ", valueFreq" + i + ": " + valueFrequencies[i];
		}
		return string;
	}
}
