package controllers;

import entities.Blueprint;
import boundaries.BlueprintDisplay;

public class SetStarReq extends AbstractBuilderMove{
	int score;
	Blueprint blueprint;
	BlueprintDisplay display;
	
	public SetStarReq(int score, Blueprint bp, BlueprintDisplay bpd){
		this.score = score;
		this. blueprint = bp;
		this.display = bpd;
	}
}
