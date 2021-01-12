package com.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;

public class PascalTriangle {

	public ArrayList<ArrayList<Integer>> solve(int A) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(A);
		for (int i = 0; i < A; i++) {
			ArrayList<Integer> currentList = new ArrayList<>();
			ArrayList<Integer> previousList = list.isEmpty() ? null : list.get(i - 1);
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					currentList.add(1);
				} else {
					int left = previousList.get(j - 1);
					int right = j >= previousList.size() ? 0 : previousList.get(j);
					currentList.add(left + right);
				}
			}
			list.add(currentList);
		}

		return list;

	}
}
