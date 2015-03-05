package uk.ac.york.modules.testing;

import static uk.ac.york.modules.testing.equationast.Node.*;

/**
 * This class represents an equation of the type f(x) = a/(x+b).
 * 
 * @author Manuel Oriol (manuel@cs.york.ac.uk)
 * @date Feb 14, 2010
 *
 */
public class FractionEquation extends Equation {

	public FractionEquation(double a, double b) {
		super(num(a).dividedBy(x().plus(num(b))));
	}
	@Override
	public double of(double x) {
		return eqn.eval(x);
	}
	public static String description() {
		return "a/(x+b)";
	}
}
