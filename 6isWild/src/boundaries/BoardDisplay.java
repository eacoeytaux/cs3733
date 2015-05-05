package boundaries;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.SquareController;
import entities.Board;
import entities.Model;

/**
 * displays the game board, which contains a Board and an array of Squares
 * @author Hugh Whelan
 *
 */
public class BoardDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;

	Board board;
	SquareDisplay[][] squares;
	JPanel panel;
	Model model;
	LevelDisplay parentLevelDisplay;
	

	public BoardDisplay(Model model, Board board, LevelDisplay parentLevelDisplay) {
		super(model);
		this.model = model;
		this.board = board;
		this.parentLevelDisplay = parentLevelDisplay;

		squares = new SquareDisplay[9][9];

		setLayout(new GridLayout(1, 0, 0, 0));


		panel = new JPanel();
		add(panel);
		panel.setLayout(null);

		for( int i=0; i< 9; i++){
			for( int j=0; j<9; j++){
				squares[i][j] = new SquareDisplay(this, model, board.getSquare(i, j));
				squares[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				squares[i][j].setBounds(i*62, j*62, 62, 62);
				squares[i][j].addMouseListener(new SquareController(squares[i][j], model));
				panel.add(squares[i][j]);
			}
		}
	}

	/**
	 * sets up the board display
	 */
	@Override
	public void setup() {
		for (SquareDisplay[] squares : squares) {
			for (SquareDisplay square : squares) {
				square.setup();
			}
		}

	} 
	
	public SquareDisplay getSquareDisplay(int i, int j){
		return squares[i][j];
	}
	
	/**
	 * refreshes the tile display of given index
	 * @param i index
	 * @param j index
	 */
	public void updateTile(int i, int j){
		squares[i][j].changeTile();
		squares[i][j].setup();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public LevelDisplay getParentLevelDisplay(){
		return this.parentLevelDisplay;
	}
	

}
