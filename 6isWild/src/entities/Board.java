package entities;

import java.util.ArrayList;
import entities.Index;

public class Board {
	Square[][] board;
	ArrayList<Square> selectedSquares = new ArrayList<Square>();
	
	public Board(Square[][] board) {
		this.board = board;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.board[i][j].setParentBoard(this);
			}
		}
	}

	/**
	 * get square at a given row and column
	 * @param row row that the square is in
	 * @param col column that the square is in
	 * @return
	 */
	public Square getSquare(int row, int col) {
		if (board != null) return board[row][col];
		else return new Square(new Tile(-1, -1), false, false, null, -1, -1);
	}
	
	/**
	 * adds a square to the list of selected squares
	 * @param square to add to list
	 */
	public void addToSelected(Square square){
		selectedSquares.add(square);
	}
	
	public void removeFromSelected(Square square){
		selectedSquares.get(selectedSquares.indexOf(square));
	}
	
	public int getNumberOfSelected(){
		return selectedSquares.size();
	}
}