package com.datastructures;

public class QueueWithArray {
	int capacity;
	int array[];
	int size;
	int front, rear;

	public QueueWithArray(int capacity) {
		array = new int[capacity];
		this.capacity = capacity;
		size = 0;
		front = 0;
		rear = 0;

	}

	public boolean isFull() {
		return size == capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(int value) {
		if (isFull()) {
			return;
		}
		rear = (rear + 1) % capacity;
		array[rear] = value;
		size++;
	}

	public int dequeue() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		int value = array[front];
		front = (front + 1) % capacity;
		size--;
		return value;

	}

	int front() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return this.array[this.front];
	}

	// Method to get rear of queue
	int rear() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return this.array[this.rear];
	}

	public static void main(String[] args)

	{
		QueueWithArray queue = new QueueWithArray(4);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);

		System.out.println(queue.dequeue() + " dequeued from queue\n");

		System.out.println("Front item is " + queue.front());

		System.out.println("Rear item is " + queue.rear());

		queue.enqueue(50);

		System.out.println("Front item is " + queue.front());

		System.out.println("Rear item is " + queue.rear());

		System.out.println(queue.dequeue() + " dequeued from queue\n");
		System.out.println(queue.dequeue() + " dequeued from queue\n");
		System.out.println(queue.dequeue() + " dequeued from queue\n");
		System.out.println(queue.dequeue() + " dequeued from queue\n");
		System.out.println(queue.dequeue() + " dequeued from queue\n");

	}

}