
public class MinusOp extends Operator {
	
	public MinusOp() {
		precedence = 5;
	}
	
	public double evaluate(double a, double b) {
		return a-b;
	}

	
}