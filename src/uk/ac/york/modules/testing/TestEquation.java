package uk.ac.york.modules.testing;

import org.junit.Test;

public class TestEquation{

	@Test
	public final void testMain() {
		String []arguments = {"Help"};
		EquationsView.main(arguments);
	}

	@Test(expected=IllegalArgumentException.class)
	public final void testMainWithTwoArguments() {
		String []arguments = {"Help", "AnotherArgument"};
		EquationsView.main(arguments);
	}
}
