package entities;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	Square[][] board;
	ArrayList<Index> selectedSquares;
	
	public Board(Square[][] board) {
		this.board = board;
	}
	
	public void fillRandom() { //TODO set tiles based off frequencies
		Random random = new Random(System.currentTimeMillis());
		
		for (Square[] squares : board) {
			for (Square square : squares) {
				if (square.isInert() || square.isBucket()) continue;
				
				Tile tile = square.getTile();
				if (tile.value == 0) tile.value = random.nextInt(5) + 1;
				if (tile.multiplier == 0) tile.multiplier = random.nextInt(3) + 1;
			}
		}
	}
	
	public Board clone() {
		Square[][] newBoard = new Square[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newBoard[i][j] = board[i][j].clone();
			}
		}
		
		return new Board(newBoard);
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
