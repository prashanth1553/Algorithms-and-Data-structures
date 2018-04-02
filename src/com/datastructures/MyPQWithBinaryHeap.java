package com.datastructures;

public class MyPQWithBinaryHeap<Key extends Comparable<Key>> {

	int N;
	Key[] elements;

	public MyPQWithBinaryHeap(int size) {

		elements = (Key[]) new Comparable[size];
	}

	public int size() {
		return N;
	}

	public void insert(Key key) {

		elements[N++] = key;
		swim(N);
	}

	public Key deleteMax() {
		Key max = elements[0];
		elements[0] = elements[--N];
		elements[N] = null;
		sink(1);
		return max;
	}

	public void swim(int k) {

		while (k > 1 && less(k / 2, k)) {
			exchange(k / 2, k);
			k = k / 2;
		}

	}

	public void sink(int k) {

		while (2 * k <= N) {

			int j = 2 * k;
			if (j < N && less(j, j + 1)) {
				j++;
			}
			if (less(k, j)) {
				exchange(k, j);
				k = j;
			} else {
				break;
			}

		}

	}

	public boolean less(int a, int b) {

		return elements[--a].compareTo(elements[--b]) < 0;
	}

	public void exchange(int a, int b) {
		Key temp = elements[--a];
		elements[a] = elements[--b];
		elements[b] = temp;
	}

	public static void main(String args[]) {

		StudentAge[] ax = new StudentAge[10];
		for (int i = 0; i <= 9; i++) {
			ax[i] = new StudentAge(20 - i);
		}
		MyPQWithBinaryHeap ar = new MyPQWithBinaryHeap<>(3);
		for (int i = 0; i < 10; i++) {
			if (ar.size() >= 3) {
				ar.deleteMax();
			}
			ar.insert(ax[i]);
		}
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(((StudentAge) ar.elements[i]).getId());
		}
	}
}
