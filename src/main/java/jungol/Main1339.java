package jungol;

import java.util.Scanner;

public class Main1339 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n;

		while ((n = in.nextInt()) > 100 || n <= 0 || n % 2 == 0) {
			System.out.println("INPUT ERROR");
		}

		for (int i = 1; i <= n; i++) {
			char startChar = (char)('A' + ((int)(Math.pow((n - 1) / 2, 2) + i - 1) % ('Z' - 'A' + 1)));	
			System.out.print(startChar + " ");
			int num = (n + 1) / 2 - Math.abs((n + 1) / 2 - i);
			for (int j = 1; j < num; j++) {
				System.out.print((startChar = getChar((startChar -= ((n + 1 - 2 * j) % ('Z' - 'A' + 1))))) + " ");
			}
			System.out.println();
		}
	}

	public static char getChar(int a) {
		return (a - 'A' >= 0 ? (char) ((a - 'A') % ('Z' - 'A' + 1) + 'A')
				: getChar(a + 'Z' - 'A' + 1));
	}

	/*public static char getChar(int a) {
		return (a < 0) ? (char) (a + 'Z' - 'A' + 1 + 'A') : (char) (a + 'A');
	}*/

}
