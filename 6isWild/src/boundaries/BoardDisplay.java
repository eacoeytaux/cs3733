package boundaries;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class BoardDisplay extends AbstractDisplay {
	public BoardDisplay() {
		
		JPanel[][] squares = new JPanel[9][9];
		
		setLayout(new GridLayout(1, 0, 0, 0));
		

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		for( int i=0; i< 9; i++){
			for( int j=0; j<9; j++){
				squares[i][j] = new SquareDisplay();
				squares[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				squares[i][j].setBounds(i*62, j*62, 62, 62);
				panel.add(squares[i][j]);
			}
		}
		
		//JPanel panel = new JPanel();
		//add(panel);
		//panel.setLayout(null);
		
	}
	private static final long serialVersionUID = 1L;
	
	SquareDisplay[] squares;

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	} 
}
