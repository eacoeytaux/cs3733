package boundaries;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.BuilderSquareController;
import controllers.SquareController;
import entities.Board;
import entities.Model;

public class BoardDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;

	Board board;
	SquareDisplay[][] squares;
	JPanel panel;

	public BoardDisplay(Model model, Board board) {
		super(model);
		this.board = board;

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
				squares[i][j].addMouseListener(new SquareController(squares[i][j]));
				panel.add(squares[i][j]);
			}
		}
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub

	} 
	
	public SquareDisplay getSquareDisplay(int i, int j){
		return squares[i][j];
	}
	
	public void setupSquares(){
		for( int i = 0; i < 9; i++){
			for( int j = 0; j < 9; j++){
				System.out.println("i: "+ i);
				System.out.println("j: "+ j);
				squares[i][j].setup();
			}
		}
	}
	
}
