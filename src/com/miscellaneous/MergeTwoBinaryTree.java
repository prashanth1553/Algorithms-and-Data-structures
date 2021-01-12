package com.miscellaneous;

public class MergeTwoBinaryTree {

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

	public TreeNode solve(TreeNode A, TreeNode B) {
		return merge(A, B);
	}

	public TreeNode merge(TreeNode A, TreeNode B) {
		if (A == null) {
			return B;
		} else if (B == null) {
			return A;
		} else {
			A.val += B.val;
			A.left = merge(A.left, B.left);
			A.right = merge(A.right, B.right);

		}
		return A;
	}

}
