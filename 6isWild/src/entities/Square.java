package entities;

import java.io.Serializable;

public class Square implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Tile tile;
	boolean inert;
	boolean bucket;
	boolean bucketFull;
	boolean selected = false;
	Board parentBoard;
	int iIndex;
	int jIndex;
	
	
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
		}else{
			parentBoard.removeFromSelected(this);
			this.selected = false;
			return false;
		}

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
}
