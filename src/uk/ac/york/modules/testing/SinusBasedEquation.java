package uk.ac.york.modules.testing;

import static uk.ac.york.modules.testing.equationast.Node.*;

/**
 * This class represents a*sin(b*x)^c+d
 * 
 * @author Manuel Oriol (manuel@cs.york.ac.uk)
 * @date Feb 15, 2010
 *
 */
public class SinusBasedEquation extends Equation {
	
	public SinusBasedEquation(double a, double b, double c, double d) {
		super(num(a).times(sin(num(b).times(x())).exp(num(c))).plus(num(d)));
	}
	public static String description() {
		return "a*sin(b*x)^c+d";
	}
}
