package uk.ac.york.modules.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FirstOrderEquationTest {
	
	/**
	 * Test method for {@link uk.ac.york.modules.testing.FirstOrderEquation#toString()}.
	 */
	@Test
	public final void testToString() {
		Equation foEquation = new FirstOrderEquation(3, 4);
		assertEquals("3x+4", foEquation.toString());
	}
	
	/**
	 * Test method for {@link uk.ac.york.modules.testing.FirstOrderEquation#toString()}.
	 * Tests whether the string is formatted correctly for negative constants
	 */
	@Test
	public final void testToStringNegative() {
		Equation foEquation = new FirstOrderEquation(5, -5);
		assertEquals("5x-5", foEquation.toString());
	}
	
	/**
	 * Test method for {@link uk.ac.york.modules.testing.FirstOrderEquation#toString()}.
	 * Tests whether the string is formatted correctly for coefficients of 1
	 */
	@Test
	public final void testToStringOneCoefficient() {
		Equation foEquation = new FirstOrderEquation(1, 7);
		assertEquals("x+7", foEquation.toString());
	}
	
	/**
	 * Test method for {@link uk.ac.york.modules.testing.FirstOrderEquation#of(double)}.
	 */
	@Test
	public final void testOf() {
		Equation foEquation = new FirstOrderEquation(5.5, 15);
		assertEquals(70, foEquation.of(10), 0);
	}
}
