package com.smi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleStacksUsingSingleArray<Item> {

	private int M;
	private int N;
	Item items[];
	int indexPointers[];
	List<Integer> availableSlotsList;

	public MultipleStacksUsingSingleArray(int M, int N) {
		this.M = M;
		this.N = N;
		items = (Item[]) new Object[N];
		indexPointers = new int[M];
		Arrays.fill(indexPointers, -1);
		availableSlotsList = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			availableSlotsList.add(i);
		}
	}

	class Item {
		int data;
		int previous = -1;

		public Item(int data, int previous) {
			this.data = data;
			this.previous = previous;
		}
	}

	public int pop(int i) throws IllegalAccessException {
		if (indexPointers[i] == -1) {
			throw new IllegalAccessException("Empty");
		}
		Item item = items[indexPointers[i]];
		indexPointers[i] = item.previous;
		availableSlotsList.remove(new Integer(indexPointers[i]));
		return item.data;
	}

	public void push(int element, int stack) {
		int av = availableSlotsList.get(availableSlotsList.size() - 1);
		availableSlotsList.remove(availableSlotsList.size() - 1);
		Item item = new Item(element, indexPointers[stack]);
		items[av] = item;
		indexPointers[stack] = av;

	}

}
