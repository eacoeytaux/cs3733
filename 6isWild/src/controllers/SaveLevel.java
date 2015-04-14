package controllers;

import entities.Blueprint;
import boundaries.BlueprintDisplay;

public class SaveLevel extends AbstractBuilderMove{
	Blueprint blueprint;
	BlueprintDisplay display;
	
	public SaveLevel(Blueprint blueprint, BlueprintDisplay display){
		this.blueprint = blueprint;
		this.display = display;
	}
}
