package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import boundaries.*;

public class Game {
	public static final int PUZZLE_ID = 0;
	public static final int LIGHTNING_ID = 1;
	public static final int ELIMINATION_ID = 2;
	public static final int RELEASE_ID = 3;
	
	ArrayList<PuzzleLevel> puzzleLevels;
	ArrayList<LightningLevel> lightningLevels;
	ArrayList<EliminationLevel> eliminationLevels;
	ArrayList<ReleaseLevel> releaseLevels;
	GlobalStats globalStats;

	public Game() {
		init();
	}

	public static void main(String[] args) {
		Game game = new Game();
	}
	
	private void init() {
		initializeEntities();
		initializeBoundaries();
		initializeControllers();
	}
	
	private void initializeEntities(){
		puzzleLevels = new ArrayList<PuzzleLevel>();
		puzzleLevels.add(0, new PuzzleLevel());
		lightningLevels = new ArrayList<LightningLevel>(); 
		eliminationLevels = new ArrayList<EliminationLevel>(); 
		releaseLevels = new ArrayList<ReleaseLevel>(); 
		globalStats = new GlobalStats(0,0,0);		
	}
	
	private void initializeBoundaries(){
		Application application = new Application(this);
	}
	
	private void initializeControllers(){
		
	}
	
	public void getLevel(int type, int n){
		
	}
}
