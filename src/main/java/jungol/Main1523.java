package jungol;

import java.util.Scanner;


public class Main1523 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n, m;
		
		while ((n = in.nextInt()) > 100 || n <= 0) {
			System.out.println("INPUT ERROR!");
		}
		
		while ((m = in.nextInt()) > 3 || m <= 0) {
			System.out.println("INPUT ERROR!");
		}
		
		switch (m) {
		
		case 1:
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < n - i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * i - 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
	}
}
