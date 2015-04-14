package boundaries;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BlueprintDisplay extends JFrame implements IDisplay {
	private JTextField movesTimeTextField;
	public BlueprintDisplay() {
		
		JComboBox tileTypeComboBox = new JComboBox();
		
		JComboBox levelTypeComboBox = new JComboBox();
		
		JLabel levelTypeLabel = new JLabel("Select Level Type:");
		
		JLabel tileTypeLabel = new JLabel("Select Tile Type:");
		
		JLabel movesTimeLabel = new JLabel("Moves:");
		
		movesTimeTextField = new JTextField();
		movesTimeTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(levelTypeLabel)
							.addContainerGap(333, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(levelTypeComboBox, 0, 111, Short.MAX_VALUE)
							.addGap(333))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(tileTypeComboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tileTypeLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(movesTimeLabel)
							.addContainerGap(383, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(movesTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(310, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(levelTypeLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(levelTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tileTypeLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tileTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(movesTimeLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(movesTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
