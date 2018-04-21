package com.strings;

import java.util.LinkedList;
import java.util.Queue;

public class RWayTriesSt<Value> {

	private static int R = 256;
	private Node root;

	private static class Node {
		Object value;
		Node[] next = new Node[R];

	}

	public Value get(String key) {
		Node g = get(root, key, 0);
		if (g != null) {
			return (Value) g.value;
		}
		return null;
	}

	public void put(String key, Value value) {
		root = put(root, key, value, 0);

	}

	public void delete(String key) {
		delete(root, key, 0);
	}

	private Node put(Node x, String key, Value value, int d) {

		if (x == null) {
			x = new Node();
		}
		if (key.length() == d) {
			x.value = value;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, value, d + 1);

		return x;
	}

	private Node get(Node x, String key, int d) {
		if (x == null) {
			return null;
		}
		if (key.length() == d) {
			return x;
		}
		return get(x.next[key.charAt(d)], key, d + 1);

	}

	private void delete(Node x, String key, int d) {
		if (x == null) {
			return;
		}
		if (key.length() == d) {
			x.value = null;
			return;
		}
		delete(x.next[key.charAt(d)], key, d + 1);
	}

	public static void main(String args[]) {
		String[] ax = new String[10];
		RWayTriesSt<String> map = new RWayTriesSt<>();
		for (int i = 0; i <= 9; i++) {
			ax[i] = Integer.toString(20 - i);
			map.put(ax[i], ax[i]);
		}
		for (int i = 0; i <= 9; i++) {
			System.out.println(map.get(ax[i]));
		}
		System.out.println(map.get("" + 21));
		System.out.println(map.get("" + 20));
		map.delete("" + 20);
		System.out.println(map.get("" + 20));
	}

	public Iterable<String> keys() {
		Queue<String> keys = new LinkedList<>();
		collect(root, "", keys);
		return keys;
	}

	private void collect(Node x, String prefix, Queue<String> q) {
		if (x == null) {
			return;
		}
		if (x.value != null) {
			q.add(prefix);
		}
		for (char c = 0; c < R; c++) {
			collect(x.next[c], prefix + c, q);
		}

	}
}
