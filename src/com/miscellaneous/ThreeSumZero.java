package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ThreeSumZero {
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
		Collections.sort(A);
		for (int i = 0; i < A.size(); i++) {
			if (i > 0 && A.get(i).equals(A.get(i - 1))) {
				continue;
			}
			int ithE = A.get(i);
			int j = i + 1, k = A.size() - 1;
			while (j < k) {
				long sum = 0l + ithE + A.get(j) + A.get(k);
				if (sum == 0) {
					ArrayList<Integer> current = new ArrayList<Integer>();
					current.add(ithE);
					current.add(A.get(j));
					current.add(A.get(k));
					answer.add(current);
					j++;
					k--;
					while (j < k && A.get(j) == A.get(j - 1)) {
						j++;
					}
					while (j < k && A.get(k) == A.get(k + 1)) {
						k--;
					}

				} else if (sum > 0) {
					k--;
				} else {
					j++;
				}
			}

		}

		return answer;

	}

	public static void main(String args[]) {

		Character array[] = { '1', '4', '1', '4' };
		int array1[] = { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };
		Arrays.sort(array1);
		System.out.println(Arrays.toString(array1));

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2147483647);
		a.add(-2147483648);
		a.add(-2147483648);
		a.add(0);
		a.add(1);
		ThreeSumZero obj = new ThreeSumZero();

		System.out.println(obj.threeSum(a));
		List<Student> list = new ArrayList();
		Map<Integer, Integer> keyToCount = list.stream().collect(Collectors.toMap(Student::getValue, i -> 1,
				(existing, replacement) -> (existing + 1), LinkedHashMap::new));

		Character nonR = Arrays.stream(array)
				.collect(
						Collectors.toMap(j -> j, i -> 1, (existing, replacement) -> (existing + 1), LinkedHashMap::new))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().orElse(null).getKey();
		System.out.println("nonR ====== " + nonR);

		// System.out.println(first);
		Supplier<LinkedHashMap<Integer, Integer>> supplier = () -> new LinkedHashMap();
		list.stream().collect(
				Collectors.toMap(Student::getValue, i -> 1, (existin, newV) -> existin + 1, () -> new LinkedHashMap()));

	}

	static class Student {
		Integer value;

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

	}

}
