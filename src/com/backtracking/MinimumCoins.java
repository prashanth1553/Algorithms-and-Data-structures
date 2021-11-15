package com.backtracking;

public class MinimumCoins {

	public static int minimumCoins(int amount, int[] denominations) {
		if (amount == 0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for (int d : denominations) {
			if (amount >= d) {
				int subResult = minimumCoins(amount - d, denominations);
				if (subResult != Integer.MAX_VALUE && subResult + 1 < ans) {
					ans = subResult + 1;
				}
			}
		}
		return ans;
	}

	public static int totalPossibleCombinations(int amount, int[] denominations, int currentIndex) {
		if (amount == 0) {
			return 1;
		} else if (amount < 0) {
			return 0;
		}
		if (currentIndex >= denominations.length) {
			return 0;
		}

		return totalPossibleCombinations(amount - denominations[currentIndex], denominations, currentIndex)
				+ totalPossibleCombinations(amount, denominations, currentIndex + 1);
	}

	public static void main(String args[]) {
		int coins[] = { 9, 6, 5, 1 };
		int V = 5;
		System.out.println("Minimum coins required are " + minimumCoins(V, coins));
		System.out.println("total combinations == " + totalPossibleCombinations(V, coins, 0));
	}
}
