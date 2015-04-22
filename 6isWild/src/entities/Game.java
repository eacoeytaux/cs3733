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
	
	Model model;
	Application application;

	public Game() {
		init();
	}

	public static void main(String[] args) {
		new Game();
	}
	
	private void init() {
		initializeEntities();
		initializeBoundaries();
		initializeControllers();
	}
	
	private void initializeEntities(){
		model = new Model();	
	}
	
	private void initializeBoundaries(){
		application = new Application(model);
	}
	
	private void initializeControllers(){
		
	}
	
	public void getLevel(int type, int n){
		
	}
}
