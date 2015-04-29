package entities;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	Square[][] board;
	Blueprint bp;
	ArrayList<Square> selectedSquares = new ArrayList<Square>();
	
	public Board(Square[][] board, Blueprint bp) {
		this.board = new Square[9][9];
		this.bp = bp;
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
	
	public int getRandomTileValue()
	{
		Random random = new Random(System.currentTimeMillis());
		int sum = 0;
		int[] vf = bp.getValueFrequencies();
		for(int i = 0; i<5; i++)
		{
			sum += vf[i];
		}
		int r = random.nextInt(sum);
		if (r < vf[0]) return 1;
		if (vf[0] <= r && r < vf[1]) return 2;
		if (vf[1] <= r && r < vf[2]) return 3;
		if (vf[2] <= r && r < vf[3]) return 4;
		if (vf[3] <= r && r < vf[4]) return 5;
		if (vf[4] <= r && r < vf[5]) return 6;
		return -1;
	}
	
	public int getRandomMultiplier()
	{
		Random random = new Random(System.currentTimeMillis());
		int sum = 0;
		int[] mf = bp.getMultiplierFrequencies();
		for(int i = 0; i<5; i++)
		{
			sum += mf[i];
		}
		int r = random.nextInt(sum);
		if (r < mf[0]) return 1;
		if (mf[0] <= r && r < mf[1]) return 2;
		if (mf[1] <= r && r < mf[2]) return 3;
		return -1;
	}
	
	public Board clone() {
		Square[][] newBoard = new Square[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newBoard[i][j] = board[i][j].clone();
			}
		}
		
		return new Board(newBoard, bp);
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
