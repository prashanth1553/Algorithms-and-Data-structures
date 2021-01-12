package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveHalfNodes {

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

	public TreeNode solve(TreeNode A) {
		return removeHalfNode(A);
	}

	public TreeNode removeHalfNode(TreeNode head) {
		if (head == null) {
			return null;
		}
		if (head.left == null && head.right == null) {
			return head;
		} else if (head.left == null) {
			return removeHalfNode(head.right);
		} else if (head.right == null) {
			return removeHalfNode(head.left);
		} else {
			head.left = removeHalfNode(head.left);
			head.right = removeHalfNode(head.right);
			return head;
		}

	}

	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int p1 = a.size() - 1, p2 = b.size() - 1;
		a.ensureCapacity( b.size());
		for (int i = 0; i < b.size(); i++) {
			a.add(0);
		}
		int h = a.size() - 1;
		int aE, bE;
		while (p1 >= 0 && p2 >= 0) {
			aE = a.get(p1);
			bE = b.get(p2);
			if (bE >= aE) {
				a.set(h, bE);
				p2--;
			} else {
				a.set(h, aE);
				p1--;
			}
			h--;
		}
		while (p2 >= 0) {
			a.add(h, b.get(p2));
			h--;
			p2--;
		}

	}

	public static void main(String args[]) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(-2);
		b.add(-2);
		RemoveHalfNodes obj = new RemoveHalfNodes();
		obj.merge(a, b);
		System.out.println(a.toString());
	}
}
