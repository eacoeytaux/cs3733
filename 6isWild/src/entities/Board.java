package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * The board that contains all squares
 * @author Hugh Whelan
 *
 */
public class Board implements Serializable {
	Random random;
	Square[][] board;
	ArrayList<Square> selectedSquares;
	int[] vf;
	int[] mf;

	public Board(Square[][] board, int[] vf, int[] mf) {
		random = new Random(System.currentTimeMillis());
		selectedSquares = new ArrayList<Square>();
		this.vf = vf;
		this.mf = mf;
		this.board = new Square[9][9];
		if (board[0][0] != null) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					this.board[i][j] = board[i][j].clone();
					this.board[i][j].setRowCol(i, j);
					this.board[i][j].setParentBoard(this);
				}
			}
		}
	}
	
	/**
	 * sets all squares
	 * @param board array of squares
	 */
	public void setSquares(Square[][] board){
		this.board = new Square[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.board[i][j] = board[i][j].clone();
				this.board[i][j].setRowCol(i, j);
				this.board[i][j].setParentBoard(this);
			}
		}
	}
	
	/**
	 * fills a square with a tile based off the levels frequencies
	 */
	public void fillRandom() { //TODO set tiles based off frequencies
		for (Square[] squares : board) {
			for (Square square : squares) {
				if (square.isInert() || square.isBucket()) continue;

				Tile tile = square.getTile();
				if (tile.value == 0) tile.value = getRandomTileValue();
				if (tile.multiplier == 0) tile.multiplier = getRandomMultiplier();
			}
		}
	}
	
	/**
	 * returns value based off of level value frequencies
	 */
	public int getRandomTileValue()
	{
		int sum = 0;
		for(int i = 0; i<6; i++)
		{
			sum += vf[i];
		}
		int r = random.nextInt(sum);
		for (int i = 0; i < 6; i++) {
			if (r < vf[i]) return i + 1;
			r -= vf[i];
		}
		return -1;
	}

	/**
	 * returns value based off of level value multipliers
	 */
	public int getRandomMultiplier()
	{
		int sum = 0;
		for(int i = 0; i<3; i++)
		{
			sum += mf[i];
		}
		int r = random.nextInt(sum);
		for (int i = 0; i < 3; i++) {
			if (r < mf[i]) return i + 1;
			r -= mf[i];
		}
		return -1;
	}
	
	/**
	 * clones the board
	 */
	public Board clone() {
		Square[][] newBoardSquares = new Square[9][9];
		Board newBoard;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newBoardSquares[i][j] = this.board[i][j].clone();
				newBoardSquares[i][j].setRowCol(i, j);
			}
		}

		newBoard = new Board(newBoardSquares, vf, mf);

		for( Square square : this.selectedSquares){
			newBoard.addToSelected(square);
		}

		return newBoard;
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


	public int getNumberOfSelected(){
		return selectedSquares.size();
	}

	/**
	 * checks to see if sum of all values of tiles in selected squares equals six
	 * @return boolean indicating whether move is valid
	 */
	public boolean validMove(){
		int moveValue = 0;

		for(Square square : selectedSquares){
			moveValue += square.getTile().getValue();
		}

		return(moveValue == 6);
	}

	/**
	 * calls deselect on each square, then clears selectedTiles
	 */
	public void deselectAll(){

		for(Square square : selectedSquares){
			square.deselect();
		}

		selectedSquares.clear();
	}

	public void setSelected(ArrayList<Square> selected){
		this.selectedSquares = selected;
	}

	public void setSquare(int row, int col, Square square){
		this.board[row][col] = square;
	}

	public ArrayList<Square> getSelected(){
		return this.selectedSquares;
	}
}
