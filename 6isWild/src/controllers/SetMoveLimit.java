package controllers;

import entities.Blueprint;
import boundaries.BlueprintDisplay;

public class SetMoveLimit{
	int moveLimit;
	Blueprint blueprint;
	BlueprintDisplay display;
	
	public SetMoveLimit(int moves, Blueprint bp, BlueprintDisplay bpd){
		this.moveLimit = moves;
		this. blueprint = bp;
		this.display = bpd;
	}
}
