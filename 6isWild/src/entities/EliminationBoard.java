package entities;

import java.util.ArrayList;

public class EliminationBoard extends Board {
	public EliminationBoard(Square[][] board, ArrayList<Index> selectedSquares) {
		super(board, selectedSquares);
		// TODO Auto-generated constructor stub
	}

	boolean[][] markedSquares;
}
