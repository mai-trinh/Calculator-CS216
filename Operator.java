
public abstract class Operator {

	protected int precedence; 

	public int getPrecedence() {
		return precedence;
	}

	public abstract double evaluate(double a, double b);
}









