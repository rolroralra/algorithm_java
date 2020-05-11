package jungol;

import java.util.Scanner;

public class Main2071 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n, m;

		while ((n = in.nextInt()) > 30 || n <= 0)
			;
		while ((m = in.nextInt()) > 3 || m <= 0)
			;
		in.close();
		
		int[][] a = new int[n][];
		for (int i = 0; i < a.length; i++) {
			a[i] = new int[i + 1];
		}
		
		for (int i = 0; i < a.length; i++) {
			a[i][0] = a[i][a[i].length - 1] = 1;
			for (int j = 1; j < a[i].length - 1; j++) {
				a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
			}
		}
		
		switch (m) {
		case 1:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < a[a.length - i - 1].length; j++) {
					System.out.print(a[a.length - i - 1][j] + " ");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 0; i < n; i++) {
				int row = n - 1;
				int col = n - 1 - i;
				for (int j = 0; j < i + 1; j++) {
					//System.out.print(a[row--][col--] + " ");
					System.out.print(a[row--][col] + " ");
				}
				System.out.println();
			}
			break;
		}
	}
}
