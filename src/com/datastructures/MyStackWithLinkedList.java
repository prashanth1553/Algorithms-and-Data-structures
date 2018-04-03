package com.datastructures;

public class MyStackWithLinkedList {

	Node currentItem = null;

	class Node {

		String item;
		Node next;
	}

	public boolean isEmpty() {
		return currentItem == null;
	}

	public void push(String s) {

		Node temp = currentItem;
		currentItem = new Node();
		currentItem.item = s;
		currentItem.next = temp;
	}

	public String pop() {
		String temp = currentItem.item;
		currentItem = currentItem.next;
		return temp;
	}
}
