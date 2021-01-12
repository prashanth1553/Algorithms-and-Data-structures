package com.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

public class LruCacheInterviewBit {

	private int capacity;
	private Node head, tail;
	private Map<Integer, Node> map;

	public LruCacheInterviewBit(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, LruCacheInterviewBit.Node>(capacity);
	}

	class Node {
		int value;
		int key;
		Node previous, next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	private void deleteNode(Node node) {
		if (node.previous != null) {
			node.previous.next = node.next;
		} else {
			head = node.next;
			if (head != null) {
				head.previous = null;
			}
		}
		if (node.next != null) {
			node.next.previous = node.previous;
		} else {
			tail = node.previous;
			if (tail != null) {
				tail.next = null;
			}
		}

	}

	private void addNode(Node node) {
		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.previous = node;
			head = node;
			head.previous = null;
		}
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			deleteNode(n);
			addNode(n);
			return n.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			n.value = value;
			deleteNode(n);
			addNode(n);
		} else {
			if (map.size() == capacity) {
				map.remove(tail.key);
				deleteNode(tail);
			}
			Node n2 = new Node(key, value);
			addNode(n2);
			map.put(key, n2);
		}

	}

	public static void main(String args[]) {
		String s = "95,11,S,1,1,G,11,G,11,S,3,10,G,10,S,3,12,S,1,15,S,4,12,G,15,S,8,6,S,5,3,G,2,G,12,G,10,S,11,5,G,7,S,5,1,S,15,5,G,2,S,13,8,G,3,S,14,2,S,12,11,S,7,10,S,5,4,G,9,G,2,S,13,5,S,10,14,S,9,11,G,5,S,13,11,S,8,12,G,10,S,5,12,G,8,G,11,G,8,S,9,11,S,10,6,S,7,12,S,1,7,G,10,G,9,G,15,G,15,G,3,S,15,4,G,10,G,14,G,10,G,12,G,12,S,14,7,G,11,S,9,10,S,6,12,S,14,11,G,3,S,7,5,S,1,14,S,2,8,S,11,12,S,8,4,G,3,S,13,15,S,1,4,S,5,3,G,3,G,9,G,14,G,9,S,13,10,G,14,S,3,9,G,8,S,3,5,S,6,4,S,10,3,S,11,13,G,8,G,4,S,2,11,G,2,G,9,S,15,1,G,9,S,7,8,S,4,3,G,3,G,1,S,8,4,G,13,S,1,2,G,3";
		String[] input = s.split(",");
		LruCacheInterviewBit cache = new LruCacheInterviewBit(Integer.parseInt(input[1]));
		for (int i = 2; i < input.length; i++) {
			if ("S".equals(input[i])) {
				cache.set(Integer.parseInt("" + input[i + 1]), Integer.parseInt("" + input[i + 2]));
				i = i + 2;
			} else {
				int g = cache.get(Integer.parseInt("" + input[i + 1]));
				System.out.print(g + " ");
				i++;
			}
		}
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(",");
		for (Entry<Integer, Node> entry : map.entrySet()) {
			joiner.add("" + entry.getKey() + " " + entry.getValue().value);
		}
		return joiner.toString();
	}
}
