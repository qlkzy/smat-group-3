package uk.ac.york.modules.testing.input;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleValidatorTest {
	
	@Test
	public void shouldAcceptOnePointOh() {
		assertTrue(DoubleValidator.isValid("1.0"));
	}
	
	@Test
	public void shouldRejectBlah() {
		assertFalse(DoubleValidator.isValid("blah"));
	}

	@Test
	public void shouldRejectPositiveInfinity() {
		assertFalse(DoubleValidator.isValid("Infinity"));
	}
	
	@Test
	public void shouldRejectNegativeInfinity() {
		assertFalse(DoubleValidator.isValid("-Infinity"));
	}
	
	@Test
	public void shouldRejectNaN() {
		assertFalse(DoubleValidator.isValid("NaN"));
	}
}
