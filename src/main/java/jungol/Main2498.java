package jungol;

import java.util.Scanner;

public class Main2498 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int gcd, lcm;
		
		while ((gcd = in.nextInt()) < 2 || gcd > 100000000) ;
		while ((lcm = in.nextInt()) < 2 || lcm > 100000000) ;
		in.close();
		
		int mulReduced = lcm / gcd;
		double sqrt = Math.sqrt(mulReduced);
		int lastIndex = (int)sqrt;
		if (sqrt == lastIndex && mulReduced != 1) {
			lastIndex--;
		}
		
		int result = lastIndex;
		for (int i = lastIndex; i >= 1; i--) {
			if (mulReduced % i == 0 && gcd(i, mulReduced / i) == 1) {
				result = i;
				break;
			}
		}
		System.out.println(result * gcd + " " + mulReduced / result * gcd );
		
	}

	public static int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (a % b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}

	public static long lcm(int a, int b) {
		return (long)a * b / gcd(a, b);
	}
}
