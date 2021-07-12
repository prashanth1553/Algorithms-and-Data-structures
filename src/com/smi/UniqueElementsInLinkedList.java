package com.smi;

public class UniqueElementsInLinkedList {

	private Node head;
	private int size = 0;

	class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	public void add(int data) {
		head = new Node(data, head);
		size++;
	}

	public int remove() {
		if (head != null) {
			int d = head.data;
			head = head.next;
			return d;
		}
		return -1;
	}

	private void printList(Node h) {
		while (h != null) {
			System.out.println(h.data);
			h = h.next;
		}

	}

	public Node uniqueElements() {
		Node dummy = new Node(-1, null);
		Node temp = dummy;
		boolean isDuplicateFound = false;
		while (head != null) {
			while (head.next != null && head.data == head.next.data) {
				isDuplicateFound = true;
				head = head.next;
			}
			if (!isDuplicateFound) {
				temp.next = head;
				temp = temp.next;
			}
			head = head.next;
			isDuplicateFound = false;
		}

		return dummy.next;
	}

	private Node reverse(Node curr, Node prev) {
		if (curr.next == null) {
			curr.next = prev;
			head = curr;
			return head;
		}
		Node t = curr.next;
		curr.next = prev;
		reverse(t, curr);
		return head;
	}

	public static void main(String args[]) {
		UniqueElementsInLinkedList obj = new UniqueElementsInLinkedList();
		obj.add(1);
//		obj.add(2);
//	//	obj.printList(obj.uniqueElements());
//		obj.add(3);
//		obj.add(4);
//		obj.add(5);
		obj.printList(obj.uniqueElements());
	}

}
