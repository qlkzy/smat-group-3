package uk.ac.york.modules.testing.input;

import static org.junit.Assert.*;

import org.junit.Test;

public class VariableHighlighterTest {

	@Test
	public void shouldHighlightA() {
		String result = new VariableHighlighter("ax^2+bx+c").highlight("b");
		assertEquals("<html>ax^2+<font color=green>b</font>x+c</html>", result);
	}

	@Test
	public void shouldHighlightAtStart() {
		String result = new VariableHighlighter("ax+b").highlight("a");
		assertEquals("<html><font color=green>a</font>x+b</html>", result);
	}
	
}
