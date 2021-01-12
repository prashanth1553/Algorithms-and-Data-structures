package com.datastructures;

public class ResizingArrayQueue<Item> {

	Item[] items;
	int n;
	int first, last;

	public ResizingArrayQueue() {
		items = (Item[]) new Object[2];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	private void resize(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = items[(i + first) % items.length];
		}
		items = temp;
		first = 0;
		last = n;

	}

	public void enque(Item item) {
		if (n == items.length) {
			resize(items.length * 2);
		}
		items[last++] = item;
		if (last == items.length) { // wrap around
			last = 0;
		}
		n++;
	}

	public Item deque() {
		if (isEmpty()) {
			return null;
		}
		Item item = items[first];
		items[first++] = null;
		n--;
		if (first == items.length) // wrap around
			first = 0;
		if (n > 0 && n == items.length / 4) {
			resize(items.length / 2);
		}
		return item;
	}
}
