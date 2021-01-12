package com.miscellaneous;

import java.util.ArrayList;
import javax.management.timer.Timer;

public class MinimumLightsToActivate {

	public int solve(ArrayList<Integer> A, int B) {

		int ans = 0;
		int i = 0;
		int nextIndexFromLastLighetingIndex = 0;
		int size = A.size();
		if (B >= size) {
			return 1;
		}

		while (i < size) {
			boolean isGivingRangeLigheted = false;
			for (int x = Math.min(i + B - 1, size - 1); x >= nextIndexFromLastLighetingIndex; x--) {
				if (A.get(x) == 1) {
					ans++;
					isGivingRangeLigheted = true;
					i = x + B;
					nextIndexFromLastLighetingIndex = x + 1;
					break;
				}
			}
			if (i >= size) {
				return ans;
			}
			if (!isGivingRangeLigheted) {
				return -1;
			}
		}

		return ans;
	}

	public static void main(String args[]) {
		System.out.println("****" + new Object() {
		}.getClass().getEnclosingMethod());
		MinimumLightsToActivate obj = new MinimumLightsToActivate();
		obj.test();
	}

	public void test() {
		System.out.println("****" + new Object() {
		}.getClass().getEnclosingMethod());

		System.out.println("Class name  == " + getClass());
		System.out.println("Class name == " + getClass().getName());
		Timer t = new Timer();
	}
}
