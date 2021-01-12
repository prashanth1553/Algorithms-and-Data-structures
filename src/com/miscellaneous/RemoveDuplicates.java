package com.miscellaneous;

import java.util.ArrayList;

public class RemoveDuplicates {

	public int removeDuplicates(ArrayList<Integer> a) {
		if (a.size() <= 1) {
			return a.size();
		}
		int currentIndex = 0;
		for (int i = 1; i < a.size(); i++) {
			if (!a.get(currentIndex).equals(a.get(i))) {
				a.set(++currentIndex, a.get(i));
			}
		}
		return currentIndex + 1;
	}

	public static void main(String args[]) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		a.add(1);
		RemoveDuplicates obj = new RemoveDuplicates();

		System.out.println(obj.removeDuplicates(a));
		System.out.println(a.toString());
	}

}
