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
	
	public Info(int movesTotal, int timeTotal, int swaps, int shuffles, int removes, int[] starRequirements, int[] multiplierFrequencies){
		this.movesPlayed = 0;
		this.movesTotal = movesTotal;
		this.timeLeft = 0;
		this.timeTotal = timeTotal;
		this.swaps = swaps;
		this.shuffles = shuffles;
		this.removes = removes;
		this.starRequirements = starRequirements;
		this.multiplierFrequencies = multiplierFrequencies;
		
	}
	
	public int[] getStarRequirements(){ 
		return this.starRequirements;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public int getMovesTotal(){
		return this.movesTotal;
	}
	
	public int getMovesPlayed(){
		return this.movesPlayed;
	}
	
	public int getSwaps(){
		return this.swaps;
	}
	
	public int getShuffles(){
		return this.shuffles;
	}
	
	public int getRemoves(){
		return this.removes;
	}
}
