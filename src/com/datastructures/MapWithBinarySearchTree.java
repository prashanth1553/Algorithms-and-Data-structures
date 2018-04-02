package com.datastructures;

public class MapWithBinarySearchTree<Key extends Comparable<Key>, Value> {

	public Node root;

	public void put(Key key, Value value) {
		// root = put(root, key, value);
		put2(key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) {
			return new Node(key, value);
		}
		int diff = x.key.compareTo(key);
		if (diff > 0) {
			x.left = put(x.left, key, value);
		} else if (diff < 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		return x;
	}

	private void put2(Key key, Value value) {
		if (root == null) {
			root = new Node(key, value);
			return;
		}
		Node x = root;
		while (true) {
			int diff = x.key.compareTo(key);
			if (diff > 0) {
				if (x.left == null) {
					x.left = new Node(key, value);
					break;
				} else {
					x = x.left;
				}
			} else if (diff < 0) {
				if (x.right == null) {
					x.right = new Node(key, value);
					break;
				} else {
					x = x.right;
				}

			} else {
				x.value = value;
				break;
			}

		}

	}

	public Value get(Key key) {
		if (root != null) {
			Node x = root;
			while (x != null) {
				int diff = x.key.compareTo(key);
				if (diff > 0) {
					x = x.left;
				} else if (diff < 0) {
					x = x.right;

				} else {
					return x.value;
				}

			}
		}
		return null;
	}

	public Value getSmallest() {
		if (root != null) {
			Node x = root;
			while (x.left != null) {
				x = x.left;
			}
			return x.value;
		}

		return null;
	}

	public Value floor(Key key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		}
		return x.value;
	}

	private Node floor(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int diff = x.key.compareTo(key);
		if(diff == 0){
			return x;
		}
		Node f ;
		if(diff > 0){
			if(x.left == null){
				return null;
			}
			f = floor(x.left, key);
		}else{
			if(x.right == null){
				return x;
			}
			f = floor(x.right, key);
		}
		if(f != null){
			return f;
		}
		return x;
		
	}

	class Node {

		private Key key;
		private Value value;
		private Node left, right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}

	}

	public static void main(String args[]) {
		StudentAge[] ax = new StudentAge[10];
		MapWithBinarySearchTree<StudentAge, StudentAge> map = new MapWithBinarySearchTree<>();
		for (int i = 0; i <= 9; i++) {
			ax[i] = new StudentAge(20 - i);
			map.put(ax[i], ax[i]);
		}
		for (int i = 0; i <= 9; i++) {
			System.out.println(map.get(ax[i]).getId());
		}
		System.out.println(map.get(new StudentAge(21)));
		System.out.println(map.getSmallest().getId());
		StudentAge floor = map.floor(new StudentAge(1f));
		if(floor != null){
			System.out.println("florr++++"+floor.getId());
		}else{
			System.out.println("florr++++"+null);
		}
	}

}
