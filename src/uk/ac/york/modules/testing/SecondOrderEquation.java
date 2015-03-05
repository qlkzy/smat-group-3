package uk.ac.york.modules.testing;

import static uk.ac.york.modules.testing.equationast.Node.*;

public class SecondOrderEquation extends Equation {

	public SecondOrderEquation(double a, double b, double c) {
		super(num(a).times(x().exp(num(2))).plus(num(b).times(x())).plus(num(c)));
	}
	
	@Override
	public double of(double x) {
		return eqn.eval(x);
	}
	
	public static String description() {
		return "ax^2+bx+c";
	}
}
