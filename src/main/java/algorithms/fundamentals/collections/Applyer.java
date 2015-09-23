package algorithms.fundamentals.collections;

import algorithms.StdIn;
import algorithms.StdOut;

public class Applyer {

	public static void main(String[] args) {
		Queue<String> tokens = new Queue<>();
		while (!StdIn.isEmpty()) {
			tokens.enqueue(StdIn.readString());
		}

		StdOut.println(new ExpressionParser().parse(tokens.iterator()).apply());
	}

}
