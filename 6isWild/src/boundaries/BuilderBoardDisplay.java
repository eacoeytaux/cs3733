package boundaries;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.BuilderSquareController;
import entities.Blueprint;
import entities.Board;
import entities.Square;

public class BuilderBoardDisplay extends JPanel {
	private static final long serialVersionUID = 1L;

	BlueprintDisplay parent;
	Blueprint blueprint;
	//Board board;
	BuilderSquareDisplay[][] squaresDisplay;
	JPanel panel;

	public BuilderBoardDisplay(BlueprintDisplay parent, Blueprint blueprint) {
		this.parent = parent;
		this.blueprint = blueprint;

		squaresDisplay = new BuilderSquareDisplay[9][9];

		setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		add(panel);
		panel.setLayout(null);

		for( int i=0; i< 9; i++){
			for( int j=0; j<9; j++){
				squaresDisplay[i][j] = new BuilderSquareDisplay(this, blueprint.board[i][j]);
				squaresDisplay[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				squaresDisplay[i][j].setBounds(i*62, j*62, 62, 62);
				squaresDisplay[i][j].addMouseListener(new BuilderSquareController(squaresDisplay[i][j]));
				panel.add(squaresDisplay[i][j]);
			}
		}
	}
	
	public Square getNewSquare() {
		return parent.getNewSquare();
	}
	
	public BuilderSquareDisplay getSquareDisplay(int row, int col) {
		return squaresDisplay[row][col];
	}
}
