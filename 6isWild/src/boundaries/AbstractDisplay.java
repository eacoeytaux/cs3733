package boundaries;

import javax.swing.JPanel;

import entities.Model;

public abstract class AbstractDisplay extends JPanel {
	protected static final long serialVersionUID = 1L;
	
	Model model;
	
	public AbstractDisplay(Model model) {
		this.model = model;
	}
	
	public abstract void setup();
}
