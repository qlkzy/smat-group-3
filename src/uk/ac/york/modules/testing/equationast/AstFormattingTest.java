package uk.ac.york.modules.testing.equationast;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AstFormattingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldFormatLinear() {
		Node eqn = new Plus(new Times(new Num(2), new X()), new Num(1));
		assertEquals("2x+1", eqn.toString());
	}	
}
