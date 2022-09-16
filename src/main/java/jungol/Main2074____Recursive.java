package jungol;

import java.util.Scanner;


public class Main2074____Recursive {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n;
		
		while ((n = in.nextInt()) > 100 || n <= 2 || n % 2 == 0) {
			System.out.println("Input Error!");
		}
		
		int[][] a = new int[n][n];
		
		int index = 0;						// 재귀함수 통해서 마방진 출력하자!
		int row = -1;
		int col = n / 2;
		for (int i = 0; i < n; i++) {
			//a[(++row == n) ? (row = 0) : row][col] = ++index;
			a[++row][col] = ++index;
			for (int j = 1; j < n; j++) {
				a[(--row == -1) ? (row = n - 1) : row][(--col == -1) ? (col = n - 1) : col] = ++index;
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
