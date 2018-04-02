package com.datastructures;

public class MyStack {

	Node currentItem;

	class Node {

		public Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}

		String value;

		Node next;
	}

	public void push(String str) {

		Node newNode = new Node(str, currentItem);
		currentItem = newNode;

	}

	public String pop() {

		String str = currentItem.value;
		currentItem = currentItem.next;
		return str;

	}
	
	public static void main(String [] args){
		MyStack myStack = new MyStack();
		myStack.push("P");
		myStack.push("r");
		myStack.push("a");
		System.out.println(myStack.pop());
		myStack.push("r");
		System.out.println(myStack.pop());
	}

}
