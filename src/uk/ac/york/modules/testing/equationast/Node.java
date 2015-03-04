package uk.ac.york.modules.testing.equationast;

public abstract class Node {

	public abstract PrecedenceLevel precedence();
	public abstract double eval(double x);
	
	public boolean isNegative() {
		return false;
	}
	
	public boolean isLiteral() {
		return false;
	}

	public boolean isFoldable() {
		return false;
	}
	
	public Node times(Node other) {
		return new Times(this, other);
	}
	
	public Node dividedBy(Node other) {
		return new Divide(this, other);
	}
	
	public Node plus(Node other) {
		return new Plus(this, other);
	}
	
	public Node exp(Node other) {
		return new Exp(this, other);
	}
	
	public static Node sin(Node node) {
		return new Sin(node);
	}
	
	public static Node x() {
		return new X();
	}
	
	public static Node num(double value) {
		return new Num(value);
	}
}
