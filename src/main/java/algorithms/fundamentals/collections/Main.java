package algorithms.fundamentals.collections;

public class Main {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("to");
		stack.push("be");
		stack.push("or");
		stack.push("not");
		stack.push("to");
		stack.push("be");
		for (String value : stack)
			System.out.println(value);

		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
	}

}
