package com.datastructures;

public class MyStackWithArrayImplementation {

	int present = 0;
	String[] items = new String[8];

	public void push(String s) {
		items[present++] = s;
	}

	public String pop() {
		String temp = items[--present];
		items[present] = null;
		return temp;
	}

	/*public static void main(String args[]) {

		MyStackWithArrayImplementation obj = new MyStackWithArrayImplementation();
		obj.push("s");
		System.out.println("*******" + obj.pop());
		obj.push("a");
		obj.push("i");
		System.out.println("*******" + obj.pop());
		System.out.println("*******" + obj.pop());

	}*/
	
	public boolean isEmpty() {
		return present == 0;
	}

}
