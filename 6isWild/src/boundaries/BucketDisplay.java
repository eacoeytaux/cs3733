package boundaries;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import entities.Model;

public class BucketDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;

	public BucketDisplay(Model model) {
		super(model);

		setup();
	}

	@Override
	public void setup() {

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