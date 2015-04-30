package entities;

import java.io.Serializable;

/**
 * 
 * @author Hugh Whelan
 *
 */

public class Square implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Tile tile;
	boolean inert;
	boolean bucket;
	boolean bucketFull;
	boolean selected = false;
	Board parentBoard;
	int iIndex; // row
	int jIndex; // column
	
	
	public Square(Tile tile, boolean inert, boolean bucket) {
		this.tile = tile;
		this.inert = inert;
		this.bucket = bucket;
		this.bucketFull = false;
		this.parentBoard = null;
		this.iIndex = -1;
		this.jIndex = -1;
	}
	
	public Square(Tile tile, boolean inert, boolean bucket, Board parentBoard, int iIndex, int jIndex) {
		this.tile = tile;
		this.inert = inert;
		this.bucket = bucket;
		this.bucketFull = false;
		this.parentBoard = parentBoard;
		this.iIndex = iIndex;
		this.jIndex = jIndex;
	}
	
	public Tile getTile() {
		return tile;
	}
	
	/**
	 * return true if tile is inert
	 * @return boolean true if tile is inert, false otherwise
	 */
	public boolean isInert() {
		return inert;
	}
	
	/**
	 * return true if tile is a bucket
	 * @return boolean true if tile is a bucket, false otherwise
	 */
	public boolean isBucket() {
		return bucket;
	}
	
	/**
	 * changes all attributes of this to match other square
	 * @param other square to be copied
	 */
	public void copyValues(Square other) {
		tile = other.tile;
		inert = other.inert;
		bucket = other.bucket;
		bucketFull = other.bucketFull;
	}
	
	public Square clone() {
		return new Square((tile == null) ? null : tile.clone(), inert, bucket);
	}
	
	/**
	 * converts square to string.  If it is inert or a bucket, that is the string.  Otherwise the tile in the square is converted to a string and returned
	 */
	@Override
	public String toString() {
		if (inert) return "inert";
		else if (bucket) return "bucket";
		else return tile.toString();
	}
	
	/**
	 * adds this square to boards selected square array.
	 * @return boolean indicating whether successful
	 */
	public boolean select(){
		if(this.parentBoard == null){
			return false;
		}
		if(!this.selected){
			parentBoard.addToSelected(this);
			this.selected = true;
			return true;
		}
		return false;

	}
	

	public void deselect(){
		this.selected = false;
	}

	public void setRowCol(int row, int col) {
		iIndex = row;
		jIndex = col;
	}
	
	public void setParentBoard(Board board){
		this.parentBoard = board;
	}
	
	public Board getParentBoard(){
		return this.parentBoard;
	}
	
	public boolean isSelected(){
		return(selected);
	}
	
	public int getIIndex(){
		return this.iIndex;
	}
	
	public int getJIndex(){
		return this.jIndex;
	}
	
	public Tile remove(AbstractLevel level){
		System.out.println("removing " + this.iIndex + " " + this.jIndex);
		
		Tile oldTile = this.tile;
		boolean isLowest = true;
		
		for( int j = jIndex+1; j < 9; j++){
			System.out.println("checking " + iIndex + " " + j);
			if(parentBoard.getSquare(iIndex, j).isSelected()) isLowest = false;
		}
		
		if(isLowest){
			this.selected = false;
			System.out.println("lowest");
			if(this.jIndex == 0){
				System.out.println("lowest1");
				this.tile = new Tile(5,5);
			}else{
				System.out.println("recursively removing " + iIndex + " " + jIndex);
				
				this.tile = parentBoard.getSquare(iIndex, jIndex-1).remove(level);
				
			}
		}
		
		return oldTile;
	}


	
}
