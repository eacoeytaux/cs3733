package entities;

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
}
