package com.smi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StockSpan {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int size = Integer.parseInt(bufferedReader.readLine().trim());
			String items[] = bufferedReader.readLine().trim().split(" ");
			Stack<Integer> most = new Stack<>();
			most.push(0);
			writer.write(1 + " ");
			for (int i = 1; i < size; i++) {
				int e = Integer.parseInt(items[i]);
				while (!most.isEmpty() && Integer.parseInt(items[most.peek()]) <= e) {
					most.pop();
				}
				int result = most.isEmpty() ? i + 1 : (i - most.peek());
				writer.write(result + " ");
				most.push(i);
			}
			writer.write("\n");
		}
		writer.flush();
	}
}
