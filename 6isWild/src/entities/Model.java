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
	
	AbstractLevel currentLevel;
	
	GlobalStats globalStats;

	public Model() {

		puzzleLevels = new ArrayList<PuzzleLevel>();
		//puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/smileyLevel.txt")));
		lightningLevels = new ArrayList<LightningLevel>(); 
		releaseLevels = new ArrayList<ReleaseLevel>();
		//releaseLevels.add(new ReleaseLevel(loadBlueprint("levels/releaseLevelTest.txt")));
		eliminationLevels = new ArrayList<EliminationLevel>();
		//lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt")));
		//releaseLevels.add(new ReleaseLevel(loadBlueprint("levels/levelre.txt"))); 
		globalStats = new GlobalStats(0,0,0);	
		
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
		
		for(int i = 0; i < puzzleLevels.size(); i++)
		{
			globalStats.recordStats(puzzleLevels.get(i).getStats(), Game.PUZZLE_ID, i);
		}
		for(int i = 0; i < lightningLevels.size(); i++)
		{
			globalStats.recordStats(lightningLevels.get(i).getStats(), Game.LIGHTNING_ID, i);
		}
		for(int i = 0; i < eliminationLevels.size(); i++)
		{
			globalStats.recordStats(eliminationLevels.get(i).getStats(), Game.ELIMINATION_ID, i);
		}
		for(int i = 0; i < releaseLevels.size(); i++)
		{
			globalStats.recordStats(releaseLevels.get(i).getStats(), Game.RELEASE_ID, i);
		}
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
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(fileLoc).getFile());
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
	
}


