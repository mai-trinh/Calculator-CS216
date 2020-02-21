

public class AddOp extends Operator {
	
	public AddOp() {
		precedence = 5; 
	}
	
	public double evaluate(double a, double b) {
		return a+b;
	}
	
}
