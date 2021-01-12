package com.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.Map.Entry;

public class LruCache<Key, Value> {

	Node head, tail;
	Map<Key, Node> entries = new HashMap<>();
	int capacity = 2;

	public LruCache(int capacity) {
		this.capacity = capacity;
	}

	private class Node {
		Key key;
		Value value;
		Node next, previous;

		public Node(Key key, Value value, Node next, Node previous) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
			this.previous = previous;
		}

	}

	public Value get(Key key) {
		Node n = entries.get(key);
		if (n != null) {
			deleteNode(n);
			addNode(n);
			return n.value;
		}
		return null;

	}

	public void put(Key key, Value value) {
		if (entries.containsKey(key)) {
			Node existing = entries.get(key);
			existing.value = value;
			deleteNode(existing);
			addNode(existing);
		} else {
			if (entries.size() == capacity) {
				entries.remove(tail.key);
				deleteNode(tail);
			}
			Node t = new Node(key, value, null, null);
			entries.put(key, t);
			addNode(t);
		}

	}

	private void deleteNode(Node node) {
		if (node.previous != null) {
			node.previous.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.previous = node.previous;
		} else {
			tail = node.previous;
		}

	}

	private void addNode(Node node) {
		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.previous = node;
			head = node;
		}

	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(",");
		for (Entry<Key, Node> entry : entries.entrySet()) {
			joiner.add("" + entry.getKey() + " " + entry.getValue().value);
		}
		return joiner.toString();
	}

	public static void main(String args[]) {
		LruCache<Integer, Integer> cache = new LruCache<Integer, Integer>(1);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.head.key);
		System.out.println(cache.get(1));
		System.out.println(cache.head.key);
		cache.put(3, 3);
		System.out.println(cache.toString());

	}
}
