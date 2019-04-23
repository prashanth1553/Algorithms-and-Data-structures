package com.smi;

import java.util.Scanner;

public class OverlappingRectangles {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] rect1 = scanner.nextLine().trim().split(" ");
			long r1x1 = Long.parseLong(rect1[0]);
			long r1y1 = Long.parseLong(rect1[1]);
			long r1x2 = Long.parseLong(rect1[2]);
			long r1y2 = Long.parseLong(rect1[3]);

			String[] rect2 = scanner.nextLine().trim().split(" ");
			long r2x1 = Long.parseLong(rect2[0]);
			long r2y1 = Long.parseLong(rect2[1]);
			long r2x2 = Long.parseLong(rect2[2]);
			long r2y2 = Long.parseLong(rect2[3]);
			long w1 = r1x2 - r1x1;
			long h1 = r1y2 - r1y1;
			long w2 = r2x2 - r2x1;
			long h2 = r2y2 - r2y1;

			long area1 = w1 * h1;
			long area2 = w2 * h2;
			long totalArea = area1 + area2; // (area1 > 0 ? area1 : (area1 * -1)) * (area2 > 0 ? area2 : (area2 * -1));
			// System.out.println("totalArea = " + totalArea);
			boolean isXR2InBetweenR1 = (r1x1 <= r2x1 && r1x2 >= r2x1) || (r1x1 <= r2x2 && r1x2 >= r2x2);
			boolean isXR1InBetweenR2 = (r2x1 <= r1x1 && r2x2 >= r1x1) || (r2x1 <= r1x2 && r2x2 >= r1x2);
			boolean isYR2InBetweenR1 = (r1y1 <= r2y1 && r1y2 >= r2y1) || (r1y1 <= r2y2 && r1y2 >= r2y2);
			boolean isYR1InBetweenR2 = (r2y1 <= r1y1 && r2y2 >= r1y1) || (r2y1 <= r1y2 && r2y2 >= r1y2);
			long commanArea = 0;
			if ((isXR2InBetweenR1 || isXR1InBetweenR2) && (isYR2InBetweenR1 || isYR1InBetweenR2)) {
				long width = 0;
				long hight = 0;
				// case 1 b0th with same width
				if (r1x1 <= r2x1 && r1x2 >= r2x2) {
					width = r2x2 - r2x1;
				} else if (r2x1 <= r1x1 && r2x2 >= r1x2) {
					width = r1x2 - r1x1;
				} else if (r2x1 <= r1x1 && r1x2 >= r2x2) {
					width = r2x2 - r1x1;
				} else if (r1x1 <= r2x1 && r2x2 >= r1x2) {
					width = r1x2 - r2x1;
				}

				if (r1y1 <= r2y1 && r1y2 >= r2y2) {
					hight = r2y2 - r2y1;
				} else if (r2y1 <= r1y1 && r2y2 >= r1y2) {
					hight = r1y2 - r1y1;
				} else if (r2y1 <= r1y1 && r1y2 >= r2y2) {
					hight = r2y2 - r1y1;
				} else if (r1y1 <= r2y1 && r2y2 >= r1y2) {
					hight = r1y2 - r2y1;
				}
				commanArea = width * hight;
				// System.out.println("commanArea = " + commanArea);
				//

			}
			// System.out.println("result area = " + (totalArea - commanArea));
			System.out.println((totalArea - commanArea));

		}
	}
}
