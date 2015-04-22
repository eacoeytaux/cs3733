package entities;

import boundaries.Application;
import boundaries.BuilderApplication;

public class Builder {
	
	Model model;
	BuilderApplication builderApplication;
	
	public Builder() {
		model = new Model();
		builderApplication = new BuilderApplication(model);
	}

	public static void main(String[] args) {
		new Builder();
	}
	
	public void closeBuilder() {
		builderApplication.dispose();
	}
}
