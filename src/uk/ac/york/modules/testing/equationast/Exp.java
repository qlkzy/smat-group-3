package uk.ac.york.modules.testing.equationast;

public class Exp extends BinOp {

	private final static Num unit = new Num(1);

	public Exp(Node left, Node right) {
		super(left, right);
	}
	
	@Override
	protected Num leftUnit() {
		return null;
	}

	@Override
	protected Num rightUnit() {
		return unit;
	}

	@Override
	protected String symbol() {
		return "^";
	}

	@Override
	public double eval(double x) {
		return Math.pow(left.eval(x), right.eval(x));
	}
	@Override
	public PrecedenceLevel precedence() {
		return PrecedenceLevel.ATOMIC;
	}
}
