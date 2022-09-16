package jungol;

import java.util.Scanner;

public class Main1304 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(i + 1 + n * j + " ");
			}
			System.out.println();
		}
	}
}
