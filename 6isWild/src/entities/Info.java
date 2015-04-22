package entities;

public class Info {
	int movesPlayed;
	int movesTotal;
	int timeTotal;
	int timeLeft;
	int swaps;
	int shuffles;
	int removes;
	int score;
	int[] starRequirements; //index 0 = 1 star req, 1 -> 2 stars, 2 -> 3 stars
	int[] valueFrequencies;
	int[] multiplierFrequencies;
	
	public int[] getStarRequirements(){ 
		return this.starRequirements;
	}
	
	public int getScore(){
		return this.score;
	}
}
