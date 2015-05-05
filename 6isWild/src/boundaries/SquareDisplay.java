package boundaries;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.CompoundBorder;

import entities.Model;
import entities.Square;

/**
 * Boundary class, displays a Square, which contains a Tile and a border
 * @author Hugh Whelan
 *
 */
public class SquareDisplay extends AbstractDisplay {
	private static final long serialVersionUID = 1L;

	public static final int pixelSize = 62;

	BoardDisplay parent;

	TileDisplay display;
	Square square;

	public SquareDisplay(BoardDisplay parent, Model model, Square square) {
		super(model);
		this.parent = parent;
		this.square = square;


		setup();
	}

	/**
	 * sets up square display
	 */
	@Override
	public void setup() {
		this.removeAll();
		if (square.isInert()) {
			display = new InertDisplay(model);
			this.setBackground(Color.BLACK);
		}
		else if (square.isBucket()) {
			this.setBackground(square.isBucketFull() ? Color.MAGENTA : Color.LIGHT_GRAY);
			display = new BucketDisplay(model, square.isBucketFull());
		} else if (this.display == null) {
			this.setBackground(TileDisplay.getColor(square.getTile().getValue()));
			this.display = new TileDisplay(model, this.square.getTile());
		} else {
			this.setBackground(TileDisplay.getColor(square.getTile().getValue()));
			this.display.setup();
		}
		
		
		
		if(square.isSelected()){
			this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		} else if(square.isEliminated()){
			System.out.println("eliminated");
			this.setBorder(new CompoundBorder( 
					BorderFactory.createLineBorder(Color.WHITE, 1),
					BorderFactory.createLineBorder(Color.BLACK, 4)));
			
			this.display.setup();
		}else{
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(display, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(display, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addGap(12))
				);
		setLayout(groupLayout);
	}

	public Square getSquare(){
		return this.square;
	}
	
	/**
	 * updates the tile display of the tile the square contains
	 */
	public void changeTile(){
		if (square.getTile() != null) display.changeTile(square.getTile());
	}
	
	public BoardDisplay getParentBoardDisplay(){
		return this.parent;
	}
}
