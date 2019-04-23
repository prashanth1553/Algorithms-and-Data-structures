package com.smi;

public class CombinationsOfAString {

	public static void main(String args[]) {

		String input = "abc";
		// subSets1(input, 0, "");
	//	subSets(input, -1, "");
		permute(input, 1,  input.length() - 1, 0);
	}

	public static void subSets1(String input, int index, String subSet) {
		if (index == input.length()) {
			System.out.println(subSet);
			return;
		}
		subSets1(input, index + 1, subSet);
		subSets1(input, index + 1, subSet + input.charAt(index));
	}

	public static void subSets(String input, int index, String subSet) {
		System.out.println(subSet);
		for (int i = index + 1; i < input.length(); i++) {
			subSet += input.charAt(i);
			subSets(input, i, subSet);
			subSet = subSet.substring(0, subSet.length() - 1);
		}
	}

	public static void permute(String input, int radix, int length, int index) {
		if (index == radix) {
			System.out.println(input);
			return;
		}
		for (int i = index; i <= length; i++) {
			input = swap(input, index, i);
			permute(input, radix,  length, index + 1);
			input = swap(input, index, i);
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
