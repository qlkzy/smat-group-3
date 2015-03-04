/**
 * 
 */
package uk.ac.york.modules.testing;

import uk.ac.york.modules.testing.equationast.Node;
import static uk.ac.york.modules.testing.equationast.Node.*;

/**
 * This class represents an equation of the type f(x) = a/(x+b).
 * 
 * @author Manuel Oriol (manuel@cs.york.ac.uk)
 * @date Feb 14, 2010
 *
 */
public class FractionEquation extends Equation {

	private final Node eqn;
	
	/**
	 * a in a/(x+b).
	 */
	double a;
	
	/**
	 * b in a/(x+b).
	 */
	double b;
	/**
	 * 
	 */
	public FractionEquation(double a, double b) {
		this.eqn = num(a).dividedBy(x().plus(num(b)));
	}
	@Override
	public double of(double x) {
		return eqn.eval(x);
	}
	@Override
	public String toString() {
		return eqn.toString();
	}

}
