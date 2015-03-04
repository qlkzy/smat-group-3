package uk.ac.york.modules.testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class SeriesTest {

	@Test
	public void testHandlesOccasionalNaN() {
		Equation e = new FractionEquation(1, -1);
		Series s = new Series(e, 0, 10, 0.01);
		assertTrue(s.maxY < Double.POSITIVE_INFINITY);
		assertEquals(-100, s.minY, 0.1);
	}
}
