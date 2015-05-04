package entities;

import boundaries.Application;

/**
 * top level class for Game
 * @author Ethan Coeytaux
 *
 */
public class Game {
	public static final int PUZZLE_ID = 0;
	public static final int LIGHTNING_ID = 1;
	public static final int ELIMINATION_ID = 2;
	public static final int RELEASE_ID = 3;
	
	Model model;
	Application application;

	public Game(boolean skipSplashScreen) {
		init(skipSplashScreen);
	}

	public static void main(String[] args) {
		new Game(false);
	}
	
	/**
	 * Call all initialize functions
	 */
	private void init(boolean skipSplashScreen) {
		initializeEntities();
		initializeBoundaries(skipSplashScreen);
		initializeControllers();
	}
	
	/**
	 * create new Model entity
	 */
	private void initializeEntities(){
		model = new Model();	
	}
	
	/**
	 * create new application boundary
	 */
	private void initializeBoundaries(boolean skipSplashScreen){
		application = new Application(model, skipSplashScreen);
	}
	
	/**
	 * initialize controllers
	 */
	private void initializeControllers(){
		
	}
	
	/**
	 * dispose of game when closed
	 */
	public void closeGame() {
		application.dispose();
	}
	
	/**
	 * return application boundary
	 * @return
	 */
	public Application getApplication() {
		return this.application;
	}
	
	public Model getModel() {
		return model;
	}
}
