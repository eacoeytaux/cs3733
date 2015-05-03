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
		//puzzleLevels.add(new PuzzleLevel(loadBlueprint("levels/smileyLevel.txt")));
		lightningLevels = new ArrayList<LightningLevel>(); 
		releaseLevels = new ArrayList<ReleaseLevel>();
		//releaseLevels.add(new ReleaseLevel(loadBlueprint("levels/releaseLevelTest.txt")));
		eliminationLevels = new ArrayList<EliminationLevel>();
		//lightningLevels.add(new LightningLevel(loadBlueprint("levels/lightningLevel1.txt")));
		//releaseLevels.add(new ReleaseLevel(loadBlueprint("levels/levelre.txt"))); 
		globalStats = new GlobalStats();	
		
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
		fillerPuzzleBlueprint.setValues(0, 2, 2, 2, 2, new int[]{3,3,3}, new int[]{3,3,3,3,3,3}, new int[]{3,3,3});
		PuzzleLevel fillerLevel = new PuzzleLevel(fillerPuzzleBlueprint);
		puzzleLevels.add(fillerLevel);
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
		Blueprint fillerLightningBlueprint = new Blueprint(fillerBoard);
		fillerLightningBlueprint.setValues(1, 2, 2, 2, 10, new int[]{3,3,3}, new int[]{3,3,3,3,3,3}, new int[]{3,3,3});
		LightningLevel fillerLightningLevel = new LightningLevel(fillerLightningBlueprint);
		lightningLevels.add(fillerLightningLevel);
		EliminationLevel fillerEliminationLevel = new EliminationLevel(fillerPuzzleBlueprint);
		eliminationLevels.add(fillerEliminationLevel);
		
		
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

		ReleaseLevel fillerReleaseLevel = new ReleaseLevel(fillerPuzzleBlueprint);
		releaseLevels.add(fillerReleaseLevel);
		
		
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


