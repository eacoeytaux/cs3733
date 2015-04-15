package boundaries;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SplashScreenDisplay extends JPanel {
	private static final long serialVersionUID = 1L;

	public SplashScreenDisplay() {
		super();
		setPreferredSize(new Dimension(800, 600));
		setFocusable(true);
		requestFocus();
	}
	
	public void setSplashScreen() {
		Graphics g = getGraphics();
		BufferedImage splashScreen;
		BufferedImage splashScreenGlitch1;
		BufferedImage splashScreenGlitch2;
		try { //load images
			splashScreen = ImageIO.read(getClass().getResourceAsStream("/SplashScreen.png"));
			splashScreenGlitch1 = ImageIO.read(getClass().getResourceAsStream("/SplashScreenGlitch1.jpg"));
			splashScreenGlitch2 = ImageIO.read(getClass().getResourceAsStream("/SplashScreenGlitch2.jpg"));
			g.drawImage(splashScreen, 0, 0, splashScreen.getWidth(), splashScreen.getHeight(), null);
			Thread.sleep(3000);
			g.drawImage(splashScreenGlitch1, 0, 0, splashScreenGlitch1.getWidth(), splashScreenGlitch1.getHeight(), null);
			Thread.sleep(500);
			g.drawImage(splashScreenGlitch2, 0, 0, splashScreenGlitch2.getWidth(), splashScreenGlitch2.getHeight(), null);
			Thread.sleep(250);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
