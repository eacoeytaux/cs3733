package entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Model {
	ArrayList<PuzzleLevel> puzzleLevels;
	ArrayList<LightningLevel> lightningLevels;
	ArrayList<EliminationLevel> eliminationLevels;
	ArrayList<ReleaseLevel> releaseLevels;
	GlobalStats globalStats;

	Blueprint blueprint = new Blueprint();
	public PuzzleLevel level;


	public Model() {

		blueprint.setValues(Game.PUZZLE_ID, 5, 4, 3, 40, new int[]{2,2,2}, new int[]{20,20,20,20,20}, new int[]{30, 30, 40} );
		blueprint.setBoard(new Square[][]{{
			new Square(new Tile(2,1), false, false),
			new Square(new Tile(2,1), false, false),
			new Square(new Tile(2,1), false, false),
			new Square(new Tile(2,1), false, false),
			new Square(new Tile(2,1), false, false),
			new Square(new Tile(2,1), false, false),
			new Square(new Tile(2,1), false, false),
			new Square(new Tile(2,1), false, false),
			new Square(new Tile(2,1), false, false)},{

				new Square(new Tile(2,1), false, false),
				new Square(new Tile(2,1), false, false),
				new Square(new Tile(2,1), false, false),
				new Square(new Tile(2,1), false, false),
				new Square(new Tile(2,1), false, false),
				new Square(new Tile(2,1), false, false),
				new Square(new Tile(2,1), false, false),
				new Square(new Tile(4,3), false, false),
				new Square(new Tile(2,1), false, false)},{

					new Square(new Tile(2,1), false, false),
					new Square(new Tile(2,1), false, false),
					new Square(new Tile(2,1), false, false),
					new Square(new Tile(2,1), false, false),
					new Square(new Tile(2,1), false, false),
					new Square(new Tile(2,1), false, false),
					new Square(new Tile(2,1), false, false),
					new Square(new Tile(2,1), false, false),
					new Square(new Tile(2,1), false, false)},{

						new Square(new Tile(2,1), false, false),
						new Square(new Tile(2,1), false, false),
						new Square(new Tile(2,1), false, false),
						new Square(new Tile(2,1), false, false),
						new Square(new Tile(2,1), false, false),
						new Square(new Tile(2,1), false, false),
						new Square(new Tile(2,1), false, false),
						new Square(new Tile(2,1), false, false),
						new Square(new Tile(2,1), false, false)},{

							new Square(new Tile(2,1), false, false),
							new Square(new Tile(2,1), false, false),
							new Square(new Tile(2,1), false, false),
							new Square(new Tile(2,1), false, false),
							new Square(new Tile(2,1), false, false),
							new Square(new Tile(2,1), false, false),
							new Square(new Tile(2,1), false, false),
							new Square(new Tile(2,1), false, false),
							new Square(new Tile(2,1), false, false)},{

								new Square(new Tile(2,1), false, false),
								new Square(new Tile(2,1), false, false),
								new Square(new Tile(2,1), false, false),
								new Square(new Tile(2,1), false, false),
								new Square(new Tile(2,1), false, false),
								new Square(new Tile(2,1), false, false),
								new Square(new Tile(2,1), false, false),
								new Square(new Tile(2,1), false, false),
								new Square(new Tile(2,1), false, false)},{

									new Square(new Tile(2,1), false, false),
									new Square(new Tile(2,1), false, false),
									new Square(new Tile(2,1), false, false),
									new Square(new Tile(2,1), false, false),
									new Square(new Tile(2,1), false, false),
									new Square(new Tile(2,1), false, false),
									new Square(new Tile(2,1), false, false),
									new Square(new Tile(2,1), false, false),
									new Square(new Tile(2,1), false, false)},{

										new Square(new Tile(2,1), false, false),
										new Square(new Tile(2,1), false, false),
										new Square(new Tile(2,1), false, false),
										new Square(new Tile(2,1), false, false),
										new Square(new Tile(2,1), false, false),
										new Square(new Tile(2,1), false, false),
										new Square(new Tile(2,1), false, false),
										new Square(new Tile(2,1), false, false),
										new Square(new Tile(2,1), false, false)},{

											new Square(new Tile(2,1), false, false),
											new Square(new Tile(2,1), false, false),
											new Square(new Tile(2,1), false, false),
											new Square(new Tile(2,1), false, false),
											new Square(new Tile(2,1), false, false),
											new Square(new Tile(2,1), false, false),
											new Square(new Tile(2,1), false, false),
											new Square(new Tile(2,1), false, false),
											new Square(new Tile(2,1), false, false)}});


		
		level = new PuzzleLevel(loadBlueprint("./levelData/puzzleLevel1.txt"));

		puzzleLevels = new ArrayList<PuzzleLevel>();
		lightningLevels = new ArrayList<LightningLevel>(); 
		eliminationLevels = new ArrayList<EliminationLevel>(); 
		releaseLevels = new ArrayList<ReleaseLevel>(); 
		globalStats = new GlobalStats(0,0,0);	
		
		loadLevels();
	}
	
	public void loadLevels() {
		puzzleLevels.add(new PuzzleLevel(blueprint));
	}

	public Blueprint loadBlueprint(String loc) {
		Blueprint blueprint = null;
		try {
			File file = new File(loc);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			blueprint = (Blueprint)ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blueprint;
	}
}
