package uk.ac.york.modules.testing.equationast;

public class Num extends Node {

	private final double value;
	
	public Num(double value) {
		this.value = value;
	}
	
	@Override
	public double eval(double x) {
		return value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		if (o.getClass() != getClass()) return false;
		Num l = (Num)o;
		return l.value == this.value;
	}

	@Override
	public int hashCode() {
		return (int)value;
	}

	@Override
	public boolean isTerminal() {
		return true;
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}
	
	@Override
	public boolean isNegative() {
		return value < 0;
	}
}
