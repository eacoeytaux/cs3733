package entities;

import junit.framework.TestCase;

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
		}

}
