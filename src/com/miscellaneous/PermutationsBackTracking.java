package com.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermutationsBackTracking {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
		ArrayList<Integer> currentList = new ArrayList<>();
		Set<Integer> addedIndexList = new HashSet<>();
		permute(finalList, A, currentList, addedIndexList);
		return finalList;
	}

	public void permute(ArrayList<ArrayList<Integer>> finalList, ArrayList<Integer> A, ArrayList<Integer> currentList,
			Set<Integer> addedIndexList) {
		if (A.size() == currentList.size()) {
			finalList.add(currentList);
			return;
		}
		for (int i = 0; i < A.size(); i++) {
			if (!addedIndexList.contains(i)) {
				ArrayList<Integer> currentListT = new ArrayList<>(currentList);
				currentListT.add(A.get(i));
				Set<Integer> addedIndexListT = new HashSet<>(addedIndexList);
				addedIndexListT.add(i);
				permute(finalList, A, currentListT, addedIndexListT);
			}
		}

	}

	public static void main(String args[]) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		PermutationsBackTracking obj = new PermutationsBackTracking();
		ArrayList<ArrayList<Integer>> finalList = obj.permute(A);
		System.out.println(finalList.toString());
		System.out.println(finalList.size());
	}

}
