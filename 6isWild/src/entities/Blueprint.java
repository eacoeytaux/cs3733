package entities;

import java.io.Serializable;

public class Blueprint implements Serializable {
	private static final long serialVersionUID = 1L;

	Square[][] board;
	int levelType, shuffle, swap, remove, timeTotal, movesTotal, multiplierFreq;
	int[] starRequirements, valueFrequencies;

	public Blueprint() {
		
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
