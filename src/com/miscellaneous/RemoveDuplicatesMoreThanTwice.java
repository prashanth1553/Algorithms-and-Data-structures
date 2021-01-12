package com.miscellaneous;

import java.util.ArrayList;

public class RemoveDuplicatesMoreThanTwice {

	public int removeDuplicates(ArrayList<Integer> a) {
		if (a.isEmpty()) {
			return 0;
		}
		if (a.size() <= 2) {
			return a.size();
		}
		int start = 0;
		int mover = 0;
		while (mover < a.size()) {
			int e = a.get(mover);
			mover++;
			int count = 0;
			while (mover < a.size() && e == a.get(mover)) {
				mover++;
				count++;
			}
			int min = Math.min(count, 1);
			for (int i = 0; i <= min; i++) {
				a.set(start++, e);
			}
		}

		return start;
	}
}
