package entities;

import java.io.Serializable;

public class Square implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Tile tile;
	boolean inert;
	boolean bucket;
	boolean bucketFull;
	
	public Square(Tile tile, boolean inert, boolean bucket, boolean bucketFull) {
		this.tile = tile;
		this.inert = inert;
		this.bucket = bucket;
		this.bucketFull = bucketFull;
		
	}
	
	public Tile getTile() {
		return tile;
	}
	
	@Override
	public String toString() {
		return tile.toString() + ", inert: " + inert + ", bucket: " + bucket;
	}
}
