package algorithms.fundamentals.collections;

import algorithms.StdIn;
import algorithms.StdOut;

public class Parenthize {
	private Stack<String> closeParentheses = new Stack<>();

	private String expression(Stack<String> input) {
		String result = parenthizeSubExpressions(input);
		
		return mountParentheses(result);
	}

	private String parenthizeSubExpressions(Stack<String> input) {
		String parenthisedExpression = "";
		final Stack<String> operands = new Stack<>();
		final Stack<String> operators = new Stack<>();
		while (input.size() > 0) {
			String value = input.pop();

			switch(value) {
			case ")":
				closeParentheses.push(value);
				break;
			case "*":
				operators.push(value);
				break;
			case "-":
				operators.push(value);
				break;
			case "+":
				operators.push(value);
				break;
			default:
				operands.push(value);
				if (operands.size() == 2) {
					String subExpression = operands.pop() + operators.pop() + operands.pop();
					String operator = operators.isEmpty() ? "" : operators.pop();
					parenthisedExpression = "(" + subExpression + closeParentheses.pop() + operator
							+ parenthisedExpression;
				}
				break;
			}
		}

		return parenthisedExpression;
	}

	private String mountParentheses(String result) {
		for (String closeParenthese : closeParentheses) {
			result = "(" + result + closeParenthese;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Stack<String> input = new Stack<>();
		while (!StdIn.isEmpty()) {
			input.push(StdIn.readString());
		}

		StdOut.println(parenthiseExpression(input));
	}

	private static String parenthiseExpression(Stack<String> input) {
		return new Parenthize().expression(input);
	}
	
	
}
