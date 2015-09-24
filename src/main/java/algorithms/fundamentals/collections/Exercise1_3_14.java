package algorithms.fundamentals.collections;

import algorithms.StdOut;

public class Exercise1_3_14 {
	public static void main(String[] args) {
		ResizeArrayQueueOfStrings queue = new ResizeArrayQueueOfStrings();

		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.enqueue("4");
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		queue.enqueue("5");
		queue.enqueue("6");
		queue.enqueue("7");
		queue.enqueue("8");
		queue.enqueue("9");
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
	}
}
