package uk.ac.york.modules.testing.equationast;

public abstract class BinOp extends Node {

	protected final Node left;
	protected final Node right;


	public BinOp(Node left, Node right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		if (left.equals(leftUnit()))
			return right.toString();
		if (right.equals(rightUnit()))
			return left.toString();
		return left.toString() + symbol() + right.toString();
	}
	
	@Override
	public boolean isTerminal() {
		return left.equals(leftUnit()) || right.equals(rightUnit());
	}
	
	protected abstract Num leftUnit();
	protected abstract Num rightUnit();
	protected abstract String symbol();
}