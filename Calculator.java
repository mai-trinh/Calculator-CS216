
import java.util.EmptyStackException;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Calculator extends Application 
{
	// the calculator dimensions
	public static int CALC_WIDTH = 400;
	public static int CALC_HEIGHT = 300;

	// the calculator screen
	private TextField screen; 

	// the calculator buttons
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button addButton;
	private Button minusButton;
	private Button mulButton;
	private Button divButton;
	private Button leftParenButton;
	private Button rightParenButton;
	private Button button0;
	private Button dotButton;
	private Button equalButton; 
	private Button expButton; 
	private Button eButton; 
	
	// private string to represent the multi digit number 
	// string start empty => keep ading on to the string 
	// when we reach an operator
	// before processOperator => parse the string put onto the stack 
	// finally, clear the string so it doens't add up other numbers 
	// the parenthesis 

	// create two stacks 
	private Stack<Double> operands = new Stack<Double>(); 
	private Stack<Operator> operators = new Stack<Operator>(); 
	
	// create a string for multi digit number
	private String numberStr = ""; // number string starts empty



	@Override
	public void start(Stage primaryStage) 
	{
		// create the calculator screen
		screen = new TextField(); 

		// create the buttons
		button1 = new Button("1");
		button2 = new Button("2");
		button3 = new Button("3");
		button4 = new Button("4");
		button5 = new Button("5");
		button6 = new Button("6");
		button7 = new Button("7");
		button8 = new Button("8");
		button9 = new Button("9");
		button0 = new Button("0");
		addButton = new Button("+");
		minusButton = new Button("-");
		mulButton = new Button("*"); 
		divButton = new Button("/");
		leftParenButton = new Button("(");
		rightParenButton = new Button(")");
		dotButton = new Button(".");
		equalButton = new Button("=");
		expButton = new Button("^");
		eButton = new Button("C");



		// attach a handler to process button clicks 
		ButtonHandler handler = new ButtonHandler();       
		button1.setOnAction(handler);
		button2.setOnAction(handler);
		button3.setOnAction(handler);
		button4.setOnAction(handler);
		button5.setOnAction(handler);
		button6.setOnAction(handler);
		button7.setOnAction(handler);
		button8.setOnAction(handler);
		button9.setOnAction(handler);
		button0.setOnAction(handler);
		addButton.setOnAction(handler);
		minusButton.setOnAction(handler);
		mulButton.setOnAction(handler);
		divButton.setOnAction(handler);
		leftParenButton.setOnAction(handler);
		rightParenButton.setOnAction(handler);
		dotButton.setOnAction(handler);
		equalButton.setOnAction(handler);
		expButton.setOnAction(handler);
		eButton.setOnAction(handler);

		// setup a grid panel for the keypad
		GridPane keypad = new GridPane();  
		keypad.setMinSize(CALC_WIDTH, CALC_HEIGHT); 
		keypad.setPadding(new Insets(10, 10, 10, 10));  
		keypad.setVgap(5); 
		keypad.setHgap(5);       
		keypad.setAlignment(Pos.CENTER); 

		// attach the buttons to the keypad grid
		keypad.add(button1, 0, 0); 
		keypad.add(button2, 1, 0); 
		keypad.add(button3, 2, 0);  
		keypad.add(addButton, 3, 0);
		keypad.add(minusButton, 4, 0);
		keypad.add(button4, 0, 1); 
		keypad.add(button5, 1, 1); 
		keypad.add(button6, 2, 1); 
		keypad.add(mulButton, 3, 1);
		keypad.add(divButton, 4, 1);
		keypad.add(button7, 0, 2); 
		keypad.add(button8, 1, 2); 
		keypad.add(button9, 2, 2); 
		keypad.add(leftParenButton, 3, 2);
		keypad.add(rightParenButton, 4, 2);
		keypad.add(button0, 0, 3);
		keypad.add(dotButton, 1, 3);
		keypad.add(equalButton, 2, 3);
		keypad.add(expButton, 3, 3);
		keypad.add(eButton, 4, 3);


		// put screen and keypad together
		BorderPane gui = new BorderPane();
		gui.setTop(screen);
		gui.setCenter(keypad);

		// set up the scene
		Scene scene = new Scene(gui); 
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	// BIG,MAIN, IMPORTANT method 
	// TODO 
	public void processOperator(Operator op) {
		//		double first;
		//		double second; not good


		// if the operator stack is NOT empty...

		// as long as the operator on top of the operator stack 
		// has higher or equal precedence 
		// to the current operator (op)

		// java executes left to right 
		while ( !operators.isEmpty() && operators.peek().getPrecedence() >= op.getPrecedence() ) 
		{
			// pop an operator 
			Operator top = operators.pop();
			//System.out.println(top);

			// and two operands 
			double right = operands.pop(); // right hand side of the equation
			double left = operands.pop(); // left hand side of the equation

			// evaluate the popped operator 
			double result = top.evaluate(left, right);

			// push the result back on the operand stack 
			operands.push(result);

		}

		// push the current operator on top of operator stack
		operators.push(op);
		//System.out.println(op);

		// System.out.println("Current stack: " + operator.toString());
	}


	// Handler for processing the button clicks 

	private class ButtonHandler implements EventHandler<ActionEvent>
	{ 
		@Override 
		public void handle(ActionEvent e) 
		{
			if (e.getSource() == button0) {
				System.out.println("Button 0 Pressed");
				screen.appendText("0");
			    numberStr += "0";
			}
			else if (e.getSource() == button1) {
				System.out.println("Button 1 Pressed");
				screen.appendText("1");
				numberStr += "1";
				// operands.push(Double.parseDouble(numberStr));
				
			}
			else if (e.getSource() == button2) {
				System.out.println("Button 2 Pressed");
				screen.appendText("2");
				numberStr += "2";

			}
			else if (e.getSource() == button3) {
				System.out.println("Button 3 Pressed");
				screen.appendText("3");
				numberStr += "3";

			}
			else if (e.getSource() == button4) {
				System.out.println("Button 4 Pressed");
				screen.appendText("4");
				numberStr += "4";

			}
			else if (e.getSource() == button5) {
				System.out.println("Button 5 Pressed");
				screen.appendText("5");
				numberStr += "5";
			}
			else if (e.getSource() == button6) {
				System.out.println("Button 6 Pressed");
				screen.appendText("6");
				numberStr += "6";
			}
			else if (e.getSource() == button7) {
				System.out.println("Button 7 Pressed");
				screen.appendText("7");
				numberStr += "7";
			}
			else if (e.getSource() == button8) {
				System.out.println("Button 8 Pressed");
				screen.appendText("8");
				numberStr += "8";
			}
			else if (e.getSource() == button9) {
				System.out.println("Button 9 Pressed");
				screen.appendText("9");
				numberStr += "9";
			}
			// ADDITION 
			else if (e.getSource() == addButton) {
				System.out.println("Button + Pressed");

				// show on screen 
				screen.appendText("+");
				
				// make number string into an actual number
				// and push that number onto the operands stack
				operands.push(Double.parseDouble(numberStr));
				
				// clear the string (so the next numbers don't add up)
				numberStr = ""; //reset it to an empty string

				// make a new operator object
				Operator addOp = new AddOp(); 

				// send to loop -> processOperator (above) method will take care of this. 
				processOperator(addOp); 
				

			}

			// SUBTRACTION
			else if (e.getSource() == minusButton) {
				System.out.println("Button - Pressed");
				screen.appendText("-");
				operands.push(Double.parseDouble(numberStr));
				numberStr = ""; 
				Operator minusOp = new MinusOp();
				processOperator(minusOp);
			}

			// MULTIPLICATION
			else if (e.getSource() == mulButton) {
				System.out.println("Button * Pressed");
				screen.appendText("*");
				operands.push(Double.parseDouble(numberStr));
				numberStr = ""; 
				Operator mulOp = new MulOp();
				processOperator(mulOp);
			}

			// DIVISION
			else if (e.getSource() == divButton) {
				System.out.println("Button / Pressed");
				screen.appendText("/");
				operands.push(Double.parseDouble(numberStr));
				numberStr = ""; 
				Operator divOp = new DivOp();
				processOperator(divOp);
			}

			// POWER
			else if (e.getSource() == expButton) {
				System.out.println("Button ^ Pressed");
				screen.appendText("^");
				operands.push(Double.parseDouble(numberStr));
				numberStr = ""; 
				Operator expOp = new ExpOp();
				processOperator(expOp);
			}
			else if (e.getSource() == leftParenButton) {
				System.out.println("Button ( Pressed");

				// show it on the screen
				screen.appendText("(");

				// make object
				Operator leftParen = new LeftParenOp();

				// push directly onto the operator stack
				operators.push(leftParen);
			}
			else if (e.getSource() == rightParenButton) {
				System.out.println("Button ) Pressed");

				// show it on the screen
				screen.appendText(")");

				// push number onto operands stack 
				operands.push(Double.parseDouble(numberStr));
				
				//reset 
				numberStr = "";
				
				// make object
				Operator rightParen = new RightParenOp();

				// send to loop until sees (
				processOperator(rightParen); 

				// pop pop
				operators.pop();
				operators.pop();
				
				// take the top number on stack => string 
				numberStr = operands.pop().toString();
				
				
			}

			else if (e.getSource() == dotButton) {
				System.out.println("Button . Pressed");
				screen.appendText(".");
				numberStr += ".";
			}
			else if (e.getSource() == equalButton) {
				System.out.println("Button = Pressed");

				// show it
				screen.appendText("=");
				
				// make number string into an actual number
				// and push that number onto the operands stack
				operands.push(Double.parseDouble(numberStr));
				
				// clear the string (so the next numbers don't add up)
				numberStr = ""; //reset it to an empty string

				// make object
				Operator equalOp = new EqualOp();
				
				// send to loop to kick every operator out 
				processOperator(equalOp);
				
				//clear screen
				screen.clear();

				// peek result and show on screen
				screen.appendText(operands.peek().toString());

				// pop operator
				operators.pop();
				
				numberStr = operands.pop().toString();
			}
			else if (e.getSource() == eButton) {
				System.out.println("Button C Pressed");
				// clear screen
				screen.clear(); //?
				// clear two stacks 
				operands.clear();
				operators.clear();
				
				// clear numberStr
				numberStr = "";
			}
			System.out.println(operands);
			System.out.println(operators.toString());
			System.out.println(numberStr);
		} 
	}  

	public static void main(String[] args)
	{
		launch(args);
	}
}
