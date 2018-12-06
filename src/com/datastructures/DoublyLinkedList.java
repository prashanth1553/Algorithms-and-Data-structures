package com.datastructures;

public class DoublyLinkedList<Item> {

	Node head;

	class Node {

		Node next, previous;
		Item value;

		public Node(Item value) {
			super();
			this.value = value;
		}

	}

	public void insert(Item value) {

		Node c = new Node(value);
		if (head == null) {
			head = c;
			return;
		}
		c.next = head;
		head.previous = c;

		head = c;
		
	
	}

}
