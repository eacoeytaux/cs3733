package controllers;

import boundaries.BlueprintDisplay;
import entities.Blueprint;

public class SetStartingValue extends AbstractBuilderMove{
	Blueprint blueprint;
	BlueprintDisplay display;
	int value;
	
	public SetStartingValue(BlueprintDisplay display, Blueprint blueprint, int value){
		this.value = value;
		this.display = display;
		this.blueprint = blueprint;
	}
}
