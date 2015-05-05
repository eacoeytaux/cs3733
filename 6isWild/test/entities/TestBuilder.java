package entities;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import entities.AbstractBuilderMove;
import entities.Blueprint;
import entities.Builder;
import entities.Model;
import entities.SquareBuilderMove;
import junit.framework.TestCase;
import boundaries.BlueprintDisplay;
import boundaries.BuilderApplication;
import boundaries.BuilderBoardDisplay;
import boundaries.BuilderSquareDisplay;
import boundaries.SquareDisplay;

public class TestBuilder extends TestCase {

		Builder builder;
		

		@Override
		public void setUp(){
			builder = new Builder(true);
		}
		
		@Override
		public void tearDown(){
			builder.closeBuilder();
		}
		
		public void testBuilder(){
			BuilderApplication bapp = builder.getBuilderApplication();
			BlueprintDisplay bd = bapp.getDisplay();	
			BuilderBoardDisplay bbd = bd.getBoardDisplay();
//			Model m = new Model();
						
			assertTrue(builder.getBlueprint() != null);
			
			//Tests if a move can be pushed to the builder
			BuilderSquareDisplay bsq1 = bbd.getSquareDisplay(0, 0);
			BuilderSquareDisplay bsq2 = bbd.getSquareDisplay(1, 0);
			BuilderSquareDisplay bsq3 = bbd.getSquareDisplay(2, 0);
			
			bsq1.getMouseListeners()[0].mouseClicked(new MouseEvent(bsq1.getParent(), MouseEvent.MOUSE_CLICKED,
					System.currentTimeMillis(), 0, 0, 0, 0, false));
			bsq2.getMouseListeners()[0].mouseClicked(new MouseEvent(bsq2.getParent(), MouseEvent.MOUSE_CLICKED,
					System.currentTimeMillis(), 0, 0, 0, 0, false));
			bsq3.getMouseListeners()[0].mouseClicked(new MouseEvent(bsq3.getParent(), MouseEvent.MOUSE_CLICKED,
					System.currentTimeMillis(), 0, 0, 0, 0, false));
			
			Blueprint bp = builder.getBlueprint();
			Blueprint test = loadTestBp();
			assertTrue(bp == test);
			
			builder.setBlueprint(bp);
			//assertEquals(builder.getBlueprint(), bp);
			
			
			//Makes sure the builder can't receive a null blueprint
			builder.setBlueprint(null);
		//	assertEquals(builder.getBlueprint(), bp);
			
			AbstractBuilderMove move = new SquareBuilderMove(bsq1);
			move.doMove();
		//	assertTrue(builder.moveStack.contains(move));
			
		//	assertEquals(builder.popMove(), move);
			
			builder.pushRedo(move);
		//	assertTrue(builder.redoStack.contains(move));
//			assertTrue(builder.setRedoEnabled;)
		//	assertEquals(builder.popRedo(), move);			
						
		}
		
		public Blueprint loadTestBp(){
			try{
			String fileLoc = "levels/testLevel.txt";
			fileLoc = new File("").getAbsolutePath() + "/bin/" + fileLoc;
			FileInputStream fis = new FileInputStream(fileLoc);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Blueprint blueprint = (Blueprint)ois.readObject();
			fis.close();
			return blueprint;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
			}
}
