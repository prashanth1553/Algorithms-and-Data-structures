package com.sorting;

import com.models.Cat;

public class MainClass {

	
	public static void main(String args[]) {

		Cat c1 = new Cat("5");
		Cat c2 = new Cat("4");
		Cat c3 = new Cat("6");
		Cat c4 = new Cat("3");
		Cat c5 = new Cat("1");
		Cat c7 = new Cat("2");
		Cat c6 = new Cat("7");
		Cat[] array = new Cat[] { c1, c2, c3, c4, c5, c6, c7 };
		QuickSorting.sort(array);
		for (Cat c : array)
			System.out.println(c.getColor());
		
		System.out.println("partition count "+QuickSorting.partitionCount);
	}
}
