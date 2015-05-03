package entities;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ReleaseBoard extends Board {

	int sixesLeft;

	public ReleaseBoard(Square[][] board, Blueprint bp, ArrayList<Index> selectedSquares) {
		super(board, bp.getValueFrequencies(), bp.getMultiplierFrequencies());

		sixesLeft = 0;

		for (Square[] squares : board) {
			for (Square square : squares) {
				if (square.isBucket()) sixesLeft++;
			}
		}
	}

	@Override
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
								sixesLeft--;
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

}
