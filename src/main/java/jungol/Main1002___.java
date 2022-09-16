package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main1002___ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n;
		while ((n = in.nextInt()) > 10 || n < 2) ;
		
		int[] a = new int[n];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		
		int gcd = a[0];
		int lcm = a[0];
		for (int i = 1; i < a.length; i++) {
			gcd = gcd(gcd, a[i]);
			lcm = lcm(lcm, a[i]);
		}
		System.out.println(gcd + " " + lcm);
	}
	
	public static int gcd(int a, int b) {
		while (a % b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}
	
	
	public static int lcm(int a, int b) {
		return a * b / gcd(a,b);
	}
}
