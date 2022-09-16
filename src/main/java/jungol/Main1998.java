package jungol;

import java.util.Scanner;

public class Main1998 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		if (n > 100000 || n < 1) {
			System.exit(1);
		}
		if (n == 1) {
			System.out.println(1);
			return;
		}
		
		int[] a = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		int max = 2;
		int length = 2;
		int count_equal = 1;
		boolean isAscending = a[0] < a[1];
		for (int i = 1; i < n - 1; i++) {
			if (a[i] < a[i + 1]) {
				if (isAscending) {
					length++;
				}
				else {
					length = count_equal + 1;
				}
				count_equal = 1;
				isAscending = true;
			}
			else if (a[i] > a[i + 1]) {
				if (!isAscending) {
					length++;
				}
				else {
					length = count_equal + 1;
				}
				count_equal = 1;
				isAscending = false;
			}
			else {
				length++;
				count_equal++;
			}
			if (length > max) {
				max = length;
			}
		}
		System.out.println(max);
	}
}
