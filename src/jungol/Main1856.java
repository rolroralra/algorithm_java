package jungol;

import java.util.Scanner;

public class Main1856 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(); // 높이
		int m = in.nextInt(); // 너비
		
		for (int i = 0; i < n; i++) {
			int num;
			int d;
			if (i % 2 == 0) {
				num = m * i + 1;
				d = 1;
			}
			else {
				num = m * (i + 1);
				d = -1;
			}
			for (int j = 0; j < m; j++) {
				System.out.print(num + " ");
				num += d;
			}
			System.out.println();
		}
	}
}
