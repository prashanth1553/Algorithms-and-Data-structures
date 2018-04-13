package com.graph;

public class BinaryTree {

	Node root;

	BinaryTree() {
		root = null;
	}

	static class Node {
		Node right, left;
		int name;

		public Node(int name) {
			this.name = name;
			left = right = null;
		}
	}

	public void breadthFirstTraverse(Node x) {
		System.out.println(x.name);
		System.out.println(x.left + " " + x.right);
		
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

	}

}
