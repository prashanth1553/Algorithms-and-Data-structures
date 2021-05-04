package com.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddOneToNumber {

	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int size = A.size();
		if (A.isEmpty()) {
			return A;
		}
		List<Integer> sum = new ArrayList<Integer>(A.size() + 1);
		sum.add((1 + A.get(size - 1)) % 10);
		int carry = (1 + A.get(size - 1)) / 10;
		for (int i = size - 2; i >= 0; i--) {
			int sumT = A.get(i) + carry;
			sum.add(sumT % 10);
			carry = sumT / 10;
		}
		if (carry != 0) {
			sum.add(carry);
		}
		for (int i = sum.size() - 1; i >= 0; i--) {
			if (sum.get(i).equals(0)) {
				sum.remove(i);
			} else {
				break;
			}
		}
		for (int i = sum.size() - A.size(); i > 0; i--) {
			A.add(0);
		}
		int i = 0;
		for (int j = sum.size() - 1; j >= 0; j--) {
			if (j >= A.size()) {
				A.add(sum.get(j));
			} else {
				A.set(i, sum.get(j));
			}
			i++;
		}
		i--;
		for (int j = A.size() - 1; j > i; j--) {
			A.remove(j);
		}
		return A;
	}

	public static void main(String args[]) {
		AddOneToNumber obj = new AddOneToNumber();
		ArrayList<Integer> A = (ArrayList<Integer>) Stream.of(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9)
				.collect(Collectors.toList());
		obj.plusOne(A);
		System.out.println(A.toString());
		// [3, 7, 6, 4, 0, 5, 5, 6]

	}

}
