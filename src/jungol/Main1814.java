package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main1814 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		if (n > 50 || n < 1) {
			System.exit(1);
		}
		
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		int count = 0;
		for (int i = 1; i < n; i++) {
			int index = i;
			for (int j = 0 ; j < i; j++) {
				if (a[i] < a[j]) {
					index = j;
					break;
				}
			}
			
			if (index != i) {
				int temp = a[i];
				for (int j = i; j > index ; j--) {
					a[j] = a[j - 1];
					count++;
				}
				a[index] = temp;
				//count++;
			}
		}
		System.out.println(count);
	}
}
