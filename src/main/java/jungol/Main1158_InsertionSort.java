package jungol;

import java.util.Scanner;

public class Main1158_InsertionSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.close();
		
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
				
			}
//			for (int j = i; j > 0; j--) {
//				if (a[j] < a[j - 1]) {
//					int temp = a[j];
//					a[j] = a[j - 1];
//					a[j - 1] = temp;
//				}
//				else {
//					break;
//				}
//			}
			for (int j = 0; j < n; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
		
	}
}
