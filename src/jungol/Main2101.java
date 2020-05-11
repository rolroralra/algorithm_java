package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main2101 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		if (n > 10000 || n < 1) { System.exit(1); }
		
		double[] a = new double[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextDouble();
		}
		in.close();
		
		double[] maxValues = new double[n];
		for (int i = 0; i < n; i++) {
			double max = a[i];
			double temp = a[i];
			for (int j = i + 1; j < n; j++) {
				temp *= a[j];
				//if (a[j] >= 1 && temp > max) {
				if (temp > max) {
					max = temp;
				}
			}
			maxValues[i] = max;
		}
		Arrays.sort(maxValues);
		System.out.printf("%.3f",maxValues[n - 1]);
	}
}