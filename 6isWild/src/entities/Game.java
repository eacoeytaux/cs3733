package entities;

import boundaries.Application;

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
	
	/**
	 * Call all initialize functions
	 */
	private void init() {
		initializeEntities();
		initializeBoundaries();
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
	private void initializeBoundaries(){
		application = new Application(model);
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
}
