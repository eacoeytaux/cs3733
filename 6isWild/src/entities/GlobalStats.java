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
		
		for (int i = 0; i < 20; i++) {
			puzzleLvls[i] = new Stat(0, 0);
			lightningLvls[i] = new Stat(0, 0);
			eliminationLvls[i] = new Stat(0, 0);
			releaseLvls[i] = new Stat(0, 0);
		}
	}
	
	public void RecordStats(int score, int stars, int type, int id)
	{
		if (type == Game.PUZZLE_ID) puzzleLvls[id-1].update(score, stars);
		if (type == Game.LIGHTNING_ID) lightningLvls[id-1].update(score, stars);
		if (type == Game.ELIMINATION_ID) eliminationLvls[id-1].update(score, stars);
		if (type == Game.RELEASE_ID) releaseLvls[id-1].update(score, stars);
	}
	
	public boolean levelCompleted(int type, int id) {
		if (type == Game.PUZZLE_ID) return puzzleLvls[id].completed();
		if (type == Game.LIGHTNING_ID) return lightningLvls[id].completed();
		if (type == Game.ELIMINATION_ID) return eliminationLvls[id].completed();
		if (type == Game.RELEASE_ID) return releaseLvls[id].completed();
		else return false;
	}
}
