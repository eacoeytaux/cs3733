package controllers;

import boundaries.BlueprintDisplay;
import entities.Blueprint;

/**
 * 
 * @author
 *
 */

public class ChangeMultiplierProbability{
	Blueprint blueprint;
	BlueprintDisplay display;
	int probability;
	
	public ChangeMultiplierProbability(BlueprintDisplay display, Blueprint blueprint, int prob){
		this.probability = prob;
		this.display = display;
		this.blueprint = blueprint;
	}
}
