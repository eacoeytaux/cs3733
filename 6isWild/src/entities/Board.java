package entities;

import java.util.ArrayList;
import entities.Index;

public class Board {
	Square[][] board;	//multi-dim array of tiles
	ArrayList<Index> selectedSquares;	//index # of squares
	
	public Board(Square[][] board, ArrayList<Index> selectedSquares){
		this.board = board;
		this.selectedSquares = selectedSquares;
	}
	
	private void removeTile(){
		
	}
}
