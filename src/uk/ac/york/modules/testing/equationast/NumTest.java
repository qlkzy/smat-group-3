package uk.ac.york.modules.testing.equationast;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumTest {

	@Test
	public void identicalValuesShouldHashTogether() {
		Num l0 = new Num(1);
		Num l1 = new Num(1);
		assertEquals(l0.hashCode(), l1.hashCode());
	}

	@Test
	public void shouldEvalToValue() {
		Num l = new Num(16);
		assertEquals(16.0, l.eval(0), 0.0001);
	}

	@Test
	public void xShouldNotAffetEval() {
		Num l0 = new Num(-10);
		Num l1 = new Num(-10);
		assertEquals(l0.eval(-1), l1.eval(1), 0.01);
	}

	@Test
	public void identicalValuesShouldBeEqual() {
		Num l0 = new Num(100);
		Num l1 = new Num(100);
		assertEquals(l0, l1);
	}
	
	@Test
	public void differentValuesShouldBeDifferent() {
		Num l0 = new Num(100);
		Num l1 = new Num(10);
		assertNotEquals(l0, l1);
	}

	@Test
	public void integersShouldFormatAsInteger() {
		assertEquals("15", new Num(15).toString());
	}
	
	@Test
	public void decimalsShouldFormatAsDecimal() {
		assertEquals("15.1", new Num(15.1).toString());
	}
	
}
