package entities;

import java.io.Serializable;

/**
 * 
 * @author Jon Swain
 * @author Ethan Coeytaux
 *
 */

public class GlobalStats implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Stat puzzleLvls[];
	Stat lightningLvls[];
	Stat eliminationLvls[];
	Stat releaseLvls[];
	
	public GlobalStats() {
		puzzleLvls = new Stat[20];
		lightningLvls = new Stat[20];
		eliminationLvls = new Stat[20];
		releaseLvls = new Stat[20];
	}
	
	public void RecordStats(int score, int stars, int type, int id)
	{
		if (type == Game.PUZZLE_ID) puzzleLvls[id-1].update(score, stars);
		if (type == Game.LIGHTNING_ID) lightningLvls[id-1].update(score, stars);
		if (type == Game.ELIMINATION_ID) eliminationLvls[id-1].update(score, stars);
		if (type == Game.RELEASE_ID) releaseLvls[id-1].update(score, stars);
	}
	
}
