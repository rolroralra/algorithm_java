package jungol;

import java.util.Scanner;

public class Main1314 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		char[][] a = new char[n][n];
		char c = 'A';
		
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < n; j++) {
					a[j][i] = c++;
					if (c == 'Z' + 1) {
						c = 'A';
					}
				}
			}
			else {
				for (int j = n - 1; j >= 0; j--) {
					a[j][i] = c++;
					if (c == 'Z' + 1) {
						c = 'A';
					}
				}
			}
		}
		
		for (char[] ca : a) {
			for (char ct : ca) {
				System.out.print(ct + " ");
			}
			System.out.println();
		}
	}
}
