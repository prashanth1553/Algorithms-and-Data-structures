package com.strings;

import java.util.Arrays;

/* Sort an array of N integers between 0 and R-1 */
public class KeyIndexedCounting {

	public void keyIndexedSort(int[] a, int R) {

		int[] count = new int[R + 1];
		for (int i = 0; i < a.length; i++) {
			count[a[i] + 1]++;
		}
		System.out.println(Arrays.toString(count));
		for (int i = 0; i < R; i++) {
			count[i + 1] += count[i];
		}
		System.out.println(Arrays.toString(count));
		int[] aux = new int[a.length];
		for (int i = 0; i < a.length; i++) {

			aux[count[a[i]]++] = a[i];

		}
		for (int i = 0; i < a.length; i++) {
			a[i] = aux[i];
		}

	}
	
	public static void main(String args []){
		
		int a[] = { 3, 0, 2, 5, 5, 1, 3, 1, 5, 1, 4, 0 };
		KeyIndexedCounting obj = new KeyIndexedCounting();
		obj.keyIndexedSort(a, 6);
		System.out.println(Arrays.toString(a));
	}
			
}
