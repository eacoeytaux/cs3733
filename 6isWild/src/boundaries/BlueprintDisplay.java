package boundaries;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import entities.Blueprint;
import entities.Board;
import entities.Game;
import entities.Square;
import entities.Tile;

public class BlueprintDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Blueprint blueprint;
	
	JTextField movesTextField;
	JTextField firstStarTextField;
	JTextField secondStarTextField;
	JTextField thirdStarTextField;
	JTextField shuffleTextField;
	JTextField swapTextField;
	JTextField removeTextField;
	JComboBox levelModeComboBox;
	JComboBox tileTypeComboBox;
	BuilderBoardDisplay panel;
	
	JSlider slider_1;
	JSlider slider_2;
	JSlider slider_3;
	JSlider slider_4;
	JSlider slider_5;
	JSlider slider_6;

	JSlider slider_x1;
	JSlider slider_x2;
	JSlider slider_x3;
	
	public BlueprintDisplay(Blueprint blueprint) {
		this.blueprint = blueprint;
		
		movesTextField = new JTextField();
		firstStarTextField = new JTextField();
		secondStarTextField = new JTextField();
		thirdStarTextField = new JTextField();
		shuffleTextField = new JTextField();
		swapTextField = new JTextField();
		removeTextField = new JTextField();
		panel = new BuilderBoardDisplay(this, new Board(null));
		
		slider_1 = new JSlider();
		slider_2 = new JSlider();
		slider_3 = new JSlider();
		slider_4 = new JSlider();
		slider_5 = new JSlider();
		slider_6 = new JSlider();

		slider_x1 = new JSlider();
		slider_x2 = new JSlider();
		slider_x3 = new JSlider();
		
		setup();
	}
	
	public void setup() {
		
		JLabel lblLevelModeSelect = new JLabel("Level Mode:");
		
		levelModeComboBox = new JComboBox();
		levelModeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Elimination", "Release"}));
		
		JLabel lblTileType = new JLabel("Tile Type:");
		
		tileTypeComboBox = new JComboBox();
		tileTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Inert", "Bucket", "1", "2", "3", "4", "5", "6", "Random Value"}));
		
		JLabel lblNewLabel = new JLabel("Moves:");
		
		movesTextField.setText("25");
		movesTextField.setColumns(10);
		
		JLabel lblFirstStar = new JLabel("First Star:");
		
		firstStarTextField.setText("100");
		firstStarTextField.setColumns(10);
		
		JLabel lblSecondStar = new JLabel("Second Star:");
		
		secondStarTextField.setText("200");
		secondStarTextField.setColumns(10);
		
		JLabel lblThirdStar = new JLabel("Third Star:");
		
		thirdStarTextField.setText("300");
		thirdStarTextField.setColumns(10);
		
		JLabel lblShufflePowerups = new JLabel("Shuffle Powerups:");
		
		shuffleTextField.setText("5");
		shuffleTextField.setColumns(10);
		
		JLabel lblSwapPowerups = new JLabel("Swap Powerups:");
		
		swapTextField.setText("5");
		swapTextField.setColumns(10);
		
		JLabel lblRemovePowerups = new JLabel("Remove Powerups:");
		
		removeTextField.setText("5");
		removeTextField.setColumns(10);
		
		JLabel lblTileValueFrequencies = new JLabel("Tile Value Frequencies:");
		
		JLabel lblNewLabel_1 = new JLabel("1:");
		
		JLabel lblNewLabel_2 = new JLabel("2:");
		
		JLabel lblNewLabel_3 = new JLabel("3:");
		
		JLabel lblNewLabel_4 = new JLabel("4:");
		
		JLabel lblNewLabel_5 = new JLabel("5:");
		
		JLabel lblNewLabel_6 = new JLabel("6:");
		
		JLabel lblTileMultiplierFrequencies = new JLabel("Tile Multiplier Frequencies:");
		
		JLabel lblX1 = new JLabel("x1:");
		
		JLabel lblX2 = new JLabel("x2:");
		
		JLabel lblX3 = new JLabel("x3:");
		
		
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(slider_3, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(slider_4, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(slider_5, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblX2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(slider_x2, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblX3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(slider_x3, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblRemovePowerups)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(removeTextField, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblSwapPowerups)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(swapTextField, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblShufflePowerups)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(shuffleTextField, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblThirdStar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(thirdStarTextField))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblSecondStar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(secondStarTextField, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblFirstStar)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(firstStarTextField))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(movesTextField))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTileType)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tileTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblLevelModeSelect)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(levelModeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblX1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(slider_x1, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(slider_6, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addGap(17)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(slider_1, 0, 0, Short.MAX_VALUE)
									.addComponent(slider_2, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))))
						.addComponent(lblTileValueFrequencies)
						.addComponent(lblTileMultiplierFrequencies))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLevelModeSelect)
								.addComponent(levelModeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTileType)
								.addComponent(tileTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(movesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(firstStarTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFirstStar))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSecondStar)
								.addComponent(secondStarTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(thirdStarTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblThirdStar))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblShufflePowerups)
								.addComponent(shuffleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSwapPowerups)
								.addComponent(swapTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRemovePowerups)
								.addComponent(removeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTileValueFrequencies)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(slider_1, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(slider_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3)
								.addComponent(slider_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4)
								.addComponent(slider_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_5)
								.addComponent(slider_5, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6)
								.addComponent(slider_6, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTileMultiplierFrequencies)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblX1)
								.addComponent(slider_x1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblX2)
								.addComponent(slider_x2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblX3)
								.addComponent(slider_x3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))))
					.addGap(31))
		);
		setLayout(groupLayout);
	}
	
	public Square getNewSquare() {
		int type = tileTypeComboBox.getSelectedIndex();
		switch (type) {
			case 0:
				return new Square(null, true, false);
			case 1:
				return new Square(null, false, true);
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				return new Square(new Tile(type - 1, 0), false, false);
			case 8:
			default:
				return new Square(new Tile(0, 0), false, false);
					
		}
				
	}
	
	public void save() {
		int levelType;
		switch (levelModeComboBox.getSelectedIndex()) {
		default:
		case 0:
			levelType = Game.PUZZLE_ID;
			break;
		case 1:
			levelType = Game.LIGHTNING_ID;
			break;
		case 2:
			levelType = Game.ELIMINATION_ID;
			break;
		case 3:
			levelType = Game.RELEASE_ID;
			break;
		}
		int shuffle = Integer.parseInt(shuffleTextField.getText());
		int swap = Integer.parseInt(swapTextField.getText());
		int remove = Integer.parseInt(removeTextField.getText());
		int movesTotal = Integer.parseInt(movesTextField.getText());
		int[] starRequirements = {Integer.parseInt(firstStarTextField.getText()), Integer.parseInt(secondStarTextField.getText()), Integer.parseInt(thirdStarTextField.getText())};
		int[] valueFrequencies = {slider_1.getValue(), slider_2.getValue(), slider_3.getValue(), slider_4.getValue(), slider_5.getValue(), slider_6.getValue()};
		int[] multiplierFrequencies = {slider_x1.getValue(), slider_x2.getValue(), slider_x3.getValue()};
		blueprint.setValues(levelType, shuffle, swap, remove, movesTotal, starRequirements, valueFrequencies, multiplierFrequencies);
	}
}
