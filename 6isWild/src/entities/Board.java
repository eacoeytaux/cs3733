package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * The board that contains all squares
 * @author Ethan Coeytaux
 * @author Hugh Whelan
 *
 */

public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Random random;
	Square[][] board;
	ArrayList<Square> selectedSquares;
	ArrayList<Square> eliminatedSquares;
	int inertCount;
	int bucketCount;
	int bucketsLeft;

	//these are public because changes these booleans at any time does not result in an error
	public boolean swapMove;
	public boolean removeMove;
	public boolean shuffleMove;

	int[] vf;
	int[] mf;

	public Board(Square[][] board, int[] vf, int[] mf) {
		random = new Random(System.currentTimeMillis());
		selectedSquares = new ArrayList<Square>();
		swapMove = false;
		removeMove = false;
		shuffleMove = false;
		this.vf = vf;
		this.mf = mf;

		inertCount = 0;
		bucketCount = 0;
		
		this.board = new Square[9][9];
		if (board != null) {
			if (board[0][0] != null) {
				setSquares(board);
			}
		}
		
		eliminatedSquares = new ArrayList<Square>();
		
	}

	/**
	 * sets all squares
	 * @param board array of squares
	 */
	public void setSquares(Square[][] board){
		this.board = new Square[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.board[i][j] = board[i][j].clone(this);
				this.board[i][j].setRowCol(i, j);
				this.board[i][j].setParentBoard(this);
				if (this.board[i][j].isInert()) inertCount++;
				if (this.board[i][j].isBucket()) bucketCount++;
			}
		}
		bucketsLeft = bucketCount;
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
		Board newBoard = new Board(newBoardSquares, vf, mf);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newBoardSquares[i][j] = this.board[i][j].clone(newBoard);
				newBoardSquares[i][j].setRowCol(i, j);
			}
		}

		newBoard.setSquares(newBoardSquares);

		/*for( Square square : this.selectedSquares){
			newBoard.addToSelected(square);
		}*/

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
		if (selectedSquares.size() <= 1) return false;

		int moveValue = 0;

		for(Square square : selectedSquares){
			moveValue += square.getTile().getValue();
		}

		return(moveValue == 6);
	}

	/**
	 * gets the score value of the current move
	 * @return int score
	 */
	public int getMoveScore(){
		int score = 0;
		int totalMultiplier = 1;
		int moveValue = 0;

		for(Square square : selectedSquares){
			moveValue += 10;
			totalMultiplier *= square.getTile().getMultiplier();
		}
		
		score = moveValue * totalMultiplier;

		return score;
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

	public void shuffleBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Square square = board[i][j];
				if (square.isInert() || square.isBucket()) continue;

				int i2, j2;

				do {
					i2 = random.nextInt(9);
					j2 = random.nextInt(9);
				} while (board[i2][j2].isInert() || board[i2][j2].isBucket());

				swapSquares(i, j, i2, j2);
			}
		}
	}

	public void swapSquares(int iIndex, int jIndex, int iIndex2, int jIndex2) {
		if ((iIndex == iIndex2) && (jIndex == jIndex2)) return;

		Square square = board[iIndex][jIndex];
		Square otherSquare = board[iIndex2][jIndex2];
		Square tempSquare = otherSquare.clone(this);

		otherSquare.copyValues(square);
		square.copyValues(tempSquare);
	}
	
	public void eliminateSquare(int i, int j){
		Square square = getSquare(i,j);
		
		square.setEliminated();
		eliminatedSquares.add(square);
	}
	
	public void eliminateMoved(){
		for(Square square : selectedSquares){
			if(!eliminatedSquares.contains(square)) eliminatedSquares.add(square);
			square.setEliminated();
		}
	}
	
	public ArrayList<Square> getEliminated(){
		return this.eliminatedSquares;
	}
	
	/**
	 * for release, checks if any 6s should fall into buckets
	 */
	public void checkBoard() {
		while (checkSix());
	}
	
	/**
	 * finds any 6 any checks for a bucket below
	 * @return true is 6 is moved to bucket and check must start over as board has changed
	 */
	public boolean checkSix() {
		for (Square[] squares : board) {
			for (Square square : squares) {
				if (!square.isBucket() && !square.isInert()) {
					if (square.getTile().getValue() == 6) {
						int i = square.getIIndex();
						int j = square.getJIndex() + 1;
						
						while (j < 9) {
							if (board[i][j].isInert() || (board[i][j].isBucket() && board[i][j].bucketFull)) {
								j++;
								continue;
							}
							if (board[i][j].isBucket()) {
								square.remove();
								board[i][j].bucketFull = true;
								bucketsLeft--;
								System.out.println("bucket filled!");
								return true;
							}
							break;
						}
					}
				}
			}
		}
		return false;
	}

	public int getBucketsLeft() {
		return bucketsLeft;
	}
	
	public int getBucketCount() {
		return bucketCount;
	}
	
	public int getInertCount() {
		return inertCount;
	}
	
}
