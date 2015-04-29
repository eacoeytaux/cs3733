package entities;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Hugh Whelan
 *
 */
public class Board {
	Square[][] board;
	ArrayList<Square> selectedSquares;
	
	public Board() {
		selectedSquares = new ArrayList<Square>();
	}
	
	public Board(Square[][] board) {
		selectedSquares = new ArrayList<Square>();
		this.board = new Square[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.board[i][j] = board[i][j].clone();
				this.board[i][j].setRowCol(i, j);
				this.board[i][j].setParentBoard(this);
			}
		}
	}
	
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
		Square[][] newBoardSquares = new Square[9][9];
		Board newBoard;
		ArrayList<Square> selected;
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newBoardSquares[i][j] = this.board[i][j].clone();
				newBoardSquares[i][j].setRowCol(i, j);
			}
		}
		
		newBoard = new Board(newBoardSquares);
		 
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
		if(selectedSquares.isEmpty()){
			System.out.println("empty");
		}
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
	 * calls deselect on each square, then cleares selectedTiles
	 */
	public void deselectAll(){
		
		System.out.println("deselecting");
		
		if(selectedSquares.isEmpty()){
			System.out.println("empty");
		}
		for(Square square : selectedSquares){
			System.out.println("d");
			square.deselect();
			if(square.isSelected()){
				System.out.println("w");
			}
		}
		
		System.out.println("about to clear");

		selectedSquares.clear();
		
		System.out.println(""+selectedSquares.size());
	}
	
	public void setSelected(ArrayList<Square> selected){
		this.selectedSquares = selected;
	}
	
	public void setSquare(int row, int col, Square square){
		this.board[row][col] = square;
	}
}
