package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import boundaries.*;

public class Game {
	ArrayList<PuzzleLevel> puzzleLevels;
	ArrayList<LightningLevel> lightningLevels;
	ArrayList<EliminationLevel> eliminationLevels;
	ArrayList<ReleaseLevel> releaseLevels;
	GlobalStats globalStats;

	public Game() {
		
		/*BufferedImage splashScreen;
		BufferedImage splashScreenGlitch1;
		BufferedImage splashScreenGlitch2;
		
		try { //load images
			splashScreen = ImageIO.read(getClass().getResourceAsStream("/SplashScreen.png"));
			splashScreenGlitch1 = ImageIO.read(getClass().getResourceAsStream("/SplashScreenGlitch1.jpg"));
			splashScreenGlitch2 = ImageIO.read(getClass().getResourceAsStream("/SplashScreenGlitch2.jpg"));
			application.drawImage(splashScreen);
			Thread.sleep(3000);
			application.drawImage(splashScreenGlitch2);
			Thread.sleep(500);
			application.drawImage(splashScreenGlitch1);
			Thread.sleep(250);
			application.goToMainMenu();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

	public static void main(String[] args) {
		Game game = new Game();
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
