package jungol;

import java.util.Scanner;

public class Main1997 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int day = in.nextInt();
		int numReceived = in.nextInt();
		in.close();
		if (day > 30 || day < 3 || numReceived > 100000 || numReceived < 10) {
			System.exit(1);
		}
		int resultA = 0;
		int resultB = 0;
		int coefficientA = fibonacci(day);
		int coefficientB = fibonacci(day + 1);
		int n = numReceived / coefficientA;
		for (int i = 0; i <= n; i++) {
			if ((numReceived - i * coefficientA) % coefficientB == 0) {
				resultA = i;
				resultB = (numReceived - i * coefficientA) / coefficientB;
				System.out.println(resultA + " " + resultB);
				continue;
			}
		}
		/*System.out.println(resultA);
		System.out.println(resultB);*/
	}

	public static int fibonacci(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 0;
		}
		return (fibonacci(n - 1) + fibonacci(n - 2));
	}
}