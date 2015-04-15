package entities;

import javax.swing.JFrame;

import boundaries.BuilderApplication;

public class Builder extends JFrame {
	
	public Builder() {
		BuilderApplication builderApplication = new BuilderApplication();
	}

	public static void main(String[] args) {
		Builder builder = new Builder();
	}
}
