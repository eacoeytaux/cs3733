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
		eliminationLevels = new ArrayList<EliminationLevel>(); 
		releaseLevels = new ArrayList<ReleaseLevel>(); 
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
		Blueprint fillerBlueprint = new Blueprint(2, 2, 2, 2, 2, new int[]{3,3,3}, new int[]{3,3,3,3,3,3}, new int[]{3,3,3}, fillerBoard);
		PuzzleLevel fillerLevel = new PuzzleLevel(fillerBlueprint);
		puzzleLevels.add(fillerLevel);
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
		return puzzleLevels.get(0); //TODO
	}
	
	public void setCurrentLevel(AbstractLevel currentLevel){
		this.currentLevel =currentLevel;
	}
	
	public AbstractLevel getCurrentLevel(){
		return this.currentLevel;
	}
	
}


