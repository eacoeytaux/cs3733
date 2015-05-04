package boundaries;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * displays splash screen
 * @author Ethan Coeytaux
 *
 */
public class SplashScreenDisplay extends JPanel {
	private static final long serialVersionUID = 1L;

	public SplashScreenDisplay() {
		super();
		setBackground(new Color(0x006600));
		setPreferredSize(new Dimension(800, 600));
		setFocusable(true);
		requestFocus();
	}
	
	/**
	 * loads and display splash screen
	 */
	public void setSplashScreen() {
		Graphics g = getGraphics();
		BufferedImage splashScreen;
		BufferedImage splashScreenGlitch1;
		BufferedImage splashScreenGlitch2;
		BufferedImage splashScreenGlitch3;
		try { //load images
			splashScreen = ImageIO.read(getClass().getResourceAsStream("/SplashScreen.png"));
			splashScreenGlitch1 = ImageIO.read(getClass().getResourceAsStream("/SplashScreenGlitch1.jpg"));
			splashScreenGlitch2 = ImageIO.read(getClass().getResourceAsStream("/SplashScreenGlitch2.jpg"));
			splashScreenGlitch3 = ImageIO.read(getClass().getResourceAsStream("/SplashScreenGlitch3.jpg"));
			g.drawImage(splashScreen, 0, 0, splashScreen.getWidth(), splashScreen.getHeight(), null);
			Thread.sleep(2000);
			g.drawImage(splashScreenGlitch1, 0, 0, null);
			Thread.sleep(150);
			g.drawImage(splashScreenGlitch3, 0, 0, null);
			Thread.sleep(200);
			g.drawImage(splashScreenGlitch2, 0, 0, null);
			Thread.sleep(25);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
