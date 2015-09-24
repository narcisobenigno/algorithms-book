package algorithms.fundamentals.collections;

public class ResizeArrayQueueOfStrings {

	private String[] queue;
	private int first = 0;
	private int size = 0;

	public ResizeArrayQueueOfStrings() {
		this.queue = new String[3];
	}

	public void enqueue(String item) {
		grantSize();

		this.queue[(first + size++)] = item;
	}

	public String dequeue() {
		if (isEmpty()) return null; 

		String dequeued = this.queue[first];

		this.queue[first] = null;
		this.size--;
		this.first++;
		return dequeued;
	}

	private boolean isFull() {
		return size == queue.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void grantSize() {
		if (!isFull() && (first + size) >= queue.length) {
			shrink();
		}
		else if (isFull()) {
			resize(2 * queue.length);
		}
	}

	private void resize(int newSize) {
		String[] newQueue = new String[newSize];
		for (int i = first, j = 0; j < size; i++, j++) {
			newQueue[j] = this.queue[i];
		}
		this.first = 0;
		this.queue = newQueue;
	}

	private void shrink() {
		for (int i = first, j = 0; j < size; i++, j++) {
			queue[j] = queue[i];
			queue[i] = null;
		}
		this.first = 0;
	}
}
