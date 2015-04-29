package controllers;

import entities.Blueprint;
import boundaries.BlueprintDisplay;

public class SetTimeLimit{
	int time;
	Blueprint blueprint;
	BlueprintDisplay display;
	
	public SetTimeLimit(int time, Blueprint bp, BlueprintDisplay bpd){
		this.time = time;
		this. blueprint = bp;
		this.display = bpd;
	}
}
