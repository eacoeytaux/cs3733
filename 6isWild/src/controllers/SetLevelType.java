package controllers;

import entities.Blueprint;
import boundaries.BlueprintDisplay;

public class SetLevelType {
	int type;
	Blueprint blueprint;
	BlueprintDisplay display;
	
	public SetLevelType(int type, Blueprint bp, BlueprintDisplay bpd){
		this.type = type;
		this.blueprint = bp;
		this.display = bpd;
	}
}
