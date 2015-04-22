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
	
	public void setScore(int newScore){
		this.score = newScore;
	}
	
	public int getStars(){
		return stars;
	}
	
	public void setStars(int newStars){
		this.stars = newStars;
	}
}
