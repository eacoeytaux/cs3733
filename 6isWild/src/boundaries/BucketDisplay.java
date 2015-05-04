package boundaries;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import entities.Model;

/**
 * Display of a bucket
 * @author Ethan Coeytaux
 *
 */
public class BucketDisplay extends TileDisplay {
	private static final long serialVersionUID = 1L;
	
	boolean full;

	public BucketDisplay(Model model, boolean full) {
		super(model, null);
		
		this.full = full;

		setup();
	}

	/**
	 * sets up display of Bucket
	 */
	@Override
	public void setup() {
		setBackground(full ? Color.MAGENTA : Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("B");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(22)
						.addComponent(lblNewLabel)
						.addContainerGap(413, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(14)
						.addComponent(lblNewLabel)
						.addContainerGap(256, Short.MAX_VALUE))
				);
		setLayout(groupLayout);

	}
}
