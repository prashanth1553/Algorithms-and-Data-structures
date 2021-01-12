package com.smi;

import java.util.HashSet;
import java.util.Set;

public class WorkBreak {

	public void breakWord(Set<String> dictionary, String statement, int currentLength, String newStatement) {
		if (currentLength >= statement.length()) {
			System.out.println(newStatement);
		}
		String word = "";
		for (int i = currentLength; i < statement.length(); i++) {
			word = statement.substring(currentLength, i + 1);
			if (dictionary.contains(word)) {
				breakWord(dictionary, statement, i + 1, newStatement + " " + word);
			}
			word = "";
		}

	}

	public void breakWord2(Set<String> dictionary, String statement, int starIndex, int endIndex, String newStatement) {
		if (endIndex > statement.length() - 1) {
			return;
		}
		String sub = statement.substring(starIndex, endIndex + 1);
		boolean con = dictionary.contains(statement.substring(starIndex, endIndex + 1));
		if (con) {
			if (con && endIndex == statement.length() - 1) {
				System.out.println("Logic 2#: " + newStatement + " " + sub);
				return;
			}
			breakWord2(dictionary, statement, endIndex + 1, endIndex + 1, newStatement + " " + sub);
		}
		breakWord2(dictionary, statement, starIndex, endIndex + 1, newStatement);
	}

	public static void main(String args[]) {

		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i",
				"love", "ice", "cream" };

		Set<String> dic = new HashSet<>();
		for (String w : dictionary) {
			dic.add(w);
		}
		WorkBreak obj = new WorkBreak();
		String statement = "iloveicecreamandmango";
		obj.breakWord(dic, statement, 0, "");
		obj.breakWord2(dic, statement, 0, 0, "");
		System.out.println("## 2 ###");
		String statement1 = "ilovesamsungmobile";
		obj.breakWord(dic, statement1, 0, "");
		obj.breakWord2(dic, statement1, 0, 0, "");
	}

}
