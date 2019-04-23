package com.smi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RectangularAreaUnderHistograh {

	public static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testCases = Integer.parseInt(bufferedReader.readLine().trim());
		for (int t = 0; t < testCases; t++) {
			int rectangles = Integer.parseInt(bufferedReader.readLine().trim());
			String areaS[] = bufferedReader.readLine().trim().split(" ");
			int rectArea[] = new int[rectangles];
			for (int i = 0; i < rectangles; i++) {
				rectArea[i] = Integer.parseInt(areaS[i]);
			}
			Stack<Integer> tops = new Stack<>();
			int i = 0;
			int maxArea = 0;
			int topArea = 0;
			int currentTop = 0;
			while (i < rectangles) {
				if (tops.isEmpty() || rectArea[i] >= rectArea[tops.peek()]) {
					tops.push(i);
					i++;
				} else {
					currentTop = tops.pop();
					topArea = rectArea[currentTop] * (tops.isEmpty() ? i : i - tops.peek() - 1);
					maxArea = Math.max(topArea, maxArea);
				}

			}
			while (!tops.empty()) {
				currentTop = tops.pop();
				topArea = rectArea[currentTop] * (tops.isEmpty() ? i : i - tops.peek() - 1);
				maxArea = Math.max(topArea, maxArea);
			}
			System.out.println(maxArea);

		}
	}

}
