package com.datastructures;

public class MyQueue<Item> {

	private Node first, last;

	class Node {

		public Node(Item value, Node next) {
			this.value = value;
			this.next = next;
		}

		Item value;

		Node next;
	}

	public void enqueue(Item value) {

		Node newNode = new Node(value, null);
		if (last == null) {
			first = last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}

	}

	public Item dequeue() {
		if (first == null) {
			return null;
		}
		Item value = first.value;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return value;
	}

	public static void main(String[] args) {
		MyQueue<String> myStack = new MyQueue();
		myStack.enqueue("P");
		myStack.enqueue("r");
		myStack.enqueue("a");
		System.out.println(myStack.dequeue());
		myStack.enqueue("r");
		System.out.println(myStack.dequeue());
		System.out.println(myStack.dequeue());
	}

}
