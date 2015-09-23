package algorithms.fundamentals.collections;

import algorithms.StdIn;
import algorithms.StdOut;

public class InfixToPostfix {
	private ExpressionParser parser;

	public InfixToPostfix(ExpressionParser expressionParser) {
		this.parser = expressionParser;

	}

	public String convert(Queue<String> tokens) {
		return parser.parse(tokens.iterator()).toPostfixStr();
	}

	public static void main(String[] args) {
		Queue<String> tokens = new Queue<>();
		while (!StdIn.isEmpty()) {
			tokens.enqueue(StdIn.readString());
		}

		StdOut.println(new InfixToPostfix(new ExpressionParser()).convert(tokens));
	}
}
