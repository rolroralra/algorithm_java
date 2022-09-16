package jungol;

import java.util.Scanner;

public class Main1303 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		in.close();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(m * i + j + 1 + " ");
			}
			System.out.println();
		}
	}
}
