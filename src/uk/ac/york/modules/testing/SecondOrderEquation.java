package uk.ac.york.modules.testing;

import uk.ac.york.modules.testing.equationast.Node;
import static uk.ac.york.modules.testing.equationast.Node.*;

public class SecondOrderEquation extends Equation {

	private final Node eqn;
	
	public SecondOrderEquation(double a, double b, double c) {
		this.eqn = num(a).times(x().exp(num(2))).plus(num(b).times(x())).plus(num(c));
	}
	
	@Override
	public String toString() {
		return eqn.toString();
	}
	
	@Override
	public double of(double x) {
		return eqn.eval(x);
	}
	
	public static String description() {
		return "ax^2+bx+c";
	}

}
