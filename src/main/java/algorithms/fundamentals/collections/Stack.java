package algorithms.fundamentals.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int n;

	public void push(Item value) {
		Node oldFirst = first;
		first = new Node();
		first.next = oldFirst;
		first.value = value;
		n++;
	}

	public Item pop() {
		Node oldFirst = first;
		first = oldFirst.next;
		n--;
		return oldFirst.value;
	}

	public Item peek() {
		return first.value;
	}

	public void clear() {
		first = null;
		n = 0;
	}

	public Integer size() {
		return n;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		return new StackIterable();
	}

	private class Node {
		Item value;
		Node next;
	}

	private class StackIterable implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Node item = current;
			current = item.next;
			return item.value;
		}

	}

	@Override
	public String toString() {
		List<Item> items = new ArrayList<Item>();
		for(Node node = first; node != null; node = node.next) {
			items.add(node.value);
		}
		return items.stream().map(i -> i.toString()).collect(Collectors.joining("|"));
	}
}
