package jungol;

import java.awt.event.ActionListener;
import java.util.Scanner;


public class Main1641___LSH {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		int count = 0;
		if (n % 2 == 0) {
			System.out.println("INPUT ERROR!");
			System.exit(4);
		} else if (n <= 0 || n > 100) {
			System.out.println("INPUT ERROR!");
			System.exit(4);
		} else if (m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
			System.exit(4);
		} else if (m == 1) {
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 1) {
					for (int j = 1; j <= i; j++) {
						System.out.print(++count + " ");
					}
					System.out.println();
				} else {
					count = count + i;
					int temp = count;
					for (int j = 1; j <= i; j++) {
						System.out.print(temp-- + " ");
					}
					System.out.println();
				}
			}
		} else if (m == 2) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j < i; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= (2 * (n - i)) + 1; j++) {
					System.out.print(i - 1 + " ");
				}
				System.out.println();
			}

		} else if (m == 3) {
			for (int i = 1; i <= n; i++) {
				if (i <= n / 2 + 1) {
					for (int j = 1; j <= i; j++) {
						System.out.print(j + " ");
					}
					System.out.println();
				} else {
					for (int j = 1; j <= n - i + 1; j++) {
						System.out.print(j + " ");
					}
					System.out.println();
				}
			}
		}
	}
}
