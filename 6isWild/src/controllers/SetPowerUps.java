package controllers;

import entities.Blueprint;
import boundaries.BlueprintDisplay;

public class SetPowerUps{
	int amount;
	Blueprint blueprint;
	BlueprintDisplay display;
	
	public SetPowerUps(int amount, Blueprint bp, BlueprintDisplay bpd){
		this.amount = amount;
		this. blueprint = bp;
		this.display = bpd;
	}
}
