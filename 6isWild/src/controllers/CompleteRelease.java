package controllers;

/*******
 * 
 * @author Jon Sawin
 * 
 */

import entities.ReleaseLevel;

public class CompleteRelease {
	ReleaseLevel level;
	
	public CompleteRelease(ReleaseLevel level){
		this.level = level;
		new SaveScore(level);
	}
}
