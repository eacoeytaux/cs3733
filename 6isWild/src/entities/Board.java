package entities;

import java.util.ArrayList;
import entities.Index;

public class Board {
	Square[][] board;
	ArrayList<Index> selectedSquares;
	
	public Board(Square[][] board) {
		this.board = board;
	}

	/**
	 * get square at a given row and column
	 * @param row row that the square is in
	 * @param col column that the square is in
	 * @return
	 */
	public Square getSquare(int row, int col) {
		if (board != null) return board[row][col];
		else return new Square(new Tile(0, 0), false, false);
	}
}
