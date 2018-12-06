package com.datastructures;

public class CircularLinkedList<Item> {

	Node head, tail;

	int size = 0;

	class Node {

		Node next;
		Item value;

		public Node(Item value) {
			this.value = value;
		}
	}

	public void put(Item value) {

		size++;
		Node newNode = new Node(value);
		if (tail == null) {
			head = tail = newNode;
			head.next = tail;
			tail.next = head;
			return;
		}

		newNode.next = head;
		tail.next = newNode;
		head = newNode;

	}

	public Item delete() {
		if (head == null) {
			return null;
		}
		Item v = head.value;
		size--;
		if (size == 0) {
			tail = head = null;
		} else {
			head = head.next;
			tail.next = head;
		}

		return v;

	}

	public Item get() {
		if (head == null) {
			return null;
		}

		Item value = head.value;

		head = head.next;
		if (head == null) {
			tail = null;
		} else {
			tail.next = head;
		}

		return value;
	}

}
