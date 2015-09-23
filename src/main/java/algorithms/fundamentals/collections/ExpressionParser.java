package algorithms.fundamentals.collections;

import java.util.Iterator;
import java.util.TreeSet;

public class ExpressionParser {

	private TreeSet<String> acceptedOperations;

	public ExpressionParser() {
		this.acceptedOperations = new TreeSet<>();
		this.acceptedOperations.add("+");
		this.acceptedOperations.add("-");
		this.acceptedOperations.add("*");
	}

	public Expression parse(Iterator<String> iterator) {
		Stack<Expression> subExpressions = new Stack<>();
		Stack<String> ops = new Stack<>();

		while (iterator.hasNext()) {
			String token = iterator.next();
			if (token.equals("("))
				;
			else if (this.acceptedOperations.contains(token)) {
				ops.push(token);
			} else if (token.equals(")")) {
				if (subExpressions.size() > 1) {
					Expression right = subExpressions.pop();
					Expression left = subExpressions.pop();
					subExpressions.push(new BinaryOperator(left, ops.pop(), right));
				}
			} else {
				subExpressions.push(new Value(Integer.valueOf(token)));
			}
		}
		return subExpressions.pop();
	}

	static interface Expression {
		String toPostfixStr();
	}

	private static class BinaryOperator implements Expression {
		private Expression left;
		private String operation;
		private Expression right;

		public BinaryOperator(Expression left, String operation, Expression right) {
			this.left = left;
			this.operation = operation;
			this.right = right;
		}

		@Override
		public String toPostfixStr() {
			return "(" + left.toPostfixStr() + " " + right.toPostfixStr() + " " + operation + ")";
		}
	}

	private static class Value implements Expression {
		private Integer value;

		public Value(Integer value) {
			this.value = value;
		}

		@Override
		public String toPostfixStr() {
			return value.toString();
		}
	}

}
