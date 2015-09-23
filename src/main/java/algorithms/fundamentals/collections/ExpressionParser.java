package algorithms.fundamentals.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExpressionParser {

	private Map<String, BinaryOperator.BuilderOperator> acceptedOperations;

	public ExpressionParser() {
		this.acceptedOperations = new TreeMap<>();
		this.acceptedOperations.put("+", Sum.Builder.create());
		this.acceptedOperations.put("-", Minus.Builder.create());
		this.acceptedOperations.put("*", Times.Builder.create());
	}

	public Expression parse(Iterator<String> iterator) {
		Stack<Expression> subExpressions = new Stack<>();
		Stack<String> ops = new Stack<>();

		while (iterator.hasNext()) {
			String token = iterator.next();
			if (token.equals("("))
				;
			else if (this.acceptedOperations.containsKey(token)) {
				ops.push(token);
			} else if (token.equals(")")) {
				if (subExpressions.size() > 1) {
					Expression right = subExpressions.pop();
					Expression left = subExpressions.pop();
					subExpressions.push(new BinaryExpression(left, ops.pop(), right));
				}
			} else {
				subExpressions.push(new Value(Integer.valueOf(token)));
			}
		}
		return subExpressions.pop();
	}

	static interface Expression {
		String toPostfixStr();
		Integer apply();
	}

	private class BinaryExpression implements Expression {
		private Expression left;
		private BinaryOperator operation;
		private Expression right;

		public BinaryExpression(Expression left, String operation, Expression right) {
			this.left = left;
			this.operation = acceptedOperations.get(operation).build();
			this.right = right;
		}

		@Override
		public String toPostfixStr() {
			return "(" + left.toPostfixStr() + " " + right.toPostfixStr() + " " + operation + ")";
		}

		@Override
		public Integer apply() {
			return operation.apply(left, right);
		}
	}

	private static class Value implements Expression {
		private Integer value;

		public Value(Integer value) {
			this.value = value;
		}

		@Override
		public Integer apply() {
			return value;
		}

		@Override
		public String toPostfixStr() {
			return value.toString();
		}
	}

	private static interface BinaryOperator {
		Integer apply(Expression left, Expression right);

		String toString();
		
		static interface BuilderOperator {
			BinaryOperator build();
		}
	}

	private static class Sum implements BinaryOperator {
		@Override
		public Integer apply(Expression left, Expression right) {
			return left.apply() + right.apply();
		}

		@Override
		public String toString() {
			return "+";
		}

		static class Builder implements BinaryOperator.BuilderOperator {
			public static BinaryOperator.BuilderOperator create() {
				return new Builder();
			}

			@Override
			public BinaryOperator build() {
				return new Sum();
			}
		}
	}

	private static class Minus implements BinaryOperator {
		@Override
		public Integer apply(Expression left, Expression right) {
			return left.apply() - right.apply();
		}


		@Override
		public String toString() {
			return "-";
		}

		static class Builder implements BinaryOperator.BuilderOperator {
			public static BinaryOperator.BuilderOperator create() {
				return new Builder();
			}

			@Override
			public BinaryOperator build() {
				return new Minus();
			}
		}
	}

	private static class Times implements BinaryOperator {
		@Override
		public Integer apply(Expression left, Expression right) {
			return left.apply() * right.apply();
		}

		@Override
		public String toString() {
			return "*";
		}

		static class Builder implements BinaryOperator.BuilderOperator {
			public static BinaryOperator.BuilderOperator create() {
				return new Builder();
			}

			@Override
			public BinaryOperator build() {
				return new Times();
			}
		}
	}
}
