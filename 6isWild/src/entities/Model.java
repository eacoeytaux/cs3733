package entities;

import java.util.ArrayList;

public class Model {
	ArrayList<PuzzleLevel> puzzleLevels;
	ArrayList<LightningLevel> lightningLevels;
	ArrayList<EliminationLevel> eliminationLevels;
	ArrayList<ReleaseLevel> releaseLevels;
	GlobalStats globalStats;
	
	public Model() {
		puzzleLevels = new ArrayList<PuzzleLevel>();
		puzzleLevels.add(0, new PuzzleLevel());
		lightningLevels = new ArrayList<LightningLevel>(); 
		eliminationLevels = new ArrayList<EliminationLevel>(); 
		releaseLevels = new ArrayList<ReleaseLevel>(); 
		globalStats = new GlobalStats(0,0,0);	
	}
}
