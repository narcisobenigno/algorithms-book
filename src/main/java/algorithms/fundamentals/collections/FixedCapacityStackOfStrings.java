package algorithms.fundamentals.collections;

import algorithms.StdIn;
import algorithms.StdOut;

class FixedStringMain {
	public static void main(String[] args) {
		FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();

			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}

		StdOut.println("(" + s.size() + " left on stack)");
	}
}

public class FixedCapacityStackOfStrings {
	private int n;
	private String[] a;

	public FixedCapacityStackOfStrings(int max) {
		this.a = new String[max];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void push(String item) {
		this.a[n++] = item;
	}

	public String pop() {
		return a[--n];
	}

	public boolean isFull() {
		return n == a.length;
	}
}
