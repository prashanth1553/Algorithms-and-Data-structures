package com.datastructures;

public class PriorityQueueWithBinaryHeap<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N; // number of elements on pq

	public PriorityQueueWithBinaryHeap(int capacity) {
		pq = (Key[]) new Comparable[capacity + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(Key x) {
		pq[N++] = x;
		swim(N);
	}

	public Key deleteMax() {
		Key last = pq[N - 1];
		exchange(pq, 1, N);
		sink(1);
		pq[--N] = null;
		return last;

	}

	private void swim(int k) {
		while (k > 1) {
			if (less(k / 2, k)) {
				exchange(pq, k / 2, k);
				k = k / 2;
			} else {
				break;
			}
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1)) {
				j++;
			}
			if (less(k, j)) {
				exchange(pq, k, j);
				k = j;
			} else {
				break;
			}
		}
	}

	public boolean less(int v, int w) {
		return pq[--v].compareTo(pq[--w]) < 0;
	}

	public static void exchange(Comparable[] a, int i, int j) {
		--i;
		--j;
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String args[]) {

		StudentAge[] ax = new StudentAge[10];
		for (int i = 0; i <= 9; i++) {
			ax[i] = new StudentAge(20 - i);
		}
		PriorityQueueWithBinaryHeap ar = new PriorityQueueWithBinaryHeap<>(3);
		for (int i = 0; i < 10; i++) {
			ar.insert(ax[i]);
			if (ar.size() > 3) {
				ar.deleteMax();
			}
		}
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(((StudentAge) ar.pq[i]).getId());
		}
	}
}
