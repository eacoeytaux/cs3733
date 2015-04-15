package boundaries;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import entities.Model;

public class BoardDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;
	
	SquareDisplay[] squares;
	
	public BoardDisplay(Model model) {
		super(model);
		
		JPanel[][] squares = new JPanel[9][9];
		
		setLayout(new GridLayout(1, 0, 0, 0));
		

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		for( int i=0; i< 9; i++){
			for( int j=0; j<9; j++){
				squares[i][j] = new SquareDisplay(model);
				squares[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				squares[i][j].setBounds(i*62, j*62, 62, 62);
				panel.add(squares[i][j]);
			}
		}
		
		//JPanel panel = new JPanel();
		//add(panel);
		//panel.setLayout(null);
		
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	} 
}
