package com.smi;

import java.util.Scanner;

public class LcmAndHcf {

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
		int t = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < t; i++) {
            String[] arItems = scanner.nextLine().split(" ");
            long a = Long.parseLong(arItems[0]);
            long b = Long.parseLong(arItems[1]);
            long gcd = gcd(a, b);
            System.out.println(lcm(a, b, gcd) + " " + gcd);
        }
    }

    public static long gcd(long a, long b) {
    	long s, l;
        if (a > b) {
            l = a;
            s = b;
        } else {
            l = b;
            s = a;
        }

        while (s != 0) {
        	long temp = l % s;
            if (temp == 0) {
                break;
            }
            s = temp;
            l = s;
        }
        return s;
    }

    public static long lcm(long a, long b, long gcd) {
        return (((long) a * b)) / gcd;
    }

}
