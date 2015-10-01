package algorithms.fundamentals.collections;

import algorithms.StdOut;

public class LinkedList<Item> {
	private Node<Item> first;
	private Node<Item> last;
	private int size;
	
	public boolean find(Item searchMe) {
		Node<Item> current = first;
		while (current != null) {
			if (current.value == searchMe) {
				return true;
			}
		}
		return false;
	}
	
	public void removeAfter(Node<Item> node) {
		if (node == null || node.next == null) { return; }
		node.next = node.next.next;
	}
	
	public void insertAfter(Node<Item> first, Node<Item> second) {
		if (first == null || second == null) { return; }

		second.next = first.next;
		first.next = second;
	}
	
	public void remove(Item removeMe) {
		while (!isEmpty() && first.value == removeMe) {
			first = first.next;
		}

		if (isEmpty()) { return; }

		Node<Item> previous = first;
		Node<Item> next = first.next;

		while (next != null) {
			if (next.value == removeMe) {
				previous.next = next.next;
				previous = next;
				next = next.next;
			}
		}
		this.last = previous;
	}

	public Item removeLast() {
		return delete(size - 1);
	}
	
	public Item delete(int k) {
		if (isEmpty()) return null;
		if (k == 0) { return removeFirst(); }

		Node<Item> kth = first;
		Node<Item> kthButOne = null;
		int currentK = 0;
		while (k > currentK && kth.next != null) {
			kthButOne = kth;
			kth = kth.next;
			currentK++;
		}

		if (currentK == k) { return deleteNode(kthButOne, kth); }

		return null;
	}

	public Item removeFirst() {
		if (isEmpty())
			return null;

		Node<Item> oldFirst = first;
		first = first.next;
		size--;
		if (first == null) {
			last = null;
		}
		return oldFirst.value;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return this.size;
	}

	private Item deleteNode(Node<Item> previous, Node<Item> removing) {
		previous.next = removing.next;
		size--;
		return removing.value;
	}

	private static class Node<Item> {
		Item value;
		Node<Item> next;

		@Override
		public String toString() {
			return value.toString();
		}
	}

	public static void main(String[] args) {
		Node<Integer> first = new Node<>();
		Node<Integer> second = new Node<>();
		Node<Integer> third = new Node<>();
		Node<Integer> fourth = new Node<>();
		first.value = 10;
		first.next = second;

		second.value = 6;
		second.next = third;

		third.value = 20;
		third.next = fourth;

		fourth.value = 7;

		// 1.3.28
		StdOut.println(max(first));
		StdOut.println(maxRecursive(first));
	}

	public static Node<Integer> max(Node<Integer> firstOne) {
		Node<Integer> greater = firstOne;
		Node<Integer> current = firstOne;
		while (current != null) {
			if (current.value > greater.value) {
				greater = current;
			}
			current = current.next;
		}
		return greater;
	}
	
	public static Node<Integer> maxRecursive(Node<Integer> firstOne) {
		if (firstOne == null) { return null; } 
		else { return maxRecursiveAux(firstOne, firstOne.next); }
	}

	public static Node<Integer> maxRecursiveAux(Node<Integer> greater, Node<Integer> current) {
		if(current == null) { return greater; }
		else if(current.value > greater.value) { return maxRecursiveAux(current, current.next); }
		else { return maxRecursiveAux(greater, current.next); }
	}
}
