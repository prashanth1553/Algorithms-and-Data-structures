package com.smi.binarytrees;

public class BBSTToDoublyLinkedList {

	static class BBST {

		Node head;

		public void put(int data) {
			head = put(head, data);
		}

		public Node put(Node head, int data) {
			if (head == null) {
				Node t = new Node();
				t.data = data;
				return t;
			}
			if (head.data > data) {
				head.left = put(head.left, data);
			} else if (head.data < data) {
				head.rigt = put(head.rigt, data);

			}
			return head;
		}

	}

	static class Node {

		int data;
		Node left, rigt;

	}

	public static Node listHead = new Node();
	public static Node tempListHead = listHead;

	public static void covertBBSTtoDL(Node head) {
		if (head == null) {
			return;
		}
		covertBBSTtoDL(head.left);

		Node headR = head.rigt;
		head.rigt = null;
		tempListHead.rigt = head;
		head.left = tempListHead;
		tempListHead = tempListHead.rigt;

		covertBBSTtoDL(headR);

	}

	public static void main(String args[]) {
		BBST bbst = new BBST();
		bbst.put(4);
		bbst.put(3);
		bbst.put(5);
		bbst.put(6);
		bbst.put(7);
		bbst.put(1);
		bbst.put(2);

		covertBBSTtoDL(bbst.head);

		while (listHead != null) {
			System.out.println(listHead.data);
			listHead = listHead.rigt;
		}

	}

}
