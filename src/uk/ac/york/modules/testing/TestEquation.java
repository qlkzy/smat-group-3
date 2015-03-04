/**
 * 
 */
package uk.ac.york.modules.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This class provides some tests for the Equations program.
 * 
 * @author Rob Alexander (rob.alexander@york.ac.uk)
 * @date Feb 26, 2013
 *
 */
public class TestEquation{

	/**
	 * Test method for {@link uk.ac.york.modules.testing.EquationsView#main(java.lang.String[])}.
	 */
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
	
	/**
	 * Test method for {@link uk.ac.york.modules.testing.EquationsView#increment(int)}.
	 */
	@Test
	public final void testIncrement() {
		assertEquals(1, EquationsView.increment(0));
	}

	/**
	 * Test method for {@link uk.ac.york.modules.testing.EquationsView#increment(int)}.
	 */
	@Test
	public final void testIncrement2() {
		assertTrue(EquationsView.increment(Integer.MAX_VALUE)<0);
	}
	
	
	

}
