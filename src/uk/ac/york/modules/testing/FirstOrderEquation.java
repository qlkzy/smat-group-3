/**
 * 
 */
package uk.ac.york.modules.testing;

import static uk.ac.york.modules.testing.equationast.Node.*;

/**
 * This class represents a first order equation (f(x)=ax+b)
 * 
 * @author Manuel Oriol (manuel@cs.york.ac.uk)
 * @date Feb 14, 2010
 *
 */
public class FirstOrderEquation extends Equation {

	/**
	 * Creates a first-order equation.
	 * 
	 * @param a a in ax+b
	 * @param b b in ax+b
	 */
	public FirstOrderEquation(double a, double b) {
		super(num(a).times(x()).plus(num(b)));
	}
	
	public static String description() {
		return "ax+b";
	}
}
