package uk.ac.york.modules.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestFirstOrderEquation {
	
	/**
	 * Test method for {@link uk.ac.york.modules.testing.FirstOrderEquation#toString()}.
	 */
	@Test
	public final void testToString() {
		FirstOrderEquation foEquation = new FirstOrderEquation(3, 4);
		assertEquals(foEquation.toString(), "3.0x+4.0");
	}
	
	/**
	 * Test method for {@link uk.ac.york.modules.testing.FirstOrderEquation#of(double)}.
	 */
	@Test
	public final void testOf() {
		FirstOrderEquation foEquation = new FirstOrderEquation(5.5, 15);
		assertEquals(foEquation.of(10) ,70, 0);
	}
}
