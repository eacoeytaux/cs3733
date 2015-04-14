package boundaries;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;

public class BlueprintDisplay extends JFrame implements IDisplay {
	private JTextField movesTimeTextField;
	private JTextField starScore1TextField;
	private JTextField starScore2TextField;
	private JTextField starScore3TextField;
	public BlueprintDisplay() {
		setTitle("Sixes Wild Level Builder");
		setResizable(false);
		
		JComboBox tileTypeComboBox = new JComboBox();
		tileTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Inert", "1", "2", "3", "4", "5", "6", "Bucket"}));
		
		JComboBox levelTypeComboBox = new JComboBox();
		levelTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Puzzle", "Lightning", "Elimination", "Release"}));
		
		JLabel levelTypeLabel = new JLabel("Select Level Type:");
		
		JLabel tileTypeLabel = new JLabel("Select Tile Type:");
		
		JLabel movesTimeLabel = new JLabel("Moves:");
		
		movesTimeTextField = new JTextField();
		movesTimeTextField.setColumns(10);
		
		JLabel lblStarScores = new JLabel("Star Scores:");
		
		starScore1TextField = new JTextField();
		starScore1TextField.setColumns(10);
		
		starScore2TextField = new JTextField();
		starScore2TextField.setColumns(10);
		
		starScore3TextField = new JTextField();
		starScore3TextField.setColumns(10);
		
		JSlider slider_1 = new JSlider();
		
		JLabel valueFrequencyLabel = new JLabel("Tile Value Frequencies");
		
		JLabel label_1 = new JLabel("1:");
		
		JLabel label_2 = new JLabel("2:");
		
		JLabel label_3 = new JLabel("3:");
		
		JLabel label_4 = new JLabel("4:");
		
		JLabel label_5 = new JLabel("5:");
		
		JLabel label_6 = new JLabel("6:");
		
		JSlider slider = new JSlider();
		
		JSlider slider_2 = new JSlider();
		
		JSlider slider_3 = new JSlider();
		
		JSlider slider_4 = new JSlider();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(levelTypeLabel)
							.addContainerGap(553, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblStarScores)
							.addContainerGap(591, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(starScore1TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(530, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(starScore2TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(530, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(starScore3TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(530, Short.MAX_VALUE))
						.addComponent(movesTimeLabel)
						.addComponent(movesTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(valueFrequencyLabel)
							.addContainerGap(524, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_1))
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(slider_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(456, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(622, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(levelTypeComboBox, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(tileTypeLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addComponent(tileTypeComboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStarScores)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(starScore1TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(starScore2TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(starScore3TextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(valueFrequencyLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(slider_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(slider_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(slider_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_6)
							.addGap(42))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4)
							.addContainerGap())))
		);
		getContentPane().setLayout(groupLayout);
	}
}
