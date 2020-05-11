package jungol;

import java.util.Scanner;

public class Main1707 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
		int[][] a = new int[n][n];
		
		int num = 1;
		int row = 0;
		int col = -1;
		while(true) {
			for (int i = 0; i < n; i++) {
				a[row][++col] = num++;
			}
			
			if(--n == 0) {
				break;
			}
			
			for (int i = 0; i < n; i++) {
				a[++row][col] = num++;
			}
			
			for (int i = 0; i < n; i++) {
				a[row][--col] = num++;
			}
			
			if (--n == 0) {
				break;
			}
			
			for (int i = 0; i < n; i++) {
				a[--row][col] = num++;
			}
		}
		
		for (int [] i : a) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
