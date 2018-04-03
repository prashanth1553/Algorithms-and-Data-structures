package com.datastructures;

public class MyQueueWith2Stocks {

	private MyStackWithArrayImplementation stack1;
	private MyStackWithArrayImplementation stack2;

	public MyQueueWith2Stocks() {
		stack1 = new MyStackWithArrayImplementation();
		stack2 = new MyStackWithArrayImplementation();
	}

	public void enque(String s) {
		stack1.push(s);
	}

	public String deque() {

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public static void main(String args[]) {
		MyQueueWith2Stocks o = new MyQueueWith2Stocks();
		o.enque("p");
		o.enque("r");
		o.enque("a");
		System.out.println("de **" + o.deque());
		System.out.println("de **" + o.deque());
		System.out.println("de **" + o.deque());
		o.enque("a");
		o.enque("p");
		o.enque("r");
		System.out.println("de **" + o.deque());
		System.out.println("de **" + o.deque());

	}

}
