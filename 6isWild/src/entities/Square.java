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
	
	public boolean isInert() {
		return inert;
	}
	
	public boolean isBucket() {
		return bucket;
	}
	
	public void copyValues(Square other) {
		tile = other.tile;
		inert = other.inert;
		bucket = other.bucket;
		bucketFull = other.bucketFull;
	}
	
	@Override
	public String toString() {
		if (inert) return "inert";
		else if (bucket) return "bucket";
		else return tile.toString();
	}
}
