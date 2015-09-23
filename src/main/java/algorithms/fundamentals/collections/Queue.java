package algorithms.fundamentals.collections;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int n;

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.value = item;
		if (isEmpty())
			first = last;
		else
			oldLast.next = last;
		n++;
	}

	public Item dequeue() {
		Item dequeued = first.value;
		first = first.next;
		if (first == null) last = null; 
		n--;
		return dequeued;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedQueueIterator();
	}

	class LinkedQueueIterator implements Iterator<Item> {
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Node oldCurrent = current;
			current = oldCurrent.next;
			return oldCurrent.value;
		}

	}

	class Node {
		Node next;
		Item value;
	}
}
