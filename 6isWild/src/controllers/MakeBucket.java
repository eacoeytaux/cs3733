package controllers;

import entities.Blueprint;
import boundaries.BlueprintDisplay;

public class MakeBucket extends AbstractBuilderMove{
	Blueprint blueprint;
	BlueprintDisplay display;
	
	public MakeBucket(Blueprint blueprint, BlueprintDisplay display){
		this.blueprint = blueprint;
		this.display = display;
	}
}