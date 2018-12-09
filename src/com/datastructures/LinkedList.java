package com.datastructures;

public class LinkedList<Item> {

	Node head;

	class Node {

		Node next;
		Item value;

		public Node(Item value) {
			this.value = value;
		}
	}

	private void add(Item value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;

	}

	public void insertAfter(Node prev_node, Item value) {
		Node newNode = new Node(value);
		newNode.next = prev_node.next;
		prev_node.next = newNode;

	}

	public void append(Item value) {

		if (head == null) {
			head = new Node(value);
			return;
		}
		Node x = head;
		while (x.next != null) {
			x = x.next;
		}
		x.next = new Node(value);

	}

	public void delete(Item value) {

		if (head != null && head.equals(value)) {
			head = head.next;
			return;
		}
		Node previous = head;
		Node x = head;
		while (x != null && !x.value.equals(value)) {
			previous = x;
			x = x.next;
		}

		if (x != null) {
			previous.next = x.next;
		}

	}

}
