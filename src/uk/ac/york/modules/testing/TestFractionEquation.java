package uk.ac.york.modules.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFractionEquation {
	private FractionEquation fraction;

	@Before
	public void setUp(){
		fraction=new FractionEquation(6,1);
	}
	@Test
	public void testFractionCreate() {
		assertNotEquals(null,fraction);
	}
	
	@Test
	public void testFractionOf(){
		assertEquals("3.0",Double.toString(fraction.of(1)));
	}
	
	@Test
	public void testFractionToString(){
		assertEquals("6.0/(x+1.0)",fraction.toString());
	}

}
