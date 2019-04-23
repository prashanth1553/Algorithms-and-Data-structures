package com.smi;

import java.util.Scanner;

public class TrailingZeros {
	private static final Scanner scanner = new Scanner(System.in);

	 public static void main(String[] args) {
	        /*
	         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
	         * class should be named Solution.
	         */
	        int t = scanner.nextInt();
	        for (int i = 0; i < t; i++) {
	            long factorial = scanner.nextLong();
	            if (factorial == 0 || factorial == 1) {
	                System.out.println(0);
	                continue;
	            }
	            System.out.println(findTrailingZeros(factorial));
	        }
	    }

	    public static long findTrailingZeros(long n) {
	        long c = 0;
	        for (int i = 5; n / i >= 1; i *= 5) {
	            c += n / i;

	        }
	        return c;

	    }

}
