package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import boundaries.Application;

public class Game {
	PuzzleLevel[] puzzleLevels;
	LightningLevel[] lightningLevels;
	EliminationLevel[] eliminationLevels;
	ReleaseLevel[] releaseLevels;
	GlobalStats globalStats;

	public Game() {
		Application application = new Application();
		
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
}
