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
		String temp = null;
		if (currentItem != null) {
			temp = currentItem.item;
			currentItem = currentItem.next;
		}

		return temp;
	}

	public static void main(String args[]) {

		MyStackWithLinkedList obj = new MyStackWithLinkedList();
		System.out.println("*******" + obj.pop());
		obj.push("s");
		System.out.println("*******" + obj.pop());
		obj.push("a");
		obj.push("i");
		System.out.println("*******" + obj.pop());
		System.out.println("*******" + obj.pop());

	}
}
