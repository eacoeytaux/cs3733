package entities;

import java.io.Serializable;

/**
 * Tile contains a value and a multiplier
 * @author Hugh Whelan
 *
 */
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
	
	public Tile clone() {
		return new Tile(value, multiplier);
	}
	
	/**
	 * converts to string in the format "value:multiplier"
	 */
	@Override
	public String toString() {
		return value + ":" + multiplier;
	}
}
