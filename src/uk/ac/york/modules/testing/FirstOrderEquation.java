/**
 * 
 */
package uk.ac.york.modules.testing;

import uk.ac.york.modules.testing.equationast.Node;
import static uk.ac.york.modules.testing.equationast.Node.*;

/**
 * This class represents a first order equation (f(x)=ax+b)
 * 
 * @author Manuel Oriol (manuel@cs.york.ac.uk)
 * @date Feb 14, 2010
 *
 */
public class FirstOrderEquation extends Equation {

	private final Node eqn;
	
	/**
	 * Creates a first-order equation.
	 * 
	 * @param a a in ax+b
	 * @param b b in ax+b
	 */
	public FirstOrderEquation(double a, double b) {
		this.eqn = num(a).times(x()).plus(num(b));
	}
	
	/* (non-Javadoc)
	 * @see uk.ac.york.modules.testing.Equation#toString()
	 */
	@Override
	public String toString() {
		return eqn.toString();
	}

	/* (non-Javadoc)
	 * @see uk.ac.york.modules.testing.Equation#of(double)
	 */
	@Override
	public double of(double x) {
		return eqn.eval(x);
	}

	public static String description() {
		return "ax+b";
	}
}
