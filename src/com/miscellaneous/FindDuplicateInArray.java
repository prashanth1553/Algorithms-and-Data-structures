package com.miscellaneous;

import java.util.List;

public class FindDuplicateInArray {

	public int repeatedNumber(final List<Integer> A) {
		if (A.size() <= 1) {
			return -1;
		}
		int slow = 0, fast = A.get(0);
		while (slow != fast) {
			slow = A.get(slow);
			fast = A.get(A.get(fast));
		}
		slow = 0;
		while (slow != fast) {

			slow = A.get(slow);
			fast = A.get(fast);
		}

		return slow;
	}
}
