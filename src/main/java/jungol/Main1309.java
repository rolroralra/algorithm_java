package jungol;

import java.util.Scanner;

public class Main1309 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.close();
		if (n < 1 || n > 15) {
			System.exit(1);
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(String.valueOf(n - i) + "! = " + String.valueOf(n - i) 
					+ ((n - i == 1) ? "" : " * " + String.valueOf(n - i - 1) + "!"));
		}
		//System.out.println(factorial(n));
		
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		System.out.println(result);
	}
	
	/*public static long factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}*/

}
