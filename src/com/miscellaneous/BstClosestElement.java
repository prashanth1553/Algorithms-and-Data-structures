package com.miscellaneous;

import java.util.Iterator;

public class BstClosestElement implements Iterable<Integer> {

	Node root;

	class Node {

		Integer key;
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
		if (x.key == search) {
			return x;
		}
		int diff = search - x.key;
		Node cl = null;
		if (diff > 0) {
			cl = findClosest(x.right, search);
		} else {
			cl = findClosest(x.left, search);
		}
		if (cl != null) {
			int cDiff = search - cl.key;
			if (Math.abs(cDiff) < Math.abs(diff)) {
				return cl;
			}
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

		BstClosestElement obj = new BstClosestElement();
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
		for(Integer i: obj) {
			
		}

	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return  new MyIterator();
	}
	
	class MyIterator implements Iterator<Integer> {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Integer next() {
			return null;
		}
		
	}
}
