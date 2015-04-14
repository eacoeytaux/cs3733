package controllers;

import boundaries.BlueprintDisplay;
import entities.Blueprint;

public class ChangeValueProbability extends AbstractBuilderMove{
	Blueprint blueprint;
	BlueprintDisplay display;
	int probability;
	
	public ChangeValueProbability(BlueprintDisplay display, Blueprint blueprint, int prob){
		this.probability = prob;
		this.display = display;
		this.blueprint = blueprint;
	}
}
