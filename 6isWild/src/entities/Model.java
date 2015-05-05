package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * the model contains all levels and stats for the game
 * @author Ethan Coeytaux
 * @author Hugh Whelan
 *
 */
public class Model {
	ArrayList<PuzzleLevel> puzzleLevels;
	ArrayList<LightningLevel> lightningLevels;
	ArrayList<EliminationLevel> eliminationLevels;
	ArrayList<ReleaseLevel> releaseLevels;

	AbstractLevel currentLevel;

	GlobalStats globalStats;

	public Model() {


		puzzleLevels = new ArrayList<PuzzleLevel>();
		puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/puzzleLevel1.txt"), 0));
		puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/puzzleLevel2.txt"), 1));
		puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/puzzleLevel1.txt"), 2));
		puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/puzzleLevel1.txt"), 3));


		lightningLevels = new ArrayList<LightningLevel>(); 
		lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt"), 0));
		lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt"), 1));
		lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt"), 2));
		lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt"), 3));
		
		
		eliminationLevels = new ArrayList<EliminationLevel>();
		eliminationLevels.add(new EliminationLevel(loadBlueprint("levels/eliminationLevel1.txt"), 0));
		eliminationLevels.add(new EliminationLevel(loadBlueprint("levels/eliminationLevel1.txt"), 1));
		eliminationLevels.add(new EliminationLevel(loadBlueprint("levels/eliminationLevel1.txt"), 2));
		eliminationLevels.add(new EliminationLevel(loadBlueprint("levels/eliminationLevel1.txt"), 3));

		releaseLevels = new ArrayList<ReleaseLevel>();
		releaseLevels.add(new ReleaseLevel(loadBlueprint("levels/releaseLevel1.txt"), 0));
		releaseLevels.add(new ReleaseLevel(loadBlueprint("levels/releaseLevel1.txt"), 1));
		releaseLevels.add(new ReleaseLevel(loadBlueprint("levels/releaseLevel1.txt"), 2));
		releaseLevels.add(new ReleaseLevel(loadBlueprint("levels/releaseLevel1.txt"), 3));

		//releaseLevels.add(new ReleaseLevel(loadBlueprint("levels/releaseLevelTest.txt")));


		globalStats = new GlobalStats();	
		for(int i = 0; i < puzzleLevels.size(); i++)
		{
			globalStats.setStats(puzzleLevels.get(i).getStats(), Game.PUZZLE_ID, puzzleLevels.get(i).getLevel());
		}
		for(int i = 0; i < lightningLevels.size(); i++)
		{
			globalStats.setStats(lightningLevels.get(i).getStats(), Game.LIGHTNING_ID, lightningLevels.get(i).getLevel());
		}
		for(int i = 0; i < eliminationLevels.size(); i++)
		{
			globalStats.setStats(eliminationLevels.get(i).getStats(), Game.ELIMINATION_ID, eliminationLevels.get(i).getLevel());
		}
		for(int i = 0; i < releaseLevels.size(); i++)
		{
			globalStats.setStats(releaseLevels.get(i).getStats(), Game.RELEASE_ID, releaseLevels.get(i).getLevel());
		}
	}


	/**
	 * loads a blueprint from a file location
	 * @param fileLoc location of the file
	 * @return Blueprint loaded
	 */
	public Blueprint loadBlueprint(String fileLoc) {
		String os = System.getProperty("os.name");
		if (os.charAt(0) == 'W') return loadBlueprintWindows(fileLoc);
		else return loadBlueprintMac(fileLoc);
	}
	
	/**
	 * loads a blueprint on a mac operating system
	 * @param fileLoc
	 * @return
	 */
	public Blueprint loadBlueprintMac(String fileLoc) {
		try {
			System.out.println(fileLoc);
			//System.out.println(System.getProperty("os.name"));
			ClassLoader classLoader = getClass().getClassLoader();
			//System.out.println("attempting to open file name " + fileLoc);
			File file = new File(classLoader.getResource(fileLoc).getFile());
			FileInputStream fis = new FileInputStream(file);
			//System.out.println("created fis");
			//InputStreamReader in = new InputStreamReader();
			ObjectInputStream ois = new ObjectInputStream(fis);
			//System.out.println("trying to read blueprint");
			Blueprint blueprint = (Blueprint)ois.readObject();
			//System.out.println("" + blueprint.getLevelType());
			fis.close();
			return blueprint;
		} catch (Exception e) {
			e.printStackTrace(); //TODO print error
		}
		return null;
	}

	/**
	 * loads a blueprint on a window operating system
	 * @param fileLoc
	 * @return
	 */
	public Blueprint loadBlueprintWindows(String fileLoc) {
		try {
			fileLoc = new File("").getAbsolutePath() + "/bin/" + fileLoc;
			FileInputStream fis = new FileInputStream(fileLoc);
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
		switch ( gameMode ){
		case Game.PUZZLE_ID:
			return puzzleLevels.get(levelNum);
		case Game.LIGHTNING_ID:
			return lightningLevels.get(levelNum);
		case Game.ELIMINATION_ID: 
			return eliminationLevels.get(levelNum);
		case Game.RELEASE_ID:
			return releaseLevels.get(levelNum);
		default:
			return null;
		}
	}

	public void setCurrentLevel(AbstractLevel currentLevel){
		this.currentLevel =currentLevel;
	}

	public AbstractLevel getCurrentLevel(){
		return this.currentLevel;
	}

	public GlobalStats getGlobalStats() {
		return globalStats;
	}

}


