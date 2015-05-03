package entities;

import java.io.Serializable;

/**
 * 
 * @author Jon Swain
 * @author Ethan Coeytaux
 *
 */

public class Stat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int score;
	int stars;
	
	public Stat (int score, int stars){
		this.score = score;
		this.stars = stars;
	}
	
	public int getScore(){
		return score;
	}
	

	public void setScore(int score){
		this.score = score;
	}
	
	public int getStars(){
		return stars;
	}
	
	public void setStars(int newStars){
		this.stars = newStars;
	}
	
	/**
	 * updates score and stars if new score is higher than stored values
	 * @param score
	 * @param stars
	 */
	public void update(int score, int stars) {
		if (score > this.score) this.score = score;
		if (stars > this.stars) this.stars = stars;
	}
	
}
