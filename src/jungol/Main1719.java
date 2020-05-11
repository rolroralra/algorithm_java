package jungol;

import java.util.Scanner;

public class Main1719 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n, m;

		while ((n = in.nextInt()) > 100 || n <= 0 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
		}

		while ((m = in.nextInt()) > 4 || m <= 0) {
			System.out.println("INPUT ERROR!");
		}

		switch (m) {
		case 1:
			for (int i = 1; i <= n; i++) {
				int num = (n + 1) / 2 - Math.abs((n + 1) / 2 - i);
				for (int j = 0; j < num; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				int num = Math.abs((n - 1) / 2 - i);
				for (int j = 0; j < num; j++)
					System.out.print(" ");
				num = Math.abs((n - 1) / 2 - i);
				for (int j = num; j < (n + 1) / 2; j++)
					System.out.print("*");
				System.out.println();
			}
			break;
		case 3:
			for (int i = 0; i < n; i++) {
				int num = (n - 1) / 2 - Math.abs((n - 1) / 2 - i);
				for (int j = 0; j < num; j++) {
					System.out.print(" ");
				}
				num = 1 + Math.abs(n - 1 - 2 * i);
				for (int j = 0; j < num; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 4:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < (i >= (n - 1) / 2 ? (n - 1) / 2 : i); j++) {
					System.out.print(" ");
				}
				int num = 1 + Math.abs((n - 1) / 2 - i);
				for (int j = 0; j < num; j++)
					System.out.print("*");
				System.out.println();
			}
			break;
		}
	}
}
