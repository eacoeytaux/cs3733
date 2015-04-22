package entities;

import boundaries.BuilderApplication;

public class Builder {
	Blueprint blueprint;
	
	public Builder() {
		BuilderApplication builderApplication = new BuilderApplication(blueprint);
	}

	public static void main(String[] args) {
		new Builder();
	}
}
