package com.strings;

public class TST<Value> {

	private static int R = 256;
	private Node root;

	private static class Node {
		Object value;
		char c;
		Node left, mid, right;

		public Node(char c, Object value) {
			this.c = c;
			this.value = value;
		}

		public Node() {
		}

	}

	public void put(String key, Value value) {
		root = put(root, key, value, 0);
	}

	public Value get(String key) {
		Node g = get(root, key, 0);
		if (g != null) {
			return (Value) g.value;
		}
		return null;
	}

	private Node put(Node x, String key, Value value, int d) {
		if (x == null) {
			x = new Node();
			x.c = key.charAt(d);
		}
		int com = Character.compare(x.c, key.charAt(d));
		if (com > 0) {
			x.left = put(x.left, key, value, d);

		} else if (com < 0) {
			x.right = put(x.right, key, value, d);
		} else if (key.length() - 1 > d) {
			x.mid = put(x.mid, key, value, d);
		} else {
			x.value = value;
		}

		return x;
	}

	private Node get(Node x, String key, int d) {
		if (x == null) {
			return null;
		}
		int com = Character.compare(x.c, key.charAt(d));
		if (com > 0) {
			return get(x.left, key, d);

		} else if (com < 0) {
			return get(x.right, key, d);
		} else if (key.length() - 1 > d) {
			return get(x.mid, key, d + 1);
		} else {
			return x;
		}
	}

	public static void main(String args[]) {
		String[] ax = new String[10];
		TST<String> map = new TST<>();
		for (int i = 0; i <= 9; i++) {
			ax[i] = Integer.toString(i);
			map.put(ax[i], ax[i]);
		}
		for (int i = 0; i <= 9; i++) {
			System.out.println(map.get(ax[i]));
		}
		System.out.println(map.get("" + 21));
		System.out.println(map.get("" + 20));
	}
}
