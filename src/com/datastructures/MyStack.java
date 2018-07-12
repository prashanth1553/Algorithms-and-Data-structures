package com.datastructures;

public class MyStack<Item> {

	Node currentItem;

	class Node {

		public Node(Item value, Node next) {
			this.value = value;
			this.next = next;
		}

		Item value;

		Node next;
	}

	public void push(Item str) {

		Node newNode = new Node(str, currentItem);
		currentItem = newNode;

	}

	public Item pop() {

		Item str = currentItem.value;
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
