package jungol;

import java.util.Scanner;

public class Main1495 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n;

		while ((n = in.nextInt()) > 100 || n <= 0)
			;
		
		int[][] a = new int[n][n];
		in.close();
		
		int row = 0;
		int col = 0;
		int index = 1;
		boolean flag = false;
		
		for (int i = 1; i <= 2 * n - 1; i++) {
			a[row][col] = index++;
			for (int j = 1; j < n - Math.abs(i - n); j++) {
				if (flag) 
					a[--row][++col] = index++;
				else 
					a[++row][--col] = index++;
			}
			
			if (flag) {
				if (i < n)
					col++;
				else 
					row++;
				flag = false;
			}
			else {
				if (i < n)
					row++;
				else
					col++;
				flag = true;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}
}
