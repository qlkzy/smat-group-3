package uk.ac.york.modules.testing.equationast;

import java.text.DecimalFormat;

public class Num extends Node {

	private final double value;
	private static final DecimalFormat format = new DecimalFormat();
	
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
	public boolean isFoldable() {
		return true;
	}
	
	@Override
	public String toString() {
		return format.format(value);
	}
	
	@Override
	public boolean isNegative() {
		return value < 0;
	}
	
	@Override
	public boolean isLiteral() {
		return true;
	}

	@Override
	public PrecedenceLevel precedence() {
		return PrecedenceLevel.ATOMIC;
	}
}
