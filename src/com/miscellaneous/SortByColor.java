package com.miscellaneous;

import java.util.ArrayList;

public class SortByColor {

	public void sortColors(ArrayList<Integer> a) {
		int f = sort(a, 0, 2, 0, a.size() - 1);
		if (f < a.size()) {
			sort(a, 1, 2, f, a.size() - 1);
		}

	}

	private int sort(ArrayList<Integer> a, int min, int max, int p1, int p2) {
		// 2, 1, 1, 1
		while (p1 < p2) {
			if (a.get(p1) == min) {
				p1++;
			} else if (a.get(p2) != min) {
				p2--;
			} else {
				int t = a.get(p1);
				a.set(p1, a.get(p2));
				a.set(p2, t);
				p1++;
				p2--;
			}
		}
		if (a.get(p1) == min) {
			return p1 + 1;
		} else {
			return p1;
		}

	}

}
