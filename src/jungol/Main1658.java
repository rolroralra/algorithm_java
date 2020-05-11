package jungol;

import java.util.Scanner;

public class Main1658 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		in.close();
		
		int gcd = gcdByRecursive(a, b);
		System.out.println(gcd);
		
		System.out.println(a * b / gcd);
	}
	
	/*public static int gcd(int a, int b) {
		if (a < b) {					// 
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
	}*/
	
	public static int gcdByRecursive(int a, int b) {
		int numSmall = (a > b) ? b : a;
		int remain = (a > b) ? a % b : b % a;
		
		if (remain == 0) {
			return numSmall;
		}
		return gcdByRecursive(numSmall, remain);
	}
}
