/**
 * 
 */
package uk.ac.york.modules.testing;

import uk.ac.york.modules.testing.equationast.Node;
import static uk.ac.york.modules.testing.equationast.Node.*;

/**
 * This class represents a*sin(b*x)^c+d
 * 
 * @author Manuel Oriol (manuel@cs.york.ac.uk)
 * @date Feb 15, 2010
 *
 */
public class SinusBasedEquation extends Equation {
	
	private final Node eqn;
	
	/**
	 * Constructor for sinus-based equations.
	 */
	public SinusBasedEquation(double a, double b, double c, double d) {
		this.eqn = num(a).times(sin(num(b).times(x())).exp(num(c))).plus(num(d));
	}
	@Override
	public double of(double x) {
		return eqn.eval(x);
	}
	@Override
	public String toString() {
		return eqn.toString();
	}

	public static String description() {
		return "a*sin(b*x)^c+d";
	}
}
