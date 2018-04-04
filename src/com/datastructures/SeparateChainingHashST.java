package com.datastructures;

public class SeparateChainingHashST<Key, Value> {

	private int M = 97;

	private Node[] st = new Node[M];

	private static class Node {

		Object key;
		Object value;
		private Node next;

		public Node(Object key, Object value, Node next) {

			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private int hash(Key key) {
		return (key.hashCode() & 0X7fffffff) % M;
	}

	public Value get(Key key) {
		for (Node x = st[hash(key)]; x != null; x = x.next) {
			if (x.key.equals(key)) {
				return (Value) x.value;
			}
		}
		return null;
	}

	public void put(Key key, Value value) {
		int i = hash(key);
		for (Node x = st[i]; x != null; x = x.next) {
			if (x.key.equals(key)) {
				x.value = value;
				return;
			}
		}
		st[i] = new Node(key, value, st[i]);
	}

	public static void main(String args[]) {
		StudentAge[] ax = new StudentAge[91];
		for (int i = 0; i <= 90; i++) {
			ax[i] = new StudentAge(100 - i);
		}
		SeparateChainingHashST<StudentAge, StudentAge> map = new SeparateChainingHashST<>();
		for (int i = 0; i < 91; i++) {
			map.put(ax[i], ax[i]);

		}
		for (int i = 0; i < ax.length; i++) {
			System.out.println((map.get(ax[i])).getId());
		}
	}
}
