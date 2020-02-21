
public class ExpOp extends Operator {
	
	public ExpOp() {
		precedence = 10;
	}

	public double evaluate(double a, double b) {
		return Math.pow(a, b);
	}
}