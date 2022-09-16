package jungol;

import java.util.Scanner;

public class Main1307 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
		
		char[][] a = new char[n][n];
		
		char c = 'A';
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				a[j][i] = c++;
				if (c == 'Z' + 1) {
					c = 'A';
				}
			}
		}
		
//		int col = n - 1;
//		for (int i = 0; i < n; i++) {
//			int row = n;
//			for (int j = 0; j < n; j++) {
//				a[--row][col] = (char)c++;
//				if (c == (char)('Z' + 1)) {
//					c = 'A';
//				}
//			}
//			col--;
//		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
