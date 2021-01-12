package com.datastructures;

public class Bst {
	Node root;

	class Node {

		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
		}

	}

	public void insert(int e) {

		root = insert(root, e);
	}

	public Node insert(Node x, int e) {

		if (x == null) {
			return new Node(e);
		}
		if (e > x.key) {
			x.right = insert(x.right, e);
		} else {
			x.left = insert(x.left, e);
		}
		return x;

	}

	public int findClosest(int search) {

		Node cl = findClosest(root, search);
		if (cl != null) {
			return cl.key;
		}
		return -1;
	}

	public Node findClosest(Node x, int search) {

		if (x == null) {
			return null;
		}
		int diffT = x.key - search;
		Node cl = null;
		boolean isLeft = true;
		if (diffT == 0) {
			return x;
		} else if (diffT > 0) {
			cl = findClosest(x.left, search);
		} else {
			isLeft = false;
			cl = findClosest(x.right, search);
		}
		if (cl != null && Math.abs(diffT) >= Math.abs(cl.key - search)) {
			return cl;
		}

		return x;
	}

	public int floor(int e) {
		Node f = floor(root, e);
		if (f != null) {
			return f.key;
		}
		return -1;
	}

	public Node floor(Node x, int e) {
		if (x == null) {
			return null;
		}
		if (x.key == e) {
			return x;
		}
		if (x.key > e) {
			return floor(x.left, e);
		}
		Node f = floor(x.right, e);
		if (f != null) {
			return f;
		}
		return x;

	}

	public static void main(String args[]) {

		Bst obj = new Bst();
		obj.insert(4);
		obj.insert(6);
		obj.insert(5);
		obj.insert(10);
		System.out.println(obj.findClosest(11));
		System.out.println(obj.findClosest(10));
		System.out.println(obj.findClosest(1));
		System.out.println(obj.findClosest(2));
		System.out.println(obj.findClosest(5));
		System.out.println(obj.findClosest(7));
		// obj.insert(10);
		System.out.println(obj.findClosest(9));
		System.out.println(obj.findClosest(8));
		System.out.println(obj.findClosest(7));
		System.out.println(obj.findClosest(6));

	}
}
