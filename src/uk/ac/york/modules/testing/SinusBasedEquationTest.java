package uk.ac.york.modules.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SinusBasedEquationTest {

	private SinusBasedEquation eq;
	
	@Before
	public void setUp() throws Exception {
		eq = new SinusBasedEquation(1, 2, 3, 4);
	}

	@Test
	public void shouldFormatCorrectly() {
		assertEquals("1.0(sin(2.0x)^3.0)+4.0", eq.toString());
	}
	
	@Test
	public void shouldWorkAtOrigin() {
		assertEquals(4, eq.of(0), 0.01);
	}
	
	/**
	 * Press "Cancel" --- Invalid double stacktrace
	 */
	
	/**
	 * Enter "c = -1" --- Graph is mangled
	 */
	
	/**
	 * Enter "NaN" for all the numbers --- doesn't complain, just produces an empty graph 
	 */
	
	/**
	 * Enter "Blah" for a number --- doesn't validate, throws exception
	 */
	
	/**
	 * 
	 */
}
