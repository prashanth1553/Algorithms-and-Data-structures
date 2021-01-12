package com.datastructures;

public class MyStackWithLinkedList<T> {

	Node currentItem = null;

	class Node {

		T item;
		Node next;
	}

	public boolean isEmpty() {
		return currentItem == null;
	}

	public void push(T s) {

		Node temp = currentItem;
		currentItem = new Node();
		currentItem.item = s;
		currentItem.next = temp;
	}

	public T pop() {
		T temp = null;
		if (currentItem != null) {
			temp = currentItem.item;
			currentItem = currentItem.next;
		}

		return temp;
	}

	public static void main(String args[]) {

		MyStackWithLinkedList<String> obj = new MyStackWithLinkedList<String>();
		System.out.println("*******" + obj.pop());
		obj.push("s");
		System.out.println("*******" + obj.pop());
		obj.push("a");
		obj.push("i");
		System.out.println("*******" + obj.pop());
		System.out.println("*******" + obj.pop());

	}
}
