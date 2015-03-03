package uk.ac.york.modules.testing.equationast;

public class Times extends BinOp {

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
		return "";
	}

	@Override
	public double eval(double x) {
		return left.eval(x) * right.eval(x);
	}

}
