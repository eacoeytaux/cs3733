package boundaries;

import javax.swing.JPanel;

import entities.Model;

/**
 * The abstract class for all displays. all display have a parent model
 * @author Ethan Coeytaux
 *
 */
public abstract class AbstractDisplay extends JPanel {
	protected static final long serialVersionUID = 1L;
	
	Model model;
	
	public AbstractDisplay(Model model) {
		this.model = model;
	}
	
	public abstract void setup();
}
