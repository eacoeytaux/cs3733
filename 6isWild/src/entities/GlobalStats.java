package entities;

import java.util.ArrayList;

/*******
 * 
 * @author Jon Swain
 *
 */

public class GlobalStats {
	int timePlayed;
	int totalMoves;
	int powerUpsUsed;
	Stat puzzleLevels[];
	Stat lightningLevels[];
	Stat eliminationLevels[];
	Stat releaseLevels[];
	
	public GlobalStats(int timePlayed, int totalMoves, int powerUpsUsed){
		puzzleLevels = new Stat[4];
		lightningLevels = new Stat[4];
		eliminationLevels = new Stat[4];
		releaseLevels = new Stat[4];

	}
	
	public void recordStats(Stat stats, int type, int id)
	{
		if (type == Game.PUZZLE_ID) puzzleLevels[id] = stats;     //type 1 = puzzle, id 1 -> index 0
		if (type == Game.LIGHTNING_ID) lightningLevels[id] = stats;   //type 2 = lightning "..."
		if (type == Game.ELIMINATION_ID) eliminationLevels[id] = stats;   //type 3 = elimination "..."
		if (type == Game.RELEASE_ID) releaseLevels[id] = stats;     //type 4 = releaseLvls "..."
	}
	
}
