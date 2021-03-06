package uk.ac.york.modules.testing.equationast;

public class Times extends BinOp {

	private static final Num nullValue = new Num(0);
	private static final Num unit = new Num(1);
	
	public Times(Node left, Node right) {
		super(left, right);
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
		return left.isLiteral() && right.isLiteral() ? "*" : "";
	}

	@Override
	public double eval(double x) {
		return left.eval(x) * right.eval(x);
	}

	@Override
	public PrecedenceLevel precedence() {
		return PrecedenceLevel.MULTIPLICATION;
	}
	
	@Override
	public Num leftNull() {
		return nullValue;
	}
}
