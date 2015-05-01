package entities;

import java.io.File;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * the model contains all levels and stats for the game
 * @author
 *
 */
public class Model {
	ArrayList<PuzzleLevel> puzzleLevels;
	ArrayList<LightningLevel> lightningLevels;
	ArrayList<EliminationLevel> eliminationLevels;
	ArrayList<ReleaseLevel> releaseLevels;
	GlobalStats globalStats;

	public Model() {

		puzzleLevels = new ArrayList<PuzzleLevel>();
		puzzleLevels.add(new PuzzleLevel(loadBlueprint("./levelData/puzzleLevel1.txt")));
		lightningLevels = new ArrayList<LightningLevel>(); 
		eliminationLevels = new ArrayList<EliminationLevel>(); 
		releaseLevels = new ArrayList<ReleaseLevel>(); 
		globalStats = new GlobalStats(0,0,0);	
	}

	/**
	 * loads a blueprint from a file location
	 * @param fileLoc location of the file
	 * @return Blueprint loaded
	 */
	public Blueprint loadBlueprint(String fileLoc) {
		try {
			File file = new File(fileLoc);
			FileInputStream fis = new FileInputStream(file);
			//InputStreamReader in = new InputStreamReader();
			ObjectInputStream ois = new ObjectInputStream(fis);
			Blueprint blueprint = (Blueprint)ois.readObject();
			fis.close();
			return blueprint;
		} catch (Exception e) {
			e.printStackTrace(); //TODO print error
		}
		return null;
	}
	
	public AbstractLevel getLevel(int gameMode, int levelNum) {
		return puzzleLevels.get(0); //TODO
	}
}


