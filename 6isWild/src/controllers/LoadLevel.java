package controllers;

import entities.Blueprint;
import boundaries.BlueprintDisplay;

public class LoadLevel {
	Blueprint blueprint;
	BlueprintDisplay display;
	
	public LoadLevel(Blueprint blueprint, BlueprintDisplay display){
		this.blueprint = blueprint;
		this.display = display;
	}
}
