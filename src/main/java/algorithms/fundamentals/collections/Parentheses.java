package algorithms.fundamentals.collections;

import java.util.HashMap;

import algorithms.StdIn;
import algorithms.StdOut;

class MainParentheses {
	public static void main(String[] args) {
		Parentheses s = new Parentheses();

		while (!StdIn.isEmpty()) {
			String sequence = StdIn.readString();

			StdOut.println("Is '" + sequence + "' Balanced? " + s.isBalanced(sequence));
		}
	}
}

public class Parentheses {
	private HashMap<Character, Character> openClose;
	private HashMap<Character, Character> closeOpen;

	public Parentheses() {
		this.openClose = new HashMap<>();
		this.openClose.put('(', ')');
		this.openClose.put('[', ']');
		this.openClose.put('{', '}');

		this.closeOpen = new HashMap<>();
		this.closeOpen.put(')', '(');
		this.closeOpen.put(']', '[');
		this.closeOpen.put('}', '{');
	}

	public boolean isBalanced(String sequence) {
		Stack<Character> balance = new Stack<Character>();
		for (char c : sequence.toCharArray()) {
			if (this.openClose.containsKey(c)) {
				balance.push(c);
			}
			else if (this.openClose.containsValue(c) && balance.peek() == this.closeOpen.get(c))
				balance.pop();
		}

		return balance.size() == 0;
	}
}
