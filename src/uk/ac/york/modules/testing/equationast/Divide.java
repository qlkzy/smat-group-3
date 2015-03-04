package uk.ac.york.modules.testing.equationast;

public class Divide extends BinOp {

	private static final Num rightUnit = new Num(1);
	
	public Divide(Node left, Node right) {
		super(left, right);
	}

	@Override
	protected Num leftUnit() {
		return null;
	}

	@Override
	protected Num rightUnit() {
		return rightUnit;
	}
	
	@Override
	protected String symbol() {
		return "/";
	}

	@Override
	public double eval(double x) {
		return left.eval(x) / right.eval(x);
	}

	@Override
	public PrecedenceLevel precedence() {
		return PrecedenceLevel.MULTIPLICATION;
	}
}
