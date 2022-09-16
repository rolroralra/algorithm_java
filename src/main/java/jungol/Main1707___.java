package jungol;

import java.util.Scanner;


public class Main1707___ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[][] a = new int[n][n];
		int count = 1;
		for (int i = 0; i < n; i++) {
			a[0][i] = count++;
		}
		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 1;
		int colEnd = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			if ((n%2==1 && i % 2 == 0) || (n%2==0 && i%2==1)) {
				for (int j = colStart; j <= colEnd; j++) {
					a[j][rowEnd] = count++;
				}
				rowEnd--;
				for (int j = rowEnd; j >= rowStart; j--) {
					a[colEnd][j] = count++;
				}
				colEnd--;
			} else {
				for (int j = colEnd; j >= colStart; j--) {
					a[j][rowStart] = count++;
				}
				rowStart++;
				for (int j = rowStart; j <= rowEnd; j++) {
					a[colStart][j] = count++;
				}
				colStart++;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
