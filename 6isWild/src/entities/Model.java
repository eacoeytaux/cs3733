package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Model {
	ArrayList<PuzzleLevel> puzzleLevels;
	ArrayList<LightningLevel> lightningLevels;
	ArrayList<EliminationLevel> eliminationLevels;
	ArrayList<ReleaseLevel> releaseLevels;
	GlobalStats globalStats;

	//TODO delete these values, for debugging only
	Blueprint blueprint = new Blueprint();
	public PuzzleLevel level;


	public Model() {

		blueprint.setValues(Game.PUZZLE_ID, 5, 4, 3, 40, new int[]{2,2,2}, new int[]{20,20,20,20,20}, new int[]{30, 30, 40} );

		Square[][] squareArray = new Square[9][9];

		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				squareArray[i][j] = new Square(new Tile(i,j), false, false, null, i, j);
			}
			blueprint.setBoard(squareArray);
		}


		level = new PuzzleLevel(loadBlueprint("./levelData/puzzleLevel1.txt"));

		puzzleLevels = new ArrayList<PuzzleLevel>();
		puzzleLevels.add(0, new PuzzleLevel(blueprint));
		lightningLevels = new ArrayList<LightningLevel>(); 
		eliminationLevels = new ArrayList<EliminationLevel>(); 
		releaseLevels = new ArrayList<ReleaseLevel>(); 
		globalStats = new GlobalStats(0,0,0);	
	}

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
}


