package uk.ac.york.modules.testing.equationast;

public abstract class BinOp extends Node {

	protected final Node left;
	protected final Node right;


	public BinOp(Node left, Node right) {		
		this.left = left.isFoldable() ? new Num(left.eval(0)) : left;
		this.right = right.isFoldable() ? new Num(right.eval(0)) : right;
	}

	public String toString() {
		if (left.equals(leftUnit()))
			return right.toString();
		if (right.equals(rightUnit()))
			return left.toString();
		return maybeParenthesized(left) + symbol() + maybeParenthesized(right);
	}
	
	@Override
	public boolean isFoldable() {
		return left.isFoldable() && right.isFoldable();
	}
	
	public String maybeParenthesized(Node node) {
		if (node.precedence().ordinal() < precedence().ordinal()) {
			return "(" + node.toString() + ")";
		}
		return node.toString();
	}
	
	protected abstract Num leftUnit();
	protected abstract Num rightUnit();
	protected abstract String symbol();
}