package jungol;

import java.util.Scanner;


public class Main1329 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n;
		
		while ((n = in.nextInt()) > 100 || n <= 0 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
		}
		in.close();
		
		for (int i = 0; i < n; i++) {
			int num = (n - 1) / 2 - Math.abs((n - 1) / 2 - i);
			for (int j = 0; j < num; j++) {
				System.out.print(" ");
			}
			
			num = n - Math.abs((n - 1) - 2 * i);
			for (int j = 0; j < num; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
