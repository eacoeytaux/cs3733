package entities;

import boundaries.Application;
import boundaries.BuilderApplication;

public class Builder {
	Blueprint blueprint;
	BuilderApplication builderApplication;
	
	
	public Builder() {
		blueprint = new Blueprint();
		builderApplication = new BuilderApplication(blueprint);
	}

	public static void main(String[] args) {
		new Builder();
	}
	
	/**
	 * disposes of builder when closed
	 */
	public void closeBuilder() {
		builderApplication.dispose();
	}
}
