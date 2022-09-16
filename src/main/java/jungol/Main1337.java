package jungol;

import java.util.Scanner;

public class Main1337 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n;

		while ((n = in.nextInt()) > 100 || n <= 0)
			;

		in.close();

		int[][] a = new int[n][];

		for (int i = 0; i < a.length; i++) {
			a[i] = new int[i + 1];
		}

		int row = -1;
		int col = -1;
		int index = 0;
		int count = n;

		for (int i = 0; i < n; i++) {
			switch (i % 3) {
			case 0:
				for (int j = 0; j < count; j++) {
					a[++row][++col] = index++;
					if (index >= 10)
						index = 0;
				}
				break;
			case 1:
				for (int j = 0; j < count; j++) {
					a[row][--col] = index++;
					if (index >= 10)
						index = 0;
				}
				break;
			case 2:
				for (int j = 0; j < count; j++) {
					a[--row][col] = index++;
					if (index >= 10)
						index = 0;
				}
				break;
			}
			count--;
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
