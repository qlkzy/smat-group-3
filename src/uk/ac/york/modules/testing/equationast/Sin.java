package uk.ac.york.modules.testing.equationast;

public class Sin extends Node {

	private final Node arg;
	
	public Sin(Node arg) {
		this.arg = arg;
	}

	@Override
	public PrecedenceLevel precedence() {
		return PrecedenceLevel.ATOMIC;
	}
	
	@Override
	public double eval(double x) {
		return Math.sin(arg.eval(x));
	}
	
	@Override
	public String toString() {
		return "sin(" + arg.toString() + ")";
	}
}
