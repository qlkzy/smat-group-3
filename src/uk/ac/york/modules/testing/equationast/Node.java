package uk.ac.york.modules.testing.equationast;

public abstract class Node {

	public abstract boolean isTerminal();
	public abstract double eval(double x);
	public boolean isNegative() {
		return false;
	}
}
