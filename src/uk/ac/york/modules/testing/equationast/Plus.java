package uk.ac.york.modules.testing.equationast;

public class Plus extends BinOp {

	private static final Num unit = new Num(0);

	public Plus(Node left, Node right) {
		super(left, right);
	}

	@Override
	public double eval(double x) {
		return left.eval(x) + right.eval(x);
	}
	
	@Override
	protected Num leftUnit() {
		return unit;
	}
	
	@Override
	protected Num rightUnit() {
		return unit;
	}
	
	@Override
	protected String symbol() {
		return right.isNegative() ? "" : "+";
	}

	@Override
	public PrecedenceLevel precedence() {
		return PrecedenceLevel.ADDITION;
	}
}
