package entities;

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
			

		level = new PuzzleLevel(blueprint);
		
		puzzleLevels = new ArrayList<PuzzleLevel>();
		puzzleLevels.add(0, new PuzzleLevel(blueprint));
		lightningLevels = new ArrayList<LightningLevel>(); 
		eliminationLevels = new ArrayList<EliminationLevel>(); 
		releaseLevels = new ArrayList<ReleaseLevel>(); 
		globalStats = new GlobalStats(0,0,0);	
	}
}
