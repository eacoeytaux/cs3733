package entities;

import boundaries.BuilderApplication;

public class Builder {
	
	public Builder() {
		Model model = new Model();
		BuilderApplication builderApplication = new BuilderApplication(model);
	}

	public static void main(String[] args) {
		new Builder();
	}
}
