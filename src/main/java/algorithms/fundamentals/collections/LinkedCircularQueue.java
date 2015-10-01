package algorithms.fundamentals.collections;

import algorithms.StdOut;

public class LinkedCircularQueue<T> {
	private Node<T> last;
	private int n = 0;

	public void enqueue(T item) {
		Node<T> newLast = new Node<T>() {{
			this.value = item;
			this.next = first();
		}};
		
		if(isEmpty()) { newLast.next = newLast; }
		else 		  { last.next = newLast; }
		
		last = newLast;
		n++;
	}

	public T dequeue() {
		if (isEmpty()) { return null; }
		else if (size() == 1) {
			Node<T> oldLast = last;
			last = null;
			n--;
			return oldLast.value;
		}
		else { 
			Node<T> oldFirst = first();
			last.next = oldFirst.next;
			n--;
			return oldFirst.value;
		}
		
	}

	private Node<T> first() {
		if(isEmpty()) { return null; }
		else 		  { return last.next; }
	}
	
	public boolean isEmpty() { return last == null; }
	
	public int size() { return n; }

	private static class Node<T> {
		T value;
		Node<T> next;
	}

	public static void main(String[] args) {
		LinkedCircularQueue<Integer> queue = new LinkedCircularQueue<>();
		queue.enqueue(1);
		StdOut.println(queue.dequeue());
		queue.enqueue(2);
		queue.enqueue(3);
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		StdOut.println(queue.dequeue());
		queue.enqueue(7);
		queue.enqueue(8);
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
		StdOut.println(queue.dequeue());
	}
}
