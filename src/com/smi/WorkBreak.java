package com.smi;

import java.util.HashSet;
import java.util.Set;

public class WorkBreak {

	public void breakWord(Set<String> dictionary, String statement, int currentLength, String newStatement) {
		if (currentLength >= statement.length()) {
			System.out.println(newStatement);
		}
		String word = "";
		int previousL = newStatement.length();
		for (int i = currentLength; i < statement.length(); i++) {
			word = statement.substring(currentLength, i + 1);
			if (dictionary.contains(word)) {
				newStatement = newStatement + " " + word;
				breakWord(dictionary, statement, i + 1, newStatement);
				newStatement = newStatement.substring(0, previousL);
			}
			word = "";
		}

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
		System.out.println("## 2 ###");
		String statement1 = "ilovesamsungmobile";
		obj.breakWord(dic, statement1, 0, "");
	}

}
