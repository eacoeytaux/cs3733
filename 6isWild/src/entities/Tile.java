package entities;

import java.io.Serializable;

public class Tile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int value;
	int multiplier;
	
	public Tile(int value, int multiplier) {
		this.value = value;
		this.multiplier = multiplier;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getMultiplier() {
		return multiplier;
	}
	
	/**
	 * converts to string in the format "value:multiplier"
	 */
	@Override
	public String toString() {
		return value + ":" + multiplier;
	}
}
