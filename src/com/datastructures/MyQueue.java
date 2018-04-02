package com.datastructures;

public class MyQueue {

	Node firstItem = null;
	Node lastItem = null;

	class Node {

		public Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}

		String value;

		Node next;
	}

	public void enqueue(String str) {

		Node newNode = new Node(str, null);
		if (firstItem == null) {
			firstItem = newNode;
		} else {
			if (firstItem.next == null) {
				firstItem.next = newNode;
			} else {
				if (lastItem == null) {
					lastItem = newNode;
				} else {
					lastItem.next = newNode;
				}

			}
		}
	}

	public String dequeue() {

		String str = firstItem.value;
		firstItem = firstItem.next;
		return str;

	}

	public static void main(String[] args) {
		MyQueue myStack = new MyQueue();
		myStack.enqueue("P");
		myStack.enqueue("r");
		myStack.enqueue("a");
		System.out.println(myStack.dequeue());
		myStack.enqueue("r");
		System.out.println(myStack.dequeue());
		System.out.println(myStack.dequeue());
		System.out.println(myStack.dequeue());
	}

}
