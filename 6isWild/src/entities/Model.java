package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

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

		System.out.println("puzzpack");

		puzzleLevels = new ArrayList<PuzzleLevel>();
		puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/puzzleLevel1.txt"), 0));
		puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/puzzleLevel1.txt"), 1));
		puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/puzzleLevel1.txt"), 2));
		puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/puzzleLevel1.txt"), 3));


		System.out.println("lightning");
		lightningLevels = new ArrayList<LightningLevel>(); 
		lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt"), 0));
		lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt"), 1));
		lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt"), 2));
		lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt"), 3));
		
		System.out.println("liminaterion");
		
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
			globalStats.recordStats(puzzleLevels.get(i).getStats(), Game.PUZZLE_ID, puzzleLevels.get(i).getLevel());
		}
		for(int i = 0; i < lightningLevels.size(); i++)
		{
			globalStats.recordStats(lightningLevels.get(i).getStats(), Game.LIGHTNING_ID, lightningLevels.get(i).getLevel());
		}
		for(int i = 0; i < eliminationLevels.size(); i++)
		{
			globalStats.recordStats(eliminationLevels.get(i).getStats(), Game.ELIMINATION_ID, eliminationLevels.get(i).getLevel());
		}
		for(int i = 0; i < releaseLevels.size(); i++)
		{
			globalStats.recordStats(releaseLevels.get(i).getStats(), Game.RELEASE_ID, releaseLevels.get(i).getLevel());
		}
	}

		/*
		//rest is filler level
		Square[][] fillerSquares = new Square[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				fillerSquares[i][j] = new Square(new Tile(j % 5 +1, i % 5 + 1), false, false);
				fillerSquares[i][j].setRowCol(j % 5 +1, i % 5 +1);
			}
		}
		Board fillerBoard = new Board(fillerSquares, new int[]{3,3,3,3,3,3}, new int[]{3,3,3});
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				fillerSquares[i][j].setParentBoard(fillerBoard);
			}
		}

		Blueprint fillerPuzzleBlueprint = new Blueprint(fillerBoard);
		fillerPuzzleBlueprint.setValues(Game.PUZZLE_ID, 2, 2, 2, 2, new int[]{3,3,3}, new int[]{3,3,3,3,3,3}, new int[]{3,3,3});
		Blueprint fillerLightningBlueprint = new Blueprint(fillerBoard);
		fillerLightningBlueprint.setValues(Game.LIGHTNING_ID, 2, 2, 2, 10, new int[]{3,3,3}, new int[]{3,3,3,3,3,3}, new int[]{3,3,3});
		Blueprint fillerEliminationBlueprint = new Blueprint(fillerBoard);
		fillerEliminationBlueprint.setValues(Game.ELIMINATION_ID, 2, 2, 2, 10, new int[]{3,3,3}, new int[]{3,3,3,3,3,3}, new int[]{3,3,3});
		Blueprint fillerReleaseBlueprint = new Blueprint(fillerBoard);
		fillerReleaseBlueprint.setValues(Game.RELEASE_ID, 2, 2, 2, 10, new int[]{3,3,3}, new int[]{3,3,3,3,3,3}, new int[]{3,3,3});
		PuzzleLevel fillerPuzzleLevel1 = new PuzzleLevel(fillerPuzzleBlueprint, 0);
		PuzzleLevel fillerPuzzleLevel2 = new PuzzleLevel(fillerPuzzleBlueprint, 1);
		PuzzleLevel fillerPuzzleLevel3 = new PuzzleLevel(fillerPuzzleBlueprint, 2);
		PuzzleLevel fillerPuzzleLevel4 = new PuzzleLevel(fillerPuzzleBlueprint, 3);
		LightningLevel fillerLightningLevel1 = new LightningLevel(fillerLightningBlueprint, 0);
		LightningLevel fillerLightningLevel2 = new LightningLevel(fillerLightningBlueprint, 1);
		LightningLevel fillerLightningLevel3 = new LightningLevel(fillerLightningBlueprint, 2);
		LightningLevel fillerLightningLevel4 = new LightningLevel(fillerLightningBlueprint, 3);
		EliminationLevel fillerEliminationLevel1 = new EliminationLevel(fillerEliminationBlueprint, 0);
		EliminationLevel fillerEliminationLevel2 = new EliminationLevel(fillerEliminationBlueprint, 1);
		EliminationLevel fillerEliminationLevel3 = new EliminationLevel(fillerEliminationBlueprint, 2);
		EliminationLevel fillerEliminationLevel4 = new EliminationLevel(fillerEliminationBlueprint, 3);
		ReleaseLevel fillerReleaseLevel1 = new ReleaseLevel(fillerReleaseBlueprint, 0);
		ReleaseLevel fillerReleaseLevel2 = new ReleaseLevel(fillerReleaseBlueprint, 1);
		ReleaseLevel fillerReleaseLevel3 = new ReleaseLevel(fillerReleaseBlueprint, 2);
		ReleaseLevel fillerReleaseLevel4 = new ReleaseLevel(fillerReleaseBlueprint, 3);


		puzzleLevels.add(fillerPuzzleLevel1);
		puzzleLevels.add(fillerPuzzleLevel2);
		puzzleLevels.add(fillerPuzzleLevel3);
		puzzleLevels.add(fillerPuzzleLevel4);
		lightningLevels.add(fillerLightningLevel1);
		lightningLevels.add(fillerLightningLevel2);
		lightningLevels.add(fillerLightningLevel3);
		lightningLevels.add(fillerLightningLevel4);
		eliminationLevels.add(fillerEliminationLevel1);
		eliminationLevels.add(fillerEliminationLevel2);
		eliminationLevels.add(fillerEliminationLevel3);
		eliminationLevels.add(fillerEliminationLevel4);
		releaseLevels.add(fillerReleaseLevel1);
		releaseLevels.add(fillerReleaseLevel2);
		releaseLevels.add(fillerReleaseLevel3);
		releaseLevels.add(fillerReleaseLevel4);
		
		
		////////////////////////////////////////////////

		//rest is filler level
		fillerSquares = new Square[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				fillerSquares[i][j] = new Square(new Tile(j % 5 +1, i % 5 + 1), false, false);
				fillerSquares[i][j].setRowCol(j % 5 +1, i % 5 +1);
			}
		}
		fillerBoard = new Board(fillerSquares, new int[]{3,3,3,3,3,3}, new int[]{3,3,3});
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				fillerSquares[i][j].setParentBoard(fillerBoard);
			}
		}

		
		//EliminationLevel fillerEliminationLevel = new EliminationLevel(fillerPuzzleBlueprint);
		//eliminationLevels.add(fillerEliminationLevel);


		fillerSquares = new Square[9][9];
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				fillerSquares[i][j] = new Square(new Tile(j % 5 +1, i % 5 + 1), false, false);
				fillerSquares[i][j].setRowCol(j % 5 +1, i % 5 +1);
			}
		}
		fillerBoard = new Board(fillerSquares, new int[]{3,3,3,3,3,3}, new int[]{3,3,3});
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				fillerSquares[i][j].setParentBoard(fillerBoard);
			}
		}

		//ReleaseLevel fillerReleaseLevel = new ReleaseLevel(fillerPuzzleBlueprint);
		//releaseLevels.add(fillerReleaseLevel);


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


