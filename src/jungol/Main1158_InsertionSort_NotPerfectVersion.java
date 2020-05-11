package jungol;

import java.util.Scanner;

public class Main1158_InsertionSort_NotPerfectVersion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		
		for (int i = 1; i < n; i++) {
			int index = i;
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					index = j;
					break;
				}
			}
			int temp = a[i];
			for (int j = i - 1; j >= index; j--) {
				a[j + 1] = a[j];
			}
			a[index] = temp;
			for (int j = 0; j < n; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
	}
}
