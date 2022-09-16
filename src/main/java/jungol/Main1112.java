package jungol;

import java.util.Scanner;

public class Main1112 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double length;
		double[] rPosition = new double[2];
		double[] bPosition = new double[2];
		double[] yPosition = new double[2];

		length = in.nextDouble();
		if (length > 1000 || length < 10) {
			System.exit(1);
		}

		for (int i = 0; i < 3; i++) {
			double[] positions = null;
			switch (i) {
			case 0:
				positions = rPosition;
				break;
			case 1:
				positions = bPosition;
				break;
			case 2:
				positions = yPosition;
				break;
			}
			for (int j = 0; j < 2; j++) {
				positions[j] = in.nextDouble();
			}
		}
		in.close();
		
		if (rPosition[0] != rPosition[1]) {
			length = fold(length, (rPosition[0] + rPosition[1]) / 2, 
					      rPosition, bPosition, yPosition);
		}
		if (bPosition[0] != bPosition[1]) {
			length = fold(length, (bPosition[0] + bPosition[1]) / 2, 
					      rPosition, bPosition, yPosition);
		}
		if (yPosition[0] != yPosition[1]) {
			length = fold(length, (yPosition[0] + yPosition[1]) / 2, 
						  rPosition,bPosition, yPosition);
		}
		System.out.printf("%.1f", length);
	}

	public static double fold(double length, double centerPosition,
			double[] rPosition, double[] bPosition, double[] yPosition) {

		boolean isFoldingTail = (centerPosition > length / 2 ? true : false);

		for (int i = 0; i < 3; i++) {
			double[] positions = null;
			switch (i) {
			case 0:
				positions = rPosition;
				break;
			case 1:
				positions = bPosition;
				break;
			case 2:
				positions = yPosition;
				break;
			}

			for (int j = 0; j < 2; j++) {
				if (isFoldingTail) {
					if (positions[j] > centerPosition && positions[j] <= length) {
						positions[j] -= 2 * (positions[j] - centerPosition);
					}
				} else {
					if (positions[j] < centerPosition && positions[j] >= 0) {
						positions[j] += 2 * (centerPosition - positions[j]);
					}
					positions[j] -= centerPosition;
				}
			}
		}
		return (isFoldingTail ? centerPosition : length - centerPosition);
	}
}
