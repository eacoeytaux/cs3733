package entities;

/*******
 * 
 * @author Jon Swain
 *
 */

public class GlobalStats {
	int timePlayed;
	int totalMoves;
	int powerUpsUsed;
	Stat puzzleLvls[];
	Stat lightningLvls[];
	Stat eliminationLvls[];
	Stat releaseLvls[];
	
	public GlobalStats(int timePlayed, int totalMoves, int powerUpsUsed){
		
	}
	
	public void RecordStats(Stat stats, int type, int id)
	{
		if (type == 1) puzzleLvls[id-1] = stats;      //type 1 = puzzle, id 1 -> index 0
		if (type == 2) lightningLvls[id-1] = stats;   //type 2 = lightning "..."
		if (type == 3) eliminationLvls[id-1] = stats;   //type 3 = elimination "..."
		if (type == 4) releaseLvls[id-1] = stats;     //type 4 = releaseLvls "..."
	}
	
}
