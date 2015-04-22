package entities;

public class Stat {
	int score;
	int stars;
	
	public Stat (int score, int stars){
		this.score = score;
		this.stars = stars;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getStars(){
		return stars;
	}
}
