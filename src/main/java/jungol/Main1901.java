package jungol;

import java.util.Scanner;

public class Main1901 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n;

		while ((n = in.nextInt()) > 100 || n < 1)
			;
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			while ((a[i] = in.nextInt()) > 1000000 || a[i] < 1)
				;
		}
		in.close();

		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}

		boolean[] flagComposite = new boolean[max * 2 - 2];
		estosthenes(flagComposite);

		int[] result = new int[2];
		for (int i = 0; i < n; i++) {
			result[0] = (result[1] = 0);
			
			for (int j = 1; j <= a[i] - 2; j++) {
				if (!flagComposite[a[i] - 1]) {
					result[0] = a[i];
					break;
				}
				boolean flag = false;
				if (!flagComposite[a[i] - j - 1]) {
					result[0] = a[i] - j;
					flag = true;
				}
				if (!flagComposite[a[i] + j - 1]) {
					result[1] = a[i] + j;
					flag = true;
				}
				if (flag) {
					break;
				}
			}
			for (int j = 0; j < 2; j++) {
				if (result[j] != 0) {
					System.out.print(result[j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void estosthenes(boolean[] a) {
		a[0] = true;
		int size = a.length;
		for (int i = 1; (i + 1) * (i + 1) <= size; i++) {
			if (!a[i]) {
				int lastDividerNum = size / (i + 1);
				for (int j = 2; j <= lastDividerNum; j++) {
					a[(i + 1) * j - 1] = true;
					// System.out.println(((i + 1) * j) + " Not Prime");
				}
			}
		}
	}
}
