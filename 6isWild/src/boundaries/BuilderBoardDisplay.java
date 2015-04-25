package boundaries;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.BuilderSquareController;
import entities.Board;
import entities.Model;
import entities.Square;
import entities.Tile;

public class BuilderBoardDisplay extends JPanel {
	private static final long serialVersionUID = 1L;

	BlueprintDisplay parent;
	Board board;
	BuilderSquareDisplay[][] squares;
	JPanel panel;

	public BuilderBoardDisplay(BlueprintDisplay parent, Board board) {
		this.parent = parent;
		this.board = board;

		squares = new BuilderSquareDisplay[9][9];

		setLayout(new GridLayout(1, 0, 0, 0));


		panel = new JPanel();
		add(panel);
		panel.setLayout(null);

		for( int i=0; i< 9; i++){
			for( int j=0; j<9; j++){
				squares[i][j] = new BuilderSquareDisplay(this, board.getSquare(i, j));
				squares[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				squares[i][j].setBounds(i*62, j*62, 62, 62);
				squares[i][j].addMouseListener(new BuilderSquareController(squares[i][j]));
				panel.add(squares[i][j]);
			}
		}
	}
	
	public Square getNewSquare() {
		return parent.getNewSquare();
	}
}
