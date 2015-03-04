package uk.ac.york.modules.testing.equationast;

public class X extends Node {

	@Override
	public double eval(double x) {
		return x;
	}
	
	@Override
	public String toString() {
		return "x";
	}

	@Override
	public PrecedenceLevel precedence() {
		return PrecedenceLevel.ATOMIC;
	}
}
