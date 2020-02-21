

import java.util.EmptyStackException;

public class EqualOp extends Operator {
	
	public EqualOp() {
		precedence = 0;
	}

	public double evaluate(double a, double b) {
		// evaluate the entire expression 
		throw  new UnsupportedOperationException();
		// how to handle = symbol ... ? EmptyStackException 
	}
}
