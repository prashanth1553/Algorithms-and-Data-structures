package com.miscellaneous;

import java.util.ArrayList;

public class RemoveElementFromArray {

	public int removeElement(ArrayList<Integer> a, int b) {
		if (a.size() <= 0) {
			return 0;
		}
		int p1 = 0, p2 = 0;
		while (p2 < a.size()) {
			int p2E = a.get(p2);
			if (b == p2E) {
				p2++;
			} else {
				a.set(p1, p2E);
				p1++;
				p2++;
			}
		}

		return p1;
	}
}
