package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContainerWithMostWater {

	public int maxArea(List<Integer> A) {
		int maximumArea = 0;
		int start = 0;
		int end = A.size() - 1;
		while (start < end) {
			int minHeight = Math.min(A.get(start), A.get(end));
			int currArea = minHeight * (end - start);
			maximumArea = Math.max(maximumArea, currArea);
			if (A.get(start) <= A.get(end)) {
				start++;
			} else {
				end--;
			}
		}
		return maximumArea;
	}

	public static void main(String args[]) {
		int arr[] = { 5, 1, 2, 1, 100, 1, 1, 1, 1, 1, 1, 1, 1, 4 };
		ArrayList<Integer> list = (ArrayList<Integer>) IntStream.of(arr).boxed().collect(Collectors.toList());
		System.out.println("Size = " + list.size());
		ContainerWithMostWater obj = new ContainerWithMostWater();
		System.out.println(obj.maxArea(list));
	}

}
