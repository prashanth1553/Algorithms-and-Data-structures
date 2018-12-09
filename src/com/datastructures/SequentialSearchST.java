package com.datastructures;

public class SequentialSearchST<Key, Value> {

	private Node head;
	private int n;

	class Node {
		Key key;
		Value value;
		Node next;

		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public Value get(Key key) {
		for (Node x = head; x != null; x = x.next) {
			if (x.equals(key)) {
				return x.value;
			}
		}
		return null;
	}

	public void put(Key key, Value value) {
		for (Node x = head; x != null; x = x.next) {
			if (x.equals(key)) {
				x.value = value;
				return;
			}
		}
		head = new Node(key, value, head);
		n++;
	}

	public void delete(Key key) {
		head = delete(head, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		if (x.key.equals(key)) {
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	public void delete1(Key key) {
		if(head != null && head.key.equals(key)) {
			head = head.next;
			return;
		}
		Node previous = head;
		for (Node x = head; x != null; x = x.next) {
			if (x.key.equals(key)) {
				previous.next = x.next;
				break;
			}
			previous = x;
		}

	}
}
