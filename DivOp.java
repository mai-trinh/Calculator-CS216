
public class DivOp extends Operator {

	public DivOp() {
		precedence = 8; 
	}
	// super(8);
	
	public double evaluate(double a, double b) {
		return a / b;
	}

}