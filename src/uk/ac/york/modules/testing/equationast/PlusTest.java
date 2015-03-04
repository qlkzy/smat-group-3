package uk.ac.york.modules.testing.equationast;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlusTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldEvalToSum() {
		assertEquals(2, new Plus(new Num(1), new Num(1)).eval(0), 0.0001);
	}

	@Test
	public void shouldFormatLiteralPair() {
		assertEquals("1+2", new Plus(new Num(1), new Num(2)).toString());		
	}
	
	@Test
	public void shouldDropLeftUnit() {
		assertEquals("2", new Plus(new Num(0), new Num(2)).toString());
	}
	
	@Test
	public void shouldDropRightUnit() {
		assertEquals("1", new Plus(new Num(1), new Num(0)).toString());
	}
		
}
