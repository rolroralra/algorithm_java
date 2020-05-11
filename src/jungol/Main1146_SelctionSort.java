package jungol;

import java.util.Scanner;

public class Main1146_SelctionSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		
		for (int i = 0; i < n - 1; i++) {
			int index = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[i]) {
					index = j;
				}
			}
			int temp = a[i];
			a[i] = a[index];
			a[index] = temp;
			
			for (int j = 0; j < n; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
	}
}
