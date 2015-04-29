package entities;

import java.io.Serializable;

public class Square implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Tile tile;
	boolean inert;
	boolean bucket;
	boolean bucketFull;
	
	public Square(Tile tile, boolean inert, boolean bucket) {
		this.tile = tile;
		this.inert = inert;
		this.bucket = bucket;
		this.bucketFull = false;
		
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
}
