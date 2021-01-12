package com.miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

	public void setZeroes1(ArrayList<ArrayList<Integer>> a) {
		if (a.isEmpty() || a.get(0).isEmpty()) {
			return;
		}
		int m = a.size(), n = a.get(0).size();
		int r1 = 0, c1 = 0;
		for (int i = 0; i < n; i++) {
			if (a.get(0).get(i) == 0) {
				r1 = 1;
				break;
			}
		}

		for (int i = 0; i < m; i++) {
			if (a.get(i).get(0) == 0) {
				c1 = 1;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a.get(i).get(j) == 0) {
					a.get(0).set(j, 0);
					a.get(i).set(0, 0);
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
					a.get(i).set(j, 0);
				}

			}
		}
		if (r1 == 1) {
			for (int j = 0; j < n; j++) {
				a.get(0).set(j, 0);
			}
		}
		if (c1 == 1) {
			for (int i = 0; i < m; i++) {
				a.get(i).set(0, 0);
			}
		}

	}

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		if (a.isEmpty() || a.get(0).isEmpty()) {
			return;
		}
		int m = a.size(), n = a.get(0).size();
		Set<Integer> row = new HashSet<>();
		Set<Integer> columns = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a.get(i).get(j) == 0) {
					row.add(i);
					columns.add(j);
				}
			}
		}
		for (int r : row) {
			for (int j = 0; j < n; j++) {
				a.get(r).set(j, 0);
			}

		}
		for (int c : columns) {
			for (int i = 0; i < m; i++) {
				a.get(i).set(c, 0);
			}
		}

	}

}
