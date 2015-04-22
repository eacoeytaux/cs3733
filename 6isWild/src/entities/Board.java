package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Square[][] board;
	ArrayList<Square> selectedSquares;
	
	public Board(Square[][] board) {
		this.board = board;
	}
	
	public Square getSquare(int row, int col) {
		if (board != null) return board[row][col];
		else return new Square(new Tile(-1, -1), false, false, false);
	}

	@Override
	public String toString() {
		String string = "";
		for (Square squares[] : board) {
			for (Square square : squares) {
				string += square.toString();
			}
		}
		return string;
	}
}
