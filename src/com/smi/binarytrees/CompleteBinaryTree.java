package com.smi.binarytrees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws NumberFormatException, IOException {

//		1
//		6
//		20 10 30 5 15 4
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			BST bst = new BST();
			int N = Integer.parseInt(bufferedReader.readLine().trim());
			String number[] = bufferedReader.readLine().trim().split(" ");
			for (String element : number) {
				bst.put(Integer.parseInt(element));
			}
			if (bst.isComplete(bst.root)) {
				writer.write("Yes");
			} else {
				writer.write("No");
			}
			writer.write("\n");

		}
		writer.flush();
	}

	static class Node {
		int data;
		Node left, right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	static class BST {

		private Node root = null;

		private void put(int data) {
			root = put(root, data);
		}

		private Node put(Node root, int data) {
			if (root == null) {
				root = new Node(data, null, null);
				return root;
			}
			if (root.data < data) {
				root.right = put(root.right, data);
			} else {
				root.left = put(root.left, data);
			}
			return root;
		}

		public boolean isLeaf(Node root) {
			if (root == null) {
				return false;
			}
			return root.left == null && root.right == null;
		}

		public boolean isCompleteNew(Node root) {
			Queue<Node> items = new LinkedList<>();
			items.add(root);
			int size = 1;
			int currentLevel = -1;
			int sizeForCurrentLevel;
			boolean isComplete = true;
			while (!items.isEmpty()) {
				size = items.size();
				sizeForCurrentLevel = size;
				currentLevel++;
				boolean isLeftNullFound = false;
				while (size > 0) {
					Node c = items.poll();
					if ((isLeftNullFound && (c.left != null || c.right != null)) || (c.left == null && c.right != null)
							|| (sizeForCurrentLevel != (int) Math.pow(2, currentLevel)
									&& (c.left != null || c.right != null))) {

						isComplete = false;
						break;
					}
					if (c.left != null) {
						items.add(c.left);
					} else {
						isLeftNullFound = true;
					}

					if (c.right != null) {
						items.add(c.right);
					} else {
						isLeftNullFound = true;
					}
					size--;
				}
				if (!isComplete) {
					break;
				}

			}

			return isComplete;
		}

		public boolean isComplete(Node root) {
			Queue<Node> items = new LinkedList<>();
			items.add(root);
			int size = 1;
			boolean isComplete = true;
			while (!items.isEmpty()) {
				while (size > 0) {
					Node c = items.poll();
					if (c.left == null && c.right != null) {
						isComplete = false;
						break;
					}
					if (c.left != null && c.right == null && c.left.left != null) {
						isComplete = false;
						break;
					}
					if (c.left == null && c.right == null && !items.isEmpty()) {
						Node n = items.peek();
						if (n.left != null || n.right != null) {
							isComplete = false;
							break;
						}
					}
					if (c.left != null) {
						items.add(c.left);
					}
					if (c.right != null) {
						items.add(c.right);
					}
					size--;
				}
				if (!isComplete) {
					break;
				}
				size = items.size();
			}

			return isComplete;
		}
	}

	int headIndex = 0;

	public TreeNode sortedArrayToBST(final int[] A) {

		return convertToBST(A, A.length);
	}

	private TreeNode convertToBST(int[] A, int length) {
		if (length <= 0) {
			return null;
		}
		TreeNode left = convertToBST(A, length / 2);
		TreeNode root = new TreeNode(A[headIndex]);
		root.left = left;
		headIndex++;
		root.right = convertToBST(A, length - length / 2 - 1);
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

}
