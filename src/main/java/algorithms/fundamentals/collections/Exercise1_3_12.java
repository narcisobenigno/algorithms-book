package algorithms.fundamentals.collections;

import algorithms.StdOut;

public class Exercise1_3_12 {

	public static void main(String[] args) {
		Stack<String> items = new Stack<>(); 
		items.push("foo");
		items.push("fuu");
		items.push("bar");
		items.push("baz");
		
		for (String item : items) {
			StdOut.println(item);
		}
		
		for (String item : Stack.copy(items)) {
			StdOut.println(item);
		}
	}

}
