
public class MulOp extends Operator {
	
	public MulOp() {
		precedence = 8;
	}

	public double evaluate(double a, double b) {
		return a * b;
	}
}