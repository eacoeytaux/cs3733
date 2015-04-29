package controllers;

import entities.Blueprint;
import boundaries.BlueprintDisplay;

public class MakeInert{
	Blueprint blueprint;
	BlueprintDisplay display;
	
	public MakeInert(Blueprint blueprint, BlueprintDisplay display){
		this.blueprint = blueprint;
		this.display = display;
	}
}