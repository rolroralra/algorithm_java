package jungol;

import java.util.Scanner;

public class Main1157_BubbleSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		
		for (int i = 1; i <= n - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < n - i; j++) {
				if (a[j] > a[j + 1]) {
					flag = false;
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			if (flag) {
				break;
			}
			for (int j = 0; j < n; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
	}
}
