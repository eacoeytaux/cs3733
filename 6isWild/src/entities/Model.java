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

		lightningLevels = new ArrayList<LightningLevel>(); 

		eliminationLevels = new ArrayList<EliminationLevel>();

		releaseLevels = new ArrayList<ReleaseLevel>();

		loadLevels("levels");

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

	public void loadLevels(String fileLoc) {
		int[] index = {0, 0, 0, 0};
		
		File folder;
		
		String os = System.getProperty("os.name");
		boolean isWindows = (os.charAt(0) == 'W');
		
		//reading file is different for windows vs mac
		if (isWindows) {
			fileLoc = new File("").getAbsolutePath() + "/bin/" + fileLoc;
			folder = new File(fileLoc);
		} else {
			ClassLoader classLoader = getClass().getClassLoader();
			folder = new File(classLoader.getResource(fileLoc).getFile());
		}
		
		
		for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
				if (file.getName().equals(".DS_Store")) continue;
				System.out.println(file.getName());
				Blueprint blueprint = loadBlueprint(fileLoc + "/" + file.getName(), isWindows);
				int type = blueprint.getLevelType();
				switch (type) {
				case (Game.PUZZLE_ID):
					puzzleLevels.add(new PuzzleLevel(blueprint, index[type]++));
				break;
				case (Game.LIGHTNING_ID):
					lightningLevels.add(new LightningLevel(blueprint, index[type]++));
				break;
				case (Game.ELIMINATION_ID):
					eliminationLevels.add(new EliminationLevel(blueprint, index[type]++));
				break;
				case (Game.RELEASE_ID):
					releaseLevels.add(new ReleaseLevel(blueprint, index[type]++));
				break;
				}
			}
		}
	}

	/**
	 * loads a blueprint from a file location
	 * @param fileLoc location of the file
	 * @param isWindows if operating system is windows
	 * @return Blueprint loaded
	 */
	public Blueprint loadBlueprint(String fileLoc, boolean isWindows) {
		if (isWindows) return loadBlueprintWindows(fileLoc);
		else return loadBlueprintMac(fileLoc);
	}

	/**
	 * loads a blueprint on a non-windows operating system
	 * @param fileLoc
	 * @return
	 */
	public Blueprint loadBlueprintMac(String fileLoc) {
		try {
			System.out.println(fileLoc);
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileLoc).getFile());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Blueprint blueprint = (Blueprint)ois.readObject();
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
			//fileLoc = new File("").getAbsolutePath() + "/bin/" + fileLoc;
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


