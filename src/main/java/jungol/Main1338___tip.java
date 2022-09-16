package jungol;

import java.util.Scanner;


public class Main1338___tip {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n;
		
		while ((n = in.nextInt()) > 100 || n <= 0) ;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print("  ");
			}
			//char startChar = (char)('A' + (i % 26));
			char startChar = getChar('A' + i);
			System.out.print(startChar + " ");
			for (int j = 1; j < i + 1; j++) {
				System.out.print(getChar(startChar += n - j) + " ");
			}
			System.out.println();
		}
	}
	public static char getChar(int a) {
		return (char)((a - 'A') % ('Z' - 'A' + 1) + 'A');
	}
}
