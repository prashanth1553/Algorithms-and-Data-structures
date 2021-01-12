package com.miscellaneous;

public class KthSmallestElementInTree {

	TreeNode head;

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

	public void put(int a) {
		head = put(head, a);
	}

	public TreeNode put(TreeNode head, int a) {
		if (head == null) {
			return new TreeNode(a);
		}
		if (head.val > a) {
			head.left = put(head.left, a);
		} else if (head.val < a) {
			head.right = put(head.right, a);
		}
		return head;
	}

	public int kthsmallest(TreeNode A, int B) {
		TreeNode node = kthsmallest1(A, B);
		if (node != null) {
			return node.val;
		}
		return 0;
	}

	int count;

	public TreeNode kthsmallest1(TreeNode A, int B) {
		if (A == null) {
			return null;
		}
		TreeNode node = kthsmallest1(A.left, B);
		if (count == B) {
			return node;
		} else if (count + 1 == B) {
			count++;
			return A;
		}
		count++;
		return kthsmallest1(A.right, B);
	}

	public static void main(String args[]) {
		KthSmallestElementInTree obj = new KthSmallestElementInTree();
		int array[] = { 5, 3, 2, -1, -1, -1 };
		for (int i : array) {
			obj.put(i);
		}
		System.out.println(obj.kthsmallest(obj.head, 1));
	}
}
