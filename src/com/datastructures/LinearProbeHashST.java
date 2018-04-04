package com.datastructures;

public class LinearProbeHashST<Key, Value> {

	int M = 400;

	Key[] keys = (Key[]) new Object[M];
	Value[] values = (Value[]) new Object[M];

	public Value get(Key key) {
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (key.equals(keys[i])) {
				return values[i];
			}
		}
		return null;

	}

	public void put(Key key, Value value) {
		// need to increase the size before inserting
		int i = hash(key);
		for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
			if (key.equals(keys[i])) {
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;

	}

	private int hash(Key key) {
		int internalHash = key.hashCode();
		return (internalHash & 0X7fffffff) % M;
	}

	public static void main(String args[]) {
		int size = 20;
		StudentAge[] ax = new StudentAge[size];
		for (int i = 0; i < size; i++) {
			ax[i] = new StudentAge(200 - i);
		}
		LinearProbeHashST<StudentAge, StudentAge> map = new LinearProbeHashST<>();
		for (int i = 0; i < size; i++) {
			map.put(ax[i], ax[i]);

		}
		for (int i = 0; i < ax.length; i++) {
			System.out.println((map.get(ax[i])).getId());
		}
	}
}
