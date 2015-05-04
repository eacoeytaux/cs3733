package controllers;

/**
 * 
 * @author Jon Sawin
 * 
 */

import entities.LightningLevel;

public class CompleteLightning {
	LightningLevel level;
	
	public CompleteLightning(LightningLevel level){
		this.level = level;
		new SaveScore(level);
	}
}
