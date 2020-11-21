package com.smi;

public class GivenNumberToWord {

	public static void main(String args[]) {
		GivenNumberToWord obj = new GivenNumberToWord();
		System.out.println(obj.numberToWord(1000000));

	}

	public String numberToWord(int input) {
		String word = "";
		if (0 >= input && input <= 10) {
			return getWordForSingleDigit(input);
		}

		if (11 >= input && input <= 20) {
			return getWordForTwoDigits(input);
		}
		int digits[] = getArrayOfNumber(input);
		int numberOfDigits = digits.length;
		for (int i = 0; i < digits.length; i++) {
			if (i != numberOfDigits - 1 && isAllZero(i + 1, digits)) {
				int currentDigit = digits[i];
				return word + " " + getWordBasedLength(i, currentDigit, digits.length - i);
			}

		}

		return word;

	}

	public int[] getArrayOfNumber(int input) {
		int digits[] = new int[("" + input).length()];
		int index = digits.length - 1;
		while (input != 0) {
			digits[index--] = input % 10;
			input = input / 10;
		}

		return digits;
	}

	public String getWordBasedLength(int index, int digit, int length) {
		switch (length) {
		case 2:
			return "ten";
		case 3:
			return getWordForSingleDigit(digit) + " " + "hundred";
		case 4:
			return getWordForSingleDigit(digit) + " " + "thousand";
		case 5:
			return getWordForTwoDigits(Integer.parseInt("" + digit + 0)) + " " + "thousand";
		case 6:
			return getWordForSingleDigit(digit) + " " + "lakh";
		case 7:
			return getWordForTwoDigits(Integer.parseInt("" + digit + 0)) + " " + "lakh";

		}

		return "*length*";
	}

	public boolean isAllZero(int from, int array[]) {
		for (int i = from; i < array.length; i++) {
			if (array[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public String getWordForSingleDigit(int number) {

		switch (number) {
		case 0:
			return "zero";
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		default:
			return "*one*";
		}

	}

	public String getWordForTwoDigits(int number) {

		switch (number) {
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirthyn";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		case 20:
			return "twenty";
		case 30:
			return "thirty";
		case 40:
			return "fourty";
		case 50:
			return "fifty";
		case 60:
			return "sixty";
		case 70:
			return "fifty";
		case 80:
			return "sixty";
		case 90:
			return "ninty";
		default:
			return "*two*";
		}

	}
}
