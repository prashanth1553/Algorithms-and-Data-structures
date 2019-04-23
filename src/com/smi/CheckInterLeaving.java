package com.smi;

public class CheckInterLeaving {

	public static boolean checkInterleaving(String s1, String s2, String result) {

		if (result.length() != (s1.length() + s2.length())) {
			return false;
		}

		int p1 = 0, p2 = 0;
		for (int i = 0; i < result.length(); i++) {
			if (p1 < s1.length() && result.charAt(i) == s1.charAt(p1)) {
				p1++;
			} else if (p2 < s2.length() && result.charAt(i) == s2.charAt(p2)) {
				p2++;
			} else {
				return false;
			}

		}

		return (p1 == s1.length() && p2 == s2.length());
	}

	public static void main(String args[]) {
		System.out.println(checkInterleaving("nkb", "gl", "glnkb"));
		System.out.println(checkInterleaving("nkb", "gl", "glnkd"));
	}
}
