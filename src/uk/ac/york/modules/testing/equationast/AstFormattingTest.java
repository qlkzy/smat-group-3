package uk.ac.york.modules.testing.equationast;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static uk.ac.york.modules.testing.equationast.Node.*;

public class AstFormattingTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shouldFormatLinear() {
		Node eqn = num(2).times(x()).plus(num(1));
		assertEquals("2x+1", eqn.toString());
	}
	
	@Test
	public void shouldFormatProductOfTwoLiterals() {
		Node eqn = num(2).times(num(2));
		assertEquals("2*2", eqn.toString());
	}
	
	@Test
	public void shouldRespectPrecedenceOfPlusAndTimes() {
		Node eqn = num(2).times(num(1).plus(x()));
		assertEquals("2(1+x)", eqn.toString());
	}
	
	@Test
	public void shouldRespectPrecedenceOfTimesAndExp() {
		Node eqn = num(2).exp(num(3).times(x()));
		assertEquals("2^(3x)", eqn.toString());
	}
	
	@Test
	public void shouldRespectFolding() {
		Node eqn = num(2).times(num(1).plus(num(0)));
		assertEquals("2", eqn.toString());
	}
	
	@Test
	public void sinIsNeverFolded() {
		Node eqn = num(2).times(sin(num(3)));
		assertEquals("2sin(3)", eqn.toString());
	}
}
