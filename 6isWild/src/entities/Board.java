package entities;

import java.util.ArrayList;
import entities.Index;

public class Board {
	Square[][] board;
	ArrayList<Index> selectedSquares;
	
	public Board(Square[][] board) {
		this.board = board;
	}

	public Square getSquare(int row, int col) {
		if (board != null) return board[row][col];
		else return new Square(new Tile(-1, -1), false, false, false);
	}
}
