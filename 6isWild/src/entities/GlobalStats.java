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
	
	Stat puzzleLevels[];
	Stat lightningLevels[];
	Stat eliminationLevels[];
	Stat releaseLevels[];
	
	public GlobalStats() {
		puzzleLevels = new Stat[20];
		lightningLevels = new Stat[20];
		eliminationLevels = new Stat[20];
		releaseLevels = new Stat[20];

		for (int i = 0; i < 20; i++) {
			puzzleLevels[i] = new Stat(0, 0);
			lightningLevels[i] = new Stat(0, 0);
			eliminationLevels[i] = new Stat(0, 0);
			releaseLevels[i] = new Stat(0, 0);
		}
	}
	
	public void setStats(Stat stats, int type, int id)
	{
		if (type == Game.PUZZLE_ID) puzzleLevels[id].update(stats.score, stats.stars);
		if (type == Game.LIGHTNING_ID) lightningLevels[id].update(stats.score, stats.stars);
		if (type == Game.ELIMINATION_ID) eliminationLevels[id].update(stats.score, stats.stars);
		if (type == Game.RELEASE_ID) releaseLevels[id].update(stats.score, stats.stars);
	}
	
	public boolean levelCompleted(int type, int id) {
		if (type == Game.PUZZLE_ID) return puzzleLevels[id].completed();
		if (type == Game.LIGHTNING_ID) return lightningLevels[id].completed();
		if (type == Game.ELIMINATION_ID) return eliminationLevels[id].completed();
		if (type == Game.RELEASE_ID) return releaseLevels[id].completed();
		else return false;
	}
	
	public Stat getStats(int type, int id)
	{
		if (type == Game.PUZZLE_ID) return puzzleLevels[id];
		if (type == Game.LIGHTNING_ID) return lightningLevels[id];
		if (type == Game.ELIMINATION_ID) return eliminationLevels[id];
		if (type == Game.RELEASE_ID) return releaseLevels[id];
		return new Stat(0,0);

	}
}
